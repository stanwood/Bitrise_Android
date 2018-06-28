package io.stanwood.bitrise.ui.builds.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.res.Resources
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.joda.time.format.PeriodFormatter
import timber.log.Timber


class BuildsViewModel(private val router: NavController,
                      private val service: BitriseService,
                      private val token: String,
                      private val resources: Resources,
                      private val periodFormatter: PeriodFormatter,
                      private val app: App) : LifecycleObserver {

    val isLoading = ObservableBoolean(false)
    val items = ObservableArrayList<BuildItemViewModel>()
    val title: String
        get() = app.title

    private var deferred: Deferred<Any>? = null
    private var nextCursor: String? = null
    private val shouldLoadMoreItems: Boolean
        get() = !isLoading.get() && nextCursor != null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        onRefresh()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        onRefresh()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        deferred?.cancel()
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

    fun onStartNewBuild() = router.navigate(R.id.screen_new_build)

    private fun loadMoreItems() {
        deferred = async(UI) {
            try {
                isLoading.set(true)
                fetchItems()
                    .forEach { viewModel ->
                        items.add(viewModel)
                    }
            } catch (exception: Exception) {
                Timber.e(exception)
                bundleOf(Properties.MESSAGE to null).apply {
                    router.navigate(R.id.action_error, this)
                }
            } finally {
                isLoading.set(false)
            }
        }
    }

    private suspend fun fetchItems() =
        service
            .getBuilds(token, app.slug, nextCursor)
            .await()
            .apply { nextCursor = paging.nextCursor }
            .data
            .map { build -> BuildItemViewModel(resources, periodFormatter, router, build, token) }
}