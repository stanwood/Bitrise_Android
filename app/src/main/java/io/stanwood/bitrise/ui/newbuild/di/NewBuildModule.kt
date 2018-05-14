package io.stanwood.bitrise.ui.newbuild.di

import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.newbuild.vm.NewBuildViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext


val newBuildModule = applicationContext {
    /**
     * View Model
     */
    provide {
        NewBuildViewModel(
                resources = androidApplication().resources,
                router = get(),
                service = get(),
                sharedPreferences = get(),
                token = getProperty(Properties.TOKEN),
                app = getProperty(Properties.APP))
    }
}