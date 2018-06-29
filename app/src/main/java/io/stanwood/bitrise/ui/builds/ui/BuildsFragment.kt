/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.stanwood.bitrise.ui.builds.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.databinding.FragmentBuildsBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import io.stanwood.bitrise.ui.builds.vm.BuildsViewModel
import kotlinx.android.synthetic.main.fragment_builds.*
import kotlinx.android.synthetic.main.layout_toolbar.*
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar?.setNavigationOnClickListener { router.exit() }
    }
}