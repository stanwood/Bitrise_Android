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

package io.stanwood.bitrise.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.Build
import io.stanwood.bitrise.ui.build.ui.BuildFragment
import io.stanwood.bitrise.ui.builds.ui.BuildsFragment
import io.stanwood.bitrise.ui.dashboard.ui.DashboardFragment
import io.stanwood.bitrise.ui.error.ui.ErrorFragment
import io.stanwood.bitrise.ui.login.ui.LoginFragment
import io.stanwood.bitrise.ui.newbuild.ui.NewBuildFragment
import ru.terrakok.cicerone.android.SupportAppNavigator


const val SCREEN_ERROR = "error"
const val SCREEN_LOGIN = "login"
const val SCREEN_DASHBOARD = "dashboard"
const val SCREEN_BUILDS = "builds"
const val SCREEN_BUILD = "build"
const val SCREEN_NEW_BUILD = "new_build"
const val SCREEN_INSTALL = "install"

class Navigator(private val activity: FragmentActivity, private val cointainerId: Int) :
        SupportAppNavigator(activity, cointainerId) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?) = when (screenKey) {
        SCREEN_INSTALL -> Intent(Intent.ACTION_VIEW).setData(Uri.parse(data as String))
        else -> null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment =
        try {
            when (screenKey) {
                SCREEN_ERROR -> ErrorFragment.newInstance(data as String?)
                SCREEN_LOGIN -> LoginFragment.newInstance()
                SCREEN_DASHBOARD -> DashboardFragment.newInstance()
                SCREEN_BUILDS -> BuildsFragment.newInstance(data as App)
                SCREEN_BUILD -> BuildFragment.newInstance(data as Build)
                SCREEN_NEW_BUILD -> NewBuildFragment.newInstance()
                else -> throw UnsupportedOperationException("Unsupported screen key: $screenKey")
            }
        } catch (exception: Exception) {
            ErrorFragment.newInstance(exception.message)
        }

    override fun showSystemMessage(message: String?) {
        val view = activity.findViewById<View>(cointainerId)
        if (view != null && message != null) {
            Snackbar
                .make(view, message, Snackbar.LENGTH_SHORT)
                .show()
        }
    }
}