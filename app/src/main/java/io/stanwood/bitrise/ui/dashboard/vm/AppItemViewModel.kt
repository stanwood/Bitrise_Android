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

import android.content.SharedPreferences
import android.content.res.Resources
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import android.graphics.drawable.Drawable
import androidx.navigation.NavController
import io.stanwood.bitrise.BR
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.data.model.BuildStatus
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import org.ocpsoft.prettytime.PrettyTime
import timber.log.Timber


class AppItemViewModel(
        private val service: BitriseService,
        private val token: String,
        private val resources: Resources,
        private val router: NavController,
        private val sharedPreferences: SharedPreferences,
        private val app: App) : BaseObservable() {

    val title: String
        get() = app.title

    val repoOwner: String
        get() = "${app.repoOwner}/"

    val icon: Drawable?
        get() = app.projectType?.getIcon(resources)

    @get:Bindable
    val lastBuildTime: String?
        get() {
            return if(lastBuild?.status == BuildStatus.IN_PROGRESS) {
                lastBuild?.status?.getTitle(resources)
            } else {
                lastBuild?.finishedAt?.let { PrettyTime().format(it) }
            }
        }

    @get:Bindable("lastBuildTime")
    val buildStatusColor: Int
        get() = lastBuild?.status?.getColor(resources) ?: 0

    @get:Bindable("lastBuildTime")
    val buildStatusIcon: Drawable?
        get() = lastBuild?.status?.getIcon(resources)

    @get:Bindable
    var isFavorite: Boolean
        get() =
            sharedPreferences
                    .getStringSet(Properties.FAVORITE_APPS, null)
                    ?.contains(app.slug)
                    ?: false
        set(value) {
            val favoriteAppsSlugs =
                sharedPreferences
                    .getStringSet(Properties.FAVORITE_APPS, null)
                    /**
                     * Please note, that we cannot modify a set returned from SharedPreferences::getStringSet, thus we
                     * have to make a copy.
                     * See <a href="https://developer.android.com/reference/android/content/SharedPreferences.html#getStringSet(java.lang.String,%20java.util.Set<java.lang.String>)">SharedPreferences::getStringSet documentation</a>
                     */
                    ?.toMutableSet()
                    ?: mutableSetOf()

            if(value == favoriteAppsSlugs.contains(app.slug)) {
                return
            }

            if(value) {
                favoriteAppsSlugs.add(app.slug)
            } else {
                favoriteAppsSlugs.remove(app.slug)
            }

            sharedPreferences
                .edit()
                .putStringSet(Properties.FAVORITE_APPS, favoriteAppsSlugs)
                .apply()
        }

    private var deferred: Deferred<Any?>? = null
    private var lastBuild: Build? = null

    fun start() {
        deferred = GlobalScope.async {
            try {
                lastBuild = fetchLastBuild()
                notifyPropertyChanged(BR.lastBuildTime)
            } catch (exception: Exception) {
                Timber.e(exception)
                bundleOf(Properties.MESSAGE to exception.message).apply {
                    router.navigate(R.id.action_error, this)
                }
            }
        }
    }

    fun stop() {
        deferred?.cancel()
    }

    fun onClick() {
        bundleOf(
                Properties.APP to app,
                Properties.TOKEN to token)
            .apply {
                router.navigate(R.id.action_dashboard_to_builds, this)
            }
    }

    private suspend fun fetchLastBuild() =
        service
            .getBuilds(token, app.slug, limit = 1)
            .await()
            .data
            .firstOrNull()
}