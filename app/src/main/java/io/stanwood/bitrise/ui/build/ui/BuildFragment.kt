package io.stanwood.bitrise.ui.build.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.databinding.FragmentBuildBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.build.vm.BuildViewModel
import org.koin.android.ext.android.inject

class BuildFragment : Fragment() {

    private val viewModel: BuildViewModel
        by inject(parameters = {
            mapOf(
                Properties.TOKEN to token,
                Properties.BUILD to build,
                Properties.APP to app,
                Properties.FRAGMENT_MANAGER to fragmentManager!!)
        })

    private val token: String
        get() = arguments?.getString(Properties.TOKEN)!!

    private val build: Build
        get() = arguments?.getParcelable(Properties.BUILD) as Build

    private val app: App
        get() = arguments?.getParcelable(Properties.APP) as App

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentBuildBinding.inflate(inflater, container, false).apply {
            lifecycle.addObserver(viewModel)
            vm = viewModel
        }.root
}