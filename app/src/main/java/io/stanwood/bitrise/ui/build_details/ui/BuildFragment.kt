package io.stanwood.bitrise.ui.build_details.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.databinding.FragmentBuildBinding
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import io.stanwood.bitrise.ui.build_details.di.PROPERTY_BUILD
import io.stanwood.bitrise.ui.build_details.di.PROPERTY_FRAGMENT_MANAGER
import io.stanwood.bitrise.ui.build_details.vm.BuildViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import ru.terrakok.cicerone.Router

private const val ARG_BUILD = "build"

class BuildFragment: Fragment() {
    companion object {
        fun newInstance(build: Build) = BuildFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_BUILD, build)
            }
        }
    }

    private val router: Router by inject()
    private val viewModel: BuildViewModel by inject()
    private val build: Build?
        get() = arguments?.getParcelable(ARG_BUILD) as Build?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        build?.let {
            setProperty(PROPERTY_BUILD, it)
        } ?: router.navigateTo(SCREEN_ERROR)

        fragmentManager?.let {
            setProperty(PROPERTY_FRAGMENT_MANAGER, it)
        } ?: router.navigateTo(SCREEN_ERROR)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentBuildBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}