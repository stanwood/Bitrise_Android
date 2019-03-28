/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.stanwood.bitrise.ui.builds.vm

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
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
        private val token: String,
        private val app: App) {

    val workflow: String
        get() = build.triggeredWorkflow

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
            if (build.pullRequestTargetBranch != null && build.status == BuildStatus.SUCCESS) {
                resources.getDrawable(R.drawable.ic_pull_request)
            } else {
                build.status.getIcon(resources)
            }

    val branch: String
        get() = if (build.pullRequestTargetBranch == null) {
            build.branch
        } else {
            "${build.branch}>${build.pullRequestTargetBranch}"
        }

    val isBuildCompleted: Boolean
        get() = build.status != BuildStatus.IN_PROGRESS

    fun onClick() {
        bundleOf(
                Properties.TOKEN to token,
                Properties.BUILD to build,
                Properties.APP to app)
            .apply {
                router.navigate(R.id.action_builds_to_build, this)
            }
    }
}