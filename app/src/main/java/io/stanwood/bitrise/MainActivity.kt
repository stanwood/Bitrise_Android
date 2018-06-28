
package io.stanwood.bitrise

import android.os.Bundle
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.di.applicationModule
import io.stanwood.bitrise.ui.artifacts.di.artifactsModule
import io.stanwood.bitrise.ui.build.di.buildModule
import io.stanwood.bitrise.ui.builds.di.buildsModule
import io.stanwood.bitrise.ui.dashboard.di.dashboardModule
import io.stanwood.bitrise.ui.error.di.errorModule
import io.stanwood.bitrise.ui.login.di.loginModule
import io.stanwood.bitrise.ui.logs.di.logsModule
import io.stanwood.bitrise.ui.newbuild.di.newBuildModule
import org.koin.android.ext.android.setProperty
import org.koin.android.ext.koin.with
import org.koin.error.AlreadyStartedException
import org.koin.standalone.StandAloneContext
import timber.log.Timber


class MainActivity: PermissionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin()
        setProperty(Properties.ACTIVITY, this)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        StandAloneContext.closeKoin()
    }

    private fun startKoin() {
        try {
            StandAloneContext.startKoin(listOf(
                    applicationModule,
                    errorModule,
                    loginModule,
                    dashboardModule,
                    buildsModule,
                    buildModule,
                    logsModule,
                    artifactsModule,
                    newBuildModule)) with application
        } catch (exception: AlreadyStartedException) {
            // Can be safely ignored
            Timber.e(exception)
        }
    }
}