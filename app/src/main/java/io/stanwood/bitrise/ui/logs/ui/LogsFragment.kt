package io.stanwood.bitrise.ui.logs.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.databinding.FragmentLogsBinding
import io.stanwood.bitrise.ui.logs.vm.LogsViewModel
import org.koin.android.ext.android.inject

private const val ARG_BUILD = "build"

class LogsFragment: Fragment() {
    companion object {
        fun newInstance(build: Build) = LogsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_BUILD, build)
            }
        }
    }

    private val viewModel: LogsViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentLogsBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}