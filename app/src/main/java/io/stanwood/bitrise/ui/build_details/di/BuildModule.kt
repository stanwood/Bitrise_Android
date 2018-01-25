package io.stanwood.bitrise.ui.build_details.di

import io.stanwood.bitrise.ui.build_details.ui.FragmentAdapter
import io.stanwood.bitrise.ui.build_details.vm.BuildViewModel
import io.stanwood.bitrise.ui.builds.di.PROPERTY_APP
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext


const val PROPERTY_FRAGMENT_MANAGER = "fragment_manager"
const val PROPERTY_BUILD = "build"

val buildModule = applicationContext {

    /**
     * View Model
     */
    factory {
        BuildViewModel(get(), getProperty(PROPERTY_APP), getProperty(PROPERTY_BUILD))
    }

    /**
     * FragmentAdapter
     */
    factory {
        FragmentAdapter(
                androidApplication().resources,
                getProperty(PROPERTY_FRAGMENT_MANAGER),
                getProperty(PROPERTY_BUILD))
    }
}