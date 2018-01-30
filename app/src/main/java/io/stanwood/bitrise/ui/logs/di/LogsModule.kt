package io.stanwood.bitrise.ui.logs.di


import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.logs.vm.LogsViewModel
import org.koin.dsl.module.applicationContext

val logsModule = applicationContext {

    /**
     * View Model
     */
    factory {
        LogsViewModel(
                get(),
                getProperty(Properties.TOKEN),
                get(),
                getProperty(Properties.APP),
                getProperty(Properties.BUILD))
    }

}