package io.stanwood.bitrise.ui.error.di

import io.stanwood.bitrise.R
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.error.vm.ErrorViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext


val errorModule = applicationContext {
    /**
     * View Model
     */
    factory {
        try {
            getProperty<String>(Properties.MESSAGE)
        } catch (exception: Exception) {
            androidApplication().getString(R.string.default_error_message)
        }.let {
            ErrorViewModel(get(), it)
        }
    }
}