package io.stanwood.bitrise.ui.artifacts.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.databinding.FragmentArtifactsBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel
import org.koin.android.ext.android.inject


class ArtifactsFragment: Fragment() {
    companion object {
        fun newInstance(token: String, build: Build, app: App) = ArtifactsFragment().apply {
            arguments = Bundle().apply {
                putString(Properties.TOKEN, token)
                putParcelable(Properties.BUILD, build)
                putParcelable(Properties.APP, app)
            }
        }
    }

    private val token: String
        get() = arguments?.getString(Properties.TOKEN) as String

    private val app: App
        get() = arguments?.getParcelable(Properties.APP) as App

    private val build: Build
        get() = arguments?.getParcelable(Properties.BUILD) as Build

    private val viewModel: ArtifactsViewModel
        by inject(parameters = {
            mapOf(
                    Properties.TOKEN to token,
                    Properties.APP to app,
                    Properties.BUILD to build)
        })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentArtifactsBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}