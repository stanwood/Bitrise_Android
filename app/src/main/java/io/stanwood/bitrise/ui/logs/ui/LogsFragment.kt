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

package io.stanwood.bitrise.ui.logs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.databinding.FragmentLogsBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.logs.vm.LogsViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LogsFragment : Fragment() {
    companion object {
        fun newInstance(token: String, build: Build, app: App) = LogsFragment().apply {
            arguments = Bundle().apply {
                putString(Properties.TOKEN, token)
                putParcelable(Properties.BUILD, build)
                putParcelable(Properties.APP, app)
            }
        }
    }

    private val token: String
        get() = arguments?.getString(Properties.TOKEN) as String

    private val app: App
        get() = arguments?.getParcelable(Properties.APP) as App

    private val build: Build
        get() = arguments?.getParcelable(Properties.BUILD) as Build

    private val viewModel: LogsViewModel
        by inject(parameters = {
            parametersOf(
                token,
                app,
                build
            )
        })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentLogsBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }.root
}