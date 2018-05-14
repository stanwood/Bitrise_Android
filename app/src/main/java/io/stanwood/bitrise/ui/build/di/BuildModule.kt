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