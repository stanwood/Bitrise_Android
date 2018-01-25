package io.stanwood.bitrise.ui.dashboard.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.res.Resources
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.service.BitriseService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import ru.terrakok.cicerone.Router
import timber.log.Timber


class DashboardViewModel(private val router: Router,
                         private val service: BitriseService,
                         private val resources: Resources): LifecycleObserver {

    val isLoading = ObservableBoolean(false)
    val items = ObservableArrayList<AppViewModel>()

    private var deferred: Deferred<Any>? = null
    private var nextCursor: String? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
        onRefresh()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        deferred?.cancel()
        items.forEach { viewModel -> viewModel.stop() }
    }

    fun onRefresh() {
        deferred?.cancel()
        deferred = async(UI) {
            items.clear()
            nextCursor = null
            loadMoreItems()
        }
    }

    private suspend fun loadMoreItems() {
        try {
            isLoading.set(true)
            fetchItems()
                .forEach { viewModel ->
                    viewModel.start()
                    items.add(viewModel)
                }
        } catch (exception: Exception) {
            Timber.e(exception)
        } finally {
            isLoading.set(false)
        }
    }

    private suspend fun fetchItems() =
        service
            .getApps(BuildConfig.BITRISE_API_TOKEN, 50)
            .await()
            .apply { nextCursor = paging.nextCursor }
            .data
            .map { app -> AppViewModel(service, resources, router, app) }
}