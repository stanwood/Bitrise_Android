package io.stanwood.bitrise.ui.logs.di

import io.stanwood.bitrise.ui.build.di.PROPERTY_BUILD
import io.stanwood.bitrise.ui.builds.di.PROPERTY_APP
import io.stanwood.bitrise.ui.logs.vm.LogsViewModel
import org.koin.dsl.module.applicationContext

val logsModule = applicationContext {

    /**
     * View Model
     */
    factory {
        LogsViewModel(get(), getProperty(PROPERTY_APP), getProperty(PROPERTY_BUILD))
    }

}