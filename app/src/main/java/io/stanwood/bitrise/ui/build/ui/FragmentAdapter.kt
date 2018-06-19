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

package io.stanwood.bitrise.ui.build.ui

import android.content.res.Resources
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.ui.artifacts.ui.ArtifactsFragment
import io.stanwood.bitrise.ui.logs.ui.LogsFragment


class FragmentAdapter(
        private val resources: Resources,
        fragmentManager: FragmentManager,
        private val build: Build):
        FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = when(position) {
        0 -> LogsFragment.newInstance(build)
        else -> ArtifactsFragment.newInstance()
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = when(position) {
        0 -> resources.getText(R.string.title_logs)
        else -> resources.getText(R.string.title_artifacts)
    }
}