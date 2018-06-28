package io.stanwood.bitrise.ui.builds.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.databinding.FragmentBuildsBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.builds.vm.BuildsViewModel
import org.koin.android.ext.android.inject

class BuildsFragment : Fragment() {

    private val app: App
        get() = arguments?.getParcelable(Properties.APP) as App

    private val viewModel: BuildsViewModel by inject(parameters = { mapOf(Properties.APP to app) })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentBuildsBinding.inflate(inflater, container, false).apply {
            lifecycle.addObserver(viewModel)
            vm = viewModel
        }.root
}