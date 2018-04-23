package io.stanwood.bitrise.ui.build.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.BaseObservable
import android.databinding.Bindable
import io.stanwood.bitrise.BR
import io.stanwood.bitrise.data.model.*
import io.stanwood.bitrise.data.net.BitriseTriggerService
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import io.stanwood.bitrise.ui.build.ui.FragmentAdapter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import ru.terrakok.cicerone.Router
import timber.log.Timber


class BuildViewModel(
        val adapter: FragmentAdapter,
        private val router: Router,
        private val app: App,
        private val build: Build,
        private val token: String,
        private val bitriseTriggerService: BitriseTriggerService): LifecycleObserver, BaseObservable() {

    val title: String
        get() = "${app.title} #${build.number}"

    private var loader: Deferred<Any>? = null

    @get:Bindable("isLoading")
    val isLoading: Boolean
        get() = loader?.isActive ?: false

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        loader?.cancel()
    }

    fun restart() {
        if (isLoading) return

        loader = async {
            try {
                bitriseTriggerService.start(
                        app.slug,
                        Trigger(
                                HookInfo(apiToken = token),
                                BuildParams(
                                        workflowId = build.triggeredWorkflow,
                                        commitHash = build.commitHash,
                                        tag = build.tag,
                                        branch = build.branch
                                )
                        )
                ).await()
            } catch (exception: Exception) {
                Timber.e(exception)
                router.navigateTo(SCREEN_ERROR, exception.message)
            }
        }
        notifyPropertyChanged(BR.loading)
    }
}