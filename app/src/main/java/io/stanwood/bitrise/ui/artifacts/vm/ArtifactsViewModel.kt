package io.stanwood.bitrise.ui.artifacts.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Artifact
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import ru.terrakok.cicerone.Router
import timber.log.Timber


class ArtifactsViewModel(
        private val router: Router,
        private val service: BitriseService,
        private val token: String,
        private val context: Context,
        private val app: App,
        private val build: Build) : LifecycleObserver, BaseObservable() {

    val isLoading = ObservableBoolean(false)
    var log = ObservableField<String>()
    val items = ObservableArrayList<ArtifactItemViewModel>()

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
                            items.add(viewModel)
                        }
            } catch (exception: Exception) {
                Timber.e(exception)
                router.navigateTo(SCREEN_ERROR, exception.message)
            } finally {
                isLoading.set(false)
            }
        }
    }

    private suspend fun fetchItems() =
            service
                    .getBuildArtifacts(token, app.slug, build.slug, nextCursor)
                    .await()
                    .apply { nextCursor = paging.nextCursor }
                    .data
                    .map { artifact -> fetchArtifact(artifact) }
                    .map { artifact -> ArtifactItemViewModel(context, router, artifact) }

    private suspend fun fetchArtifact(artifact: Artifact) =
            service
                    .getBuildArtifact(token, app.slug, build.slug, artifact.slug)
                    .await()
                    .data
}