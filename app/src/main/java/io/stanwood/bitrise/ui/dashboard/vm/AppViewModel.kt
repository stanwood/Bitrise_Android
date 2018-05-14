package io.stanwood.bitrise.ui.dashboard.vm

import android.content.res.Resources
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.graphics.drawable.Drawable
import io.stanwood.bitrise.BR
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.data.model.BuildStatus
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.navigation.SCREEN_BUILDS
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.ocpsoft.prettytime.PrettyTime
import ru.terrakok.cicerone.Router
import timber.log.Timber


class AppViewModel(
        private val service: BitriseService,
        private val token: String,
        private val resources: Resources,
        private val router: Router,
        private val app: App) : BaseObservable() {

    val title: String
        get() = app.title

    val repoOwner: String
        get() = "${app.repoOwner}/"

    val icon: Drawable?
        get() = app.projectType?.getIcon(resources)

    @get:Bindable
    val lastBuildTime: String?
        get() {
            return if(lastBuild?.status == BuildStatus.IN_PROGRESS) {
                lastBuild?.status?.getTitle(resources)
            } else {
                lastBuild?.finishedAt?.let { PrettyTime().format(it) }
            }
        }

    @get:Bindable("lastBuildTime")
    val buildStatusColor: Int
        get() = lastBuild?.status?.getColor(resources) ?: 0

    @get:Bindable("lastBuildTime")
    val buildStatusIcon: Drawable?
        get() = lastBuild?.status?.getIcon(resources)

    private var deferred: Deferred<Any?>? = null
    private var lastBuild: Build? = null

    fun start() {
        deferred = async(UI) {
            try {
                lastBuild = fetchLastBuild()
                notifyPropertyChanged(BR.lastBuildTime)
            } catch (exception: Exception) {
                Timber.e(exception)
                router.navigateTo(SCREEN_ERROR, exception.message)
            }
        }
    }

    fun stop() {
        deferred?.cancel()
    }

    fun onClick() {
        router.navigateTo(SCREEN_BUILDS, app)
    }

    private suspend fun fetchLastBuild() =
        service
            .getBuilds(token, app.slug, limit = 1)
            .await()
            .data
            .firstOrNull()
}