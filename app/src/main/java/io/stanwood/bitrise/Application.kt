package io.stanwood.bitrise

import android.app.Application
import io.stanwood.bitrise.di.applicationModule
import io.stanwood.bitrise.ui.artifacts.di.artifactsModule
import io.stanwood.bitrise.ui.build_details.di.buildModule
import io.stanwood.bitrise.ui.builds.di.buildsModule
import io.stanwood.bitrise.ui.dashboard.di.dashboardModule
import io.stanwood.bitrise.ui.logs.di.logsModule
import io.stanwood.bitrise.ui.splash.di.splashModule
import org.koin.android.ext.android.startKoin


class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
                this,
                listOf(
                        applicationModule,
                        splashModule,
                        dashboardModule,
                        buildsModule,
                        buildModule,
                        logsModule,
                        artifactsModule))
    }
}