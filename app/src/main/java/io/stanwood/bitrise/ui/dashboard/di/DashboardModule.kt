package io.stanwood.bitrise.ui.dashboard.di

import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val dashboardModule = applicationContext {

    /**
     * View Model
     */
    provide {
        DashboardViewModel(
            get(),
            get(),
            getProperty(Properties.TOKEN),
            androidApplication().resources)
    }
}
