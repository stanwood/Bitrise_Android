package io.stanwood.bitrise.ui.builds.di

import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.builds.vm.BuildsViewModel
import org.joda.time.format.PeriodFormatterBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val buildsModule = applicationContext {

    /**
     * View Model
     */
    factory { args ->
        BuildsViewModel(
                get(),
                get(),
                getProperty(Properties.TOKEN),
                androidApplication().resources,
                get(),
                args[Properties.APP])
    }

    /**
     * Period Formatter
     */
    bean {
        PeriodFormatterBuilder()
            .printZeroAlways()
            .appendMinutes()
            .appendSeparator(":")
            .appendSeconds()
            .toFormatter()
    }
}