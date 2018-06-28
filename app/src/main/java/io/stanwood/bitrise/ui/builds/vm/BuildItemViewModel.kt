package io.stanwood.bitrise.ui.builds.vm

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.data.model.BuildStatus
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import org.joda.time.Duration
import org.joda.time.format.PeriodFormatter
import java.text.DateFormat


class BuildItemViewModel(
        private val resources: Resources,
        private val periodFormatter: PeriodFormatter,
        private val router: NavController,
        private val build: Build,
        private val token: String) {

    val status: String
        get() = build.status.getTitle(resources)

    val color: Int
        get() = build.status.getColor(resources)

    val number: String
        get() = "#${build.number}"

    val triggeredAt: String
        get() {
            val time = DateFormat.getTimeInstance().format(build.triggeredAt)
            return resources.getString(R.string.build_triggered_at, time)
        }

    val duration: String?
        get() =
            build.finishedAt?.let {
                val triggeredAt = build.triggeredAt.time
                val finishedAt = build.finishedAt.time

                val duration = Duration(finishedAt - triggeredAt)
                val period = duration.toPeriod()
                return periodFormatter.print(period)
            }

    val icon: Drawable
        get() =
            if(build.pullRequestTargetBranch != null && build.status == BuildStatus.SUCCESS) {
                resources.getDrawable(R.drawable.ic_pull_request)
            } else {
                build.status.getIcon(resources)
            }

    val branch: String
        get() = if(build.pullRequestTargetBranch == null) {
            build.branch
        } else {
            "${build.branch}>${build.pullRequestTargetBranch}"
        }

    val isBuildCompleted: Boolean
        get() = build.status != BuildStatus.IN_PROGRESS

    fun onClick() {
        bundleOf(
                Properties.BUILD to build,
                Properties.TOKEN to token)
            .apply {
                router.navigate(R.id.action_builds_to_build, this)
            }
    }
}