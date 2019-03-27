/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.stanwood.bitrise.ui.dashboard.vm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import timber.log.Timber

class DashboardViewModel(private val router: NavController,
                         private val service: BitriseService,
                         private val token: String,
                         private val sharedPreferences: SharedPreferences,
                         private val resources: Resources,
                         private val mainScope: CoroutineScope): LifecycleObserver {

    val isLoading = ObservableBoolean(false)
    val items = ObservableArrayList<AppItemViewModel>()

    private var deferred: Deferred<Any>? = null
    private var nextCursor: String? = null
    private val shouldLoadMoreItems: Boolean
        get() = !isLoading.get() && nextCursor != null
    private val favoriteAppsSlugs: Set<String>?
        get() = sharedPreferences.getStringSet(Properties.FAVORITE_APPS, null)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
        onRefresh()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        deferred?.cancel()
        items.forEach { viewModel -> viewModel.stop() }
    }

    fun onRefresh() {
        deferred?.cancel()
        items.clear()
        nextCursor = null
        loadMoreItems()
    }

    @Suppress("UNUSED_PARAMETER")
    fun onEndOfListReached(itemCount: Int) {
        if(shouldLoadMoreItems) {
            loadMoreItems()
        }
    }

    fun onLogout() {
        sharedPreferences
                .edit()
                .remove(Properties.TOKEN)
                .apply()
        router.navigate(R.id.action_logout)
    }

    fun onGoToSettings() {
        router.navigate(R.id.action_dashboard_to_settings)
    }

    private fun loadMoreItems() {
        deferred = mainScope.async {
            try {
                isLoading.set(true)
                fetchAllApps()
                    .forEach { viewModel ->
                        viewModel.start()
                        items.add(viewModel)
                    }

            } catch (exception: CancellationException) {
                /* noop */
            } catch (exception: Exception) {
                Timber.e(exception)
                bundleOf(Properties.MESSAGE to exception.message).apply {
                    router.navigate(R.id.action_error, this)
                }
            } finally {
                isLoading.set(false)
            }
        }
    }

    private suspend fun fetchFavoriteApps(): List<App> =
        favoriteAppsSlugs
            ?.map {
                service
                    .getApp(token, it)
                    .await()
                    .data
            }
            ?: emptyList()

    private suspend fun fetchNonFavoriteApps(): List<App> =
        service
            .getApps(token, nextCursor)
            .await()
            .apply { nextCursor = paging.nextCursor }
            .data
            .filter { !(favoriteAppsSlugs?.contains(it.slug) ?: false) }


    private suspend fun fetchAllApps() =
        listOf(if(items.isEmpty()) fetchFavoriteApps() else emptyList(), fetchNonFavoriteApps())
            .flatten()
            .map { app -> AppItemViewModel(service, token, resources, router, sharedPreferences, app, mainScope) }
}