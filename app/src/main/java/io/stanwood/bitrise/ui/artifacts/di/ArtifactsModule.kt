package io.stanwood.bitrise.ui.artifacts.di

import io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel
import io.stanwood.bitrise.ui.build.di.PROPERTY_BUILD
import io.stanwood.bitrise.ui.builds.di.PROPERTY_APP
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
                androidApplication(),
                getProperty(PROPERTY_APP),
                getProperty(PROPERTY_BUILD))
    }
}