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

package io.stanwood.bitrise.ui.error.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
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