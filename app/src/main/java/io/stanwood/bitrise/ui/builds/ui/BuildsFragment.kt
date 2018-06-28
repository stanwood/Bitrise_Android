package io.stanwood.bitrise.ui.builds.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.databinding.FragmentBuildsBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.builds.vm.BuildsViewModel
import io.stanwood.bitrise.util.extensions.bundleOf
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty

class BuildsFragment : Fragment() {
    private val router: NavController by inject()
    private val viewModel: BuildsViewModel by inject()
    private val app: App?
        get() = arguments?.getParcelable(Properties.APP) as App?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app?.let {
            setProperty(Properties.APP, it)
        } ?: bundleOf(Properties.MESSAGE to null).apply {
            router.navigate(R.id.action_error, this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentBuildsBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}