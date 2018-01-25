package io.stanwood.bitrise.ui.logs.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.data.service.BitriseService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import timber.log.Timber


class LogsViewModel(
        private val service: BitriseService,
        private val app: App,
        private val build: Build) : LifecycleObserver, BaseObservable() {

    val isLoading = ObservableBoolean(false)
    var log = ObservableField<String>()
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
                log.let { it.set(fetchLog()) }
            } catch (exception: Exception) {
                Timber.e(exception)
            } finally {
                isLoading.set(false)
            }
        }
    }

    private suspend fun fetchLog() =
        service
            .getBuildLog(BuildConfig.BITRISE_API_TOKEN, app.slug, build.slug)
            .await()
            .logChunks
            .sortedBy { logChunk -> logChunk.position }
            .joinToString { logChunk -> logChunk.chunk }
}