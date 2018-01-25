package io.stanwood.bitrise.ui.splash.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.databinding.FragmentSplashBinding
import io.stanwood.bitrise.ui.splash.vm.SplashViewModel
import org.koin.android.ext.android.inject


class SplashFragment: Fragment() {
    companion object {
        fun newInstance() = SplashFragment()
    }

    private val viewModel: SplashViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentSplashBinding.inflate(inflater, container, false).apply {
            lifecycle.addObserver(viewModel)
            vm = viewModel
        }.root
}