package io.stanwood.bitrise.ui.builds.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.res.Resources
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.service.BitriseService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.joda.time.format.PeriodFormatter
import ru.terrakok.cicerone.Router
import timber.log.Timber


class BuildsViewModel(private val router: Router,
                      private val service: BitriseService,
                      private val resources: Resources,
                      private val periodFormatter: PeriodFormatter,
                      private val app: App) : LifecycleObserver {

    val isLoading = ObservableBoolean(false)
    val items = ObservableArrayList<BuildItemViewModel>()
    val title: String
        get() = app.title

    private var deferred: Deferred<Any>? = null
    private var nextCursor: String? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
        onRefresh()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        deferred?.cancel()
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
            .getBuilds(BuildConfig.BITRISE_API_TOKEN, app.slug)
            .await()
            .apply { nextCursor = paging.nextCursor }
            .data
            .map { build -> BuildItemViewModel(resources, periodFormatter, router, build) }
}