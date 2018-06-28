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

package io.stanwood.bitrise.ui.newbuild.vm

import android.content.SharedPreferences
import android.content.res.Resources
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import androidx.navigation.NavController
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.model.App
import io.stanwood.bitrise.data.model.BuildParams
import io.stanwood.bitrise.data.model.NewBuildParams
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import timber.log.Timber

class NewBuildViewModel(private val resources: Resources,
                        private val router: NavController,
                        private val service: BitriseService,
                        private val sharedPreferences: SharedPreferences,
                        private val token: String,
                        private val app: App): BaseObservable() {

    val title: String
        get() = app.title

    @get:Bindable
    var branch: String
        get() = sharedPreferences.getString(Properties.BRANCH, "")
        set(value) = sharedPreferences.edit().putString(Properties.BRANCH, value).apply()

    @get:Bindable
    var workflow: String
        get() = sharedPreferences.getString(Properties.WORKFLOW, "")
        set(value) = sharedPreferences.edit().putString(Properties.WORKFLOW, value).apply()

    val isLoading = ObservableBoolean(false)

    fun onStartNewBuild() {
        async(UI) {
            try {
                isLoading.set(true)
                startNewBuild().let {
                    val message = resources.getString(R.string.new_build_started, it.buildNumber)
                    //TODO: router.exitWithMessage(message)
                }
            } catch (exception: Exception) {
                Timber.e(exception)
                bundleOf(Properties.MESSAGE to exception.message).apply {
                    router.navigate(R.id.action_error, this)
                }
            } finally {
                isLoading.set(false)
            }
        }
    }

    private suspend fun startNewBuild() =
        service
            .startNewBuild(token, app.slug, NewBuildParams(BuildParams(branch, workflow)))
            .await()
}