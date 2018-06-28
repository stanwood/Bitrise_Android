package io.stanwood.bitrise.ui.dashboard.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.*
import io.stanwood.bitrise.R
import io.stanwood.bitrise.databinding.FragmentDashboardBinding
import io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel
import org.koin.android.ext.android.inject


class DashboardFragment: Fragment() {
    private val viewModel: DashboardViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentDashboardBinding.inflate(inflater, container, false).apply {
            lifecycle.addObserver(viewModel)
            vm = viewModel
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val currentActivity = activity
        if(currentActivity is AppCompatActivity) {
            view.findViewById<Toolbar>(R.id.toolbar)?.let {
                currentActivity.setSupportActionBar(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.menu_logout) {
            viewModel.onLogout()
        }
        return super.onOptionsItemSelected(item)
    }
}