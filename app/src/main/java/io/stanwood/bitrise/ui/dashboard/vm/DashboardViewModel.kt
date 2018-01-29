package io.stanwood.bitrise.ui.dashboard.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.res.Resources
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import io.stanwood.bitrise.data.net.BitriseService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import ru.terrakok.cicerone.Router
import timber.log.Timber


class DashboardViewModel(private val router: Router,
                         private val service: BitriseService,
                         private val token: String,
                         private val resources: Resources): LifecycleObserver {

    val isLoading = ObservableBoolean(false)
    val items = ObservableArrayList<AppViewModel>()

    private var deferred: Deferred<Any>? = null
    private var nextCursor: String? = null
    private val shouldLoadMoreItems: Boolean
        get() = !isLoading.get() && nextCursor != null

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
        items.clear()
        nextCursor = null
        loadMoreItems()
    }

    fun onEndOfListReached(itemCount: Int) {
        if(shouldLoadMoreItems) {
            loadMoreItems()
        }
    }

    private fun loadMoreItems() {
        deferred = async(UI) {
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
    }

    private suspend fun fetchItems() =
        service
            .getApps(token, nextCursor)
            .await()
            .apply { nextCursor = paging.nextCursor }
            .data
            .map { app -> AppViewModel(service, token, resources, router, app) }
}