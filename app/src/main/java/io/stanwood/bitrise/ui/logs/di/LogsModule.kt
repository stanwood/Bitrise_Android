package io.stanwood.bitrise.ui.logs.di


import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.logs.vm.LogsViewModel
import org.koin.dsl.module.applicationContext

val logsModule = applicationContext {

    /**
     * View Model
     */
    factory { args ->
        LogsViewModel(
                get(),
                args[Properties.TOKEN],
                get(),
                args[Properties.APP],
                args[Properties.BUILD])
    }

}