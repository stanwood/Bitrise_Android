package io.stanwood.bitrise.ui.login.di

import io.stanwood.bitrise.ui.login.vm.LoginViewModel
import org.koin.dsl.module.applicationContext


val loginModule = applicationContext {

    /**
     * View Model
     */
    provide { LoginViewModel(get(), get(), get()) }
}