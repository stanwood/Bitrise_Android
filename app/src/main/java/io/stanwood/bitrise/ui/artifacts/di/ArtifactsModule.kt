package io.stanwood.bitrise.ui.artifacts.di

import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext


val artifactsModule = applicationContext {
    /**
     * View Model
     */
    factory { args ->
        ArtifactsViewModel(
                router = get(),
                service = get(),
                token = args[Properties.TOKEN],
                activity = getProperty(Properties.ACTIVITY),
                app = args[Properties.APP],
                build = args[Properties.BUILD])
    }
}