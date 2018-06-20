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

package io.stanwood.bitrise.ui.build.vm

import android.arch.lifecycle.LifecycleObserver
import android.content.res.Resources
import android.databinding.ObservableBoolean
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.*
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import io.stanwood.bitrise.ui.build.ui.FragmentAdapter
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import ru.terrakok.cicerone.Router
import timber.log.Timber


class BuildViewModel(
        private val resources: Resources,
        private val router: Router,
        private val service: BitriseService,
        val adapter: FragmentAdapter,
        private val token: String,
        private val app: App,
        private val build: Build): LifecycleObserver {

    val title: String
        get() = "${app.title} #${build.number}"

    val isLoading = ObservableBoolean(false)

    val isCurrentlyRunning
        get() = build.status == BuildStatus.IN_PROGRESS

    fun onRestartBuild() {
        async(UI) {
            try {
                isLoading.set(true)
                restartBuild().let {
                    val message = resources.getString(R.string.new_build_started, it.buildNumber)
                    router.exitWithMessage(message)
                }
            } catch (exception: Exception) {
                Timber.e(exception)
                router.navigateTo(SCREEN_ERROR, exception.message)
            } finally {
                isLoading.set(false)
            }
        }
    }

    private suspend fun restartBuild() =
        service
            .startNewBuild(token, app.slug, NewBuildParams(BuildParams(build.branch, build.triggeredWorkflow)))
            .await()
}