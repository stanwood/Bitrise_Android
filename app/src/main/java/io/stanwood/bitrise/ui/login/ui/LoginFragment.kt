package io.stanwood.bitrise.ui.login.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.databinding.FragmentLoginBinding
import io.stanwood.bitrise.ui.login.vm.LoginViewModel
import org.koin.android.ext.android.inject


class LoginFragment: Fragment() {
    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentLoginBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}