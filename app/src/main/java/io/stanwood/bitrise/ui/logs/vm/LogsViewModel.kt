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

package io.stanwood.bitrise.ui.logs.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.text.Html
import android.text.Spanned
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import timber.log.Timber


class LogsViewModel(
        private val service: BitriseService,
        private val token: String,
        private val router: NavController,
        private val app: App,
        private val build: Build) : LifecycleObserver, BaseObservable() {

    val isLoading = ObservableBoolean(false)
    var log = ObservableField<Spanned>()
    private var deferred: Deferred<Any>? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
        deferred = async(UI) {
            onRefresh()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        deferred?.cancel()
    }

    fun onRefresh() {
        deferred = async(UI) {
            try {
                isLoading.set(true)
                log.apply {
                    val log = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        Html.fromHtml(fetchLog(), Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml(fetchLog())
                    }
                    set(log)
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

    private suspend fun fetchLog() =
        service
            .getBuildLog(token, app.slug, build.slug)
            .await()
            .logChunks
            .sortedBy { logChunk -> logChunk.position }
            .joinToString { logChunk -> logChunk.chunk }
}