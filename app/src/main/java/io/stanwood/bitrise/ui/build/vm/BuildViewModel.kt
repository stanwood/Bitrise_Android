package io.stanwood.bitrise.ui.build.vm

import android.arch.lifecycle.LifecycleObserver
import android.content.res.Resources
import android.databinding.ObservableBoolean
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.*
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.build.ui.FragmentAdapter
import io.stanwood.bitrise.util.extensions.bundleOf
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import timber.log.Timber


class BuildViewModel(
        private val resources: Resources,
        private val router: NavController,
        private val service: BitriseService,
        val adapter: FragmentAdapter,
        private val token: String,
        private val app: App,
        private val build: Build): LifecycleObserver {

    val title: String
        get() = "${app.title} #${build.number}"

    val isLoading = ObservableBoolean(false)

    val isCurrentlyRunning
        get() = build.status == BuildStatus.IN_PROGRESS

    fun onRestartBuild() {
        async(UI) {
            try {
                isLoading.set(true)
                restartBuild().let {
                    val message = resources.getString(R.string.new_build_started, it.buildNumber)
                    //TODO: router.exitWithMessage(message)
                }
            } catch (exception: Exception) {
                Timber.e(exception)
                bundleOf(Properties.MESSAGE to exception.message).apply {
                    router.navigate(R.id.action_error, this)
                }
            } finally {
                isLoading.set(false)
            }
        }
    }

    private suspend fun restartBuild() =
        service
            .startNewBuild(token, app.slug, NewBuildParams(BuildParams(build.branch, build.triggeredWorkflow)))
            .await()
}