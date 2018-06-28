package io.stanwood.bitrise.ui.build.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.databinding.FragmentBuildBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.build.vm.BuildViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty

class BuildFragment : Fragment() {
    private val router: NavController by inject()
    private val viewModel: BuildViewModel by inject()
    private val build: Build?
        get() = arguments?.getParcelable(Properties.BUILD) as Build?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        build?.let {
            setProperty(Properties.BUILD, it)
        } //?: router.navigateTo(SCREEN_ERROR)

        fragmentManager?.let {
            setProperty(Properties.FRAGMENT_MANAGER, it)
        } //?: router.navigateTo(SCREEN_ERROR)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentBuildBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}