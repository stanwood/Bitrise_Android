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

package io.stanwood.bitrise.ui.artifacts.di

import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel
import org.koin.dsl.module.module

val artifactsModule = module {
    /**
     * View Model
     */
    factory { (token: String, app: App, build: Build) ->
        ArtifactsViewModel(
            snacker = get(),
            router = get(),
            service = get(),
            token = token,
            activity = getProperty(Properties.ACTIVITY),
            app = app,
            build = build,
            mainScope = get("main")
        )
    }
}