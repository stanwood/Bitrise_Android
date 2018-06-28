package io.stanwood.bitrise.ui.dashboard.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.SharedPreferences
import android.content.res.Resources
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import timber.log.Timber


class DashboardViewModel(private val router: NavController,
                         private val service: BitriseService,
                         private val token: String,
                         private val sharedPreferences: SharedPreferences,
                         private val resources: Resources): LifecycleObserver {

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

    private fun loadMoreItems() {
        deferred = async(UI) {
            try {
                isLoading.set(true)

                fetchAllApps()
                    .forEach { viewModel ->
                        viewModel.start()
                        items.add(viewModel)
                    }
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
            .map { app -> AppItemViewModel(service, token, resources, router, sharedPreferences, app) }
}