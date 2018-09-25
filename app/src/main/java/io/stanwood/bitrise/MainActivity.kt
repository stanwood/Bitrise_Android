
/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.stanwood.bitrise

import android.content.SharedPreferences
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
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import org.koin.android.ext.koin.with
import org.koin.error.AlreadyStartedException
import org.koin.standalone.StandAloneContext
import timber.log.Timber


class MainActivity: PermissionActivity() {

    private val sharedPreferences: SharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin()
        setProperty(Properties.ACTIVITY, this)
        setProperty(Properties.TOKEN, sharedPreferences.getString(Properties.TOKEN, BuildConfig.BITRISE_API_TOKEN))
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