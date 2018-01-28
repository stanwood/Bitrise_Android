package io.stanwood.bitrise

import android.app.Application


class Application: Application() {

    override fun onCreate() {
        super.onCreate()
//        startKoin(
//                this,
//                listOf(
//                        applicationModule,
//                        errorModule,
//                        loginModule,
//                        dashboardModule,
//                        buildsModule,
//                        buildModule,
//                        logsModule,
//                        artifactsModule))
    }


}