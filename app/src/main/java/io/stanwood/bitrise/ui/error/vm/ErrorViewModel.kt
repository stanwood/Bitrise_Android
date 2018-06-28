package io.stanwood.bitrise.ui.error.vm

import android.arch.lifecycle.LifecycleObserver
import androidx.navigation.NavController


class ErrorViewModel(
        private val router: NavController,
        private val msg: String): LifecycleObserver {
    val message: String
        get() = msg

    fun onRetryClick() {
        router.popBackStack()
    }
}