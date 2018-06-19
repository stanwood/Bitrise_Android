/*
 * Copyright 2018 stanwood Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.stanwood.bitrise.ui.error.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.databinding.FragmentErrorBinding
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.error.vm.ErrorViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty

class ErrorFragment: Fragment() {
    companion object {
        fun newInstance(message: String?) = ErrorFragment().apply {
            arguments = Bundle().apply {
                putString(Properties.MESSAGE, message)
            }
        }
    }

    private val viewModel: ErrorViewModel by inject()
    private val message: String?
        get() = arguments?.getString(Properties.MESSAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        message?.let { setProperty(Properties.MESSAGE, it) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            FragmentErrorBinding.inflate(inflater, container, false).apply {
                lifecycle.addObserver(viewModel)
                vm = viewModel
            }.root
}