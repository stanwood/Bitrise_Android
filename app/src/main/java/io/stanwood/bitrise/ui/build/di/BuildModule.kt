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
                adapter = get(),
                router = get(),
                app = getProperty(Properties.APP),
                build = getProperty(Properties.BUILD),
                token = getProperty(Properties.TOKEN),
                bitriseTriggerService = get())
    }

    /**
     * FragmentAdapter
     */
    factory {
        FragmentAdapter(
                androidApplication().resources,
                getProperty(Properties.FRAGMENT_MANAGER),
                getProperty(Properties.BUILD))
    }
}