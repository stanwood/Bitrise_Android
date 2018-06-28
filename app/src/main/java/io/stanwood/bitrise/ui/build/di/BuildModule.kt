package io.stanwood.bitrise.ui.build.di

import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.ui.build.ui.FragmentAdapter
import io.stanwood.bitrise.ui.build.vm.BuildViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val buildModule = applicationContext {

    /**
     * View Model
     */
    factory { args ->
        BuildViewModel(
                resources = androidApplication().resources,
                router = get(),
                service = get(),
                adapter = get(parameters = { args.values }),
                token = args[Properties.TOKEN],
                app = args[Properties.APP],
                build = args[Properties.BUILD])
    }

    /**
     * FragmentAdapter
     */
    factory { args ->
        FragmentAdapter(
                resources = androidApplication().resources,
                fragmentManager = args[Properties.FRAGMENT_MANAGER],
                token = args[Properties.TOKEN],
                build = args[Properties.BUILD],
                app = args[Properties.APP])
    }
}