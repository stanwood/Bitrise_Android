
/*
 * Copyright 2018 stanwood Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.stanwood.bitrise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.di.applicationModule
import io.stanwood.bitrise.navigation.Navigator
import io.stanwood.bitrise.navigation.SCREEN_LOGIN
import io.stanwood.bitrise.ui.artifacts.di.artifactsModule
import io.stanwood.bitrise.ui.build.di.buildModule
import io.stanwood.bitrise.ui.builds.di.buildsModule
import io.stanwood.bitrise.ui.dashboard.di.dashboardModule
import io.stanwood.bitrise.ui.error.di.errorModule
import io.stanwood.bitrise.ui.login.di.loginModule
import io.stanwood.bitrise.ui.logs.di.logsModule
import io.stanwood.bitrise.ui.newbuild.di.newBuildModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import org.koin.android.ext.koin.with
import org.koin.error.AlreadyStartedException
import org.koin.standalone.StandAloneContext
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainActivity: PermissionActivity() {

    private val navigator: Navigator by inject()
    private val navigatorHolder: NavigatorHolder by inject()
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
        startKoin()
        setProperty(Properties.ACTIVITY, this)
        setContentView(R.layout.activity_main)
        router.newRootScreen(SCREEN_LOGIN, true)
    }

    override fun onDestroy() {
        super.onDestroy()
        StandAloneContext.closeKoin()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
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