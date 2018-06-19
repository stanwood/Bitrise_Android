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
    factory {
        BuildViewModel(
                resources = androidApplication().resources,
                router = get(),
                service = get(),
                adapter = get(),
                token = getProperty(Properties.TOKEN),
                app = getProperty(Properties.APP),
                build = getProperty(Properties.BUILD))
    }

    /**
     * FragmentAdapter
     */
    factory {
        FragmentAdapter(
                resources = androidApplication().resources,
                fragmentManager = getProperty(Properties.FRAGMENT_MANAGER),
                build = getProperty(Properties.BUILD))
    }
}