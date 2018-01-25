package io.stanwood.bitrise.ui.splash.di

import io.stanwood.bitrise.ui.splash.vm.SplashViewModel
import org.koin.dsl.module.applicationContext


val splashModule = applicationContext {

    /**
     * View Model
     */
    provide { SplashViewModel(get(), get()) }
}