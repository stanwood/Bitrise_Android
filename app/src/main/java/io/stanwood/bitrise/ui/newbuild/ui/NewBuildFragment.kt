package io.stanwood.bitrise.ui.newbuild.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.stanwood.bitrise.databinding.FragmentNewBuildBinding
import io.stanwood.bitrise.ui.newbuild.vm.NewBuildViewModel
import kotlinx.android.synthetic.main.fragment_new_build.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router

class NewBuildFragment : Fragment() {
    companion object {
        fun newInstance() = NewBuildFragment()
    }

    private val viewModel: NewBuildViewModel by inject()

    private val router: Router by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentNewBuildBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar?.setNavigationOnClickListener { router.exit() }
    }
}