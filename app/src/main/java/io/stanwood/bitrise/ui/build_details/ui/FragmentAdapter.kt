package io.stanwood.bitrise.ui.build_details.ui

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