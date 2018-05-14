package io.stanwood.bitrise.ui.newbuild.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.databinding.FragmentNewBuildBinding
import io.stanwood.bitrise.ui.newbuild.vm.NewBuildViewModel
import org.koin.android.ext.android.inject

class NewBuildFragment : Fragment() {
    companion object {
        fun newInstance() = NewBuildFragment()
    }

    private val viewModel: NewBuildViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentNewBuildBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }.root
}