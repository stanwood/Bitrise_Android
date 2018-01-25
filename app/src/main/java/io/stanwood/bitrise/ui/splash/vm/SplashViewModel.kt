package io.stanwood.bitrise.ui.splash.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.service.BitriseService
import io.stanwood.bitrise.navigation.SCREEN_DASHBOARD
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import ru.terrakok.cicerone.Router
import timber.log.Timber


class SplashViewModel(
        private val router: Router,
        private val service: BitriseService): LifecycleObserver {

    private var deferred: Deferred<Any>? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
        deferred = async(UI) {
            try {
                service
                    .login(BuildConfig.BITRISE_API_TOKEN)
                    .await()
                router.newRootScreen(SCREEN_DASHBOARD)
            } catch (exception: Exception) {
                Timber.e(exception)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        deferred?.cancel()
    }
}