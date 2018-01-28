package io.stanwood.bitrise.ui.artifacts.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.databinding.FragmentArtifactsBinding
import io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel
import org.koin.android.ext.android.inject


class ArtifactsFragment: Fragment() {
    companion object {
        fun newInstance() = ArtifactsFragment()
    }

    private val viewModel: ArtifactsViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentArtifactsBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}