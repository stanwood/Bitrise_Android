/*
 * Copyright 2018 stanwood Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.stanwood.bitrise.ui.builds.vm

import android.content.res.Resources
import android.graphics.drawable.Drawable
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.data.model.BuildStatus
import io.stanwood.bitrise.navigation.SCREEN_BUILD
import org.joda.time.Duration
import org.joda.time.format.PeriodFormatter
import ru.terrakok.cicerone.Router
import java.text.DateFormat


class BuildItemViewModel(
        private val resources: Resources,
        private val periodFormatter: PeriodFormatter,
        private val router: Router,
        private val build: Build) {

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
        router.navigateTo(SCREEN_BUILD, build)
    }
}