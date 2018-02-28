package io.stanwood.bitrise.ui.builds.vm

import android.arch.lifecycle.*
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PageKeyedDataSource
import android.content.res.Resources
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import io.stanwood.bitrise.util.databinding.BitriseDiffCallback
import io.stanwood.bitrise.util.databinding.BitriseLiveData
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.joda.time.format.PeriodFormatter
import ru.terrakok.cicerone.Router
import timber.log.Timber


class BuildsViewModel(private val router: Router,
                      private val service: BitriseService,
                      private val token: String,
                      private val resources: Resources,
                      private val periodFormatter: PeriodFormatter,
                      private val app: App) : LifecycleObserver, PageKeyedDataSource<String, BuildItemViewModel>() {

    var isLoading = false
    var items: BitriseLiveData = createLiveData()

    // TODO the initial call is made with limit 30 for some reason
    private fun createLiveData(): BitriseLiveData =
            LivePagedListBuilder<String, BuildItemViewModel>({ this }, BuildConfig.DEFAULT_PAGE_SIZE).build() as BitriseLiveData

    val title: String
        get() = app.title
    val diffCallback: BitriseDiffCallback = DiffCallback() as BitriseDiffCallback

    private var deferred: Deferred<Any>? = null

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
        items = createLiveData()
    }

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, BuildItemViewModel>) {
        deferred = async(UI) {
            try {
                isLoading = true
                service
                        .getBuilds(token, app.slug, null, params.requestedLoadSize)
                        .await()
                        .apply {
                            callback.onResult(
                                    data.map { build -> BuildItemViewModel(resources, periodFormatter, router, build) },
                                    null,
                                    paging.nextCursor
                            )
                        }
            } catch (exception: Exception) {
                Timber.e(exception)
                router.navigateTo(SCREEN_ERROR, exception.message)
            } finally {
                isLoading = false
            }
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, BuildItemViewModel>) {
        deferred = async(UI) {
            try {
                isLoading = true
                service
                        .getBuilds(token, app.slug, params.key, params.requestedLoadSize)
                        .await()
                        .apply {
                            callback.onResult(
                                    data.map { build -> BuildItemViewModel(resources, periodFormatter, router, build) },
                                    paging.nextCursor
                            )
                        }
            } catch (exception: Exception) {
                Timber.e(exception)
                router.navigateTo(SCREEN_ERROR, exception.message)
            } finally {
                isLoading = false
            }
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, BuildItemViewModel>) {
        // no-op
    }

}

class DiffCallback : android.support.v7.recyclerview.extensions.DiffCallback<BuildItemViewModel>() {
    override fun areItemsTheSame(oldItem: BuildItemViewModel, newItem: BuildItemViewModel) =
            oldItem.number == newItem.number

    override fun areContentsTheSame(oldItem: BuildItemViewModel, newItem: BuildItemViewModel) =
            oldItem == newItem
}