package io.stanwood.bitrise.ui.dashboard.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.databinding.FragmentDashboardBinding
import io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel
import org.koin.android.ext.android.inject

class DashboardFragment: Fragment() {
    companion object {
        fun newInstance() = DashboardFragment()
    }

    private val viewModel: DashboardViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentDashboardBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}