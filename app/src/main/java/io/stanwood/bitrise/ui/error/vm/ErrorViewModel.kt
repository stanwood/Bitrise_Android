package io.stanwood.bitrise.ui.error.vm

import android.arch.lifecycle.LifecycleObserver
import ru.terrakok.cicerone.Router


class ErrorViewModel(
        private val router: Router,
        private val msg: String): LifecycleObserver {
    val message: String
        get() = msg

    fun onRetryClick() {
        router.exit()
    }
}