package io.stanwood.bitrise.ui.build.vm

import android.arch.lifecycle.LifecycleObserver
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.ui.build.ui.FragmentAdapter


class BuildViewModel(
        val adapter: FragmentAdapter,
        private val app: App,
        private val build: Build): LifecycleObserver {

    val title: String
        get() = "${app.title} #${build.number}"
}