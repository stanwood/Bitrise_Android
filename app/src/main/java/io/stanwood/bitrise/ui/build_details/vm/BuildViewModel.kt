package io.stanwood.bitrise.ui.build_details.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.ui.build_details.ui.FragmentAdapter


class BuildViewModel(
        val adapter: FragmentAdapter,
        private val app: App,
        private val build: Build): LifecycleObserver {

    val title: String
        get() = "${app.title} #${build.number}"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {

    }
}