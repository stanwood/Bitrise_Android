package io.stanwood.bitrise.ui.artifacts.di

import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext


val artifactsModule = applicationContext {
    /**
     * View Model
     */
    factory {
        ArtifactsViewModel(
                get(),
                get(),
                getProperty(Properties.TOKEN),
                androidApplication(),
                getProperty(Properties.APP),
                getProperty(Properties.BUILD))
    }
}