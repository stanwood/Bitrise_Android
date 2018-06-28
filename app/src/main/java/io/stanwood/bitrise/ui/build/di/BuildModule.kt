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

package io.stanwood.bitrise.ui.build.di

import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.build.ui.FragmentAdapter
import io.stanwood.bitrise.ui.build.vm.BuildViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val buildModule = applicationContext {

    /**
     * View Model
     */
    factory { args ->
        BuildViewModel(
                resources = androidApplication().resources,
                router = get(),
                service = get(),
                adapter = get(parameters = { args.values }),
                token = args[Properties.TOKEN],
                app = args[Properties.APP],
                build = args[Properties.BUILD])
    }

    /**
     * FragmentAdapter
     */
    factory { args ->
        FragmentAdapter(
                resources = androidApplication().resources,
                fragmentManager = args[Properties.FRAGMENT_MANAGER],
                token = args[Properties.TOKEN],
                build = args[Properties.BUILD],
                app = args[Properties.APP])
    }
}