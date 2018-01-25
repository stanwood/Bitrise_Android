package io.stanwood.bitrise.ui.builds.di

import io.stanwood.bitrise.ui.builds.vm.BuildsViewModel
import org.joda.time.format.PeriodFormatterBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

const val PROPERTY_APP = "app"

val buildsModule = applicationContext {

    /**
     * View Model
     */
    factory {
        BuildsViewModel(get(), get(), androidApplication().resources, get(), getProperty(PROPERTY_APP))
    }

    /**
     * Period Formatter
     */
    provide {
        PeriodFormatterBuilder()
            .printZeroAlways()
            .appendMinutes()
            .appendSeparator(":")
            .appendSeconds()
            .toFormatter()
    }
}