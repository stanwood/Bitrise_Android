package io.stanwood.bitrise.ui.builds.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.databinding.FragmentBuildsBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import io.stanwood.bitrise.ui.builds.vm.BuildsViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import ru.terrakok.cicerone.Router

class BuildsFragment : Fragment() {
    companion object {
        fun newInstance(app: App) = BuildsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(Properties.APP, app)
            }
        }
    }

    private val router: Router by inject()
    private val viewModel: BuildsViewModel by inject()
    private val app: App?
        get() = arguments?.getParcelable(Properties.APP) as App?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app?.let {
            setProperty(Properties.APP, it)
        } ?: router.navigateTo(SCREEN_ERROR)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentBuildsBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}