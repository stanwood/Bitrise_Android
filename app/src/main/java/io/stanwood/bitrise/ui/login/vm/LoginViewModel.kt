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

package io.stanwood.bitrise.ui.login.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.SharedPreferences
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.navigation.SCREEN_DASHBOARD
import io.stanwood.bitrise.navigation.SCREEN_ERROR
import io.stanwood.bitrise.util.extensions.setProperty
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import retrofit2.HttpException
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.net.HttpURLConnection


class LoginViewModel(
        private val service: BitriseService,
        private val router: Router,
        private val sharedPreferences: SharedPreferences) : LifecycleObserver, BaseObservable() {

    val isError = ObservableBoolean()
    val isLoading = ObservableBoolean()
    @get:Bindable
    var token: String?
        set(value) {
            if (value?.isBlank() == true) {
                /**
                 * Sanity check. We don't want to store an empty or null token.
                 */
                return
            }
            setProperty(Properties.TOKEN, value)
            sharedPreferences
                .edit()
                .putString(Properties.TOKEN, value)
                .apply()
        }
        get() = sharedPreferences.getString(Properties.TOKEN, BuildConfig.BITRISE_API_TOKEN)

    private var deferred: Deferred<Any>? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
        token?.let {
            onTokenEntered(it)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        deferred?.cancel()
    }

    fun onTokenEntered(newToken: String) {
        deferred = async(UI) {
            tryLogin(newToken)
        }
    }

    private suspend fun tryLogin(newToken: String?) {
        newToken?.let {
            try {
                isLoading.set(true)
                service
                        .login(it)
                        .await()
                token = it
                router.newRootScreen(SCREEN_DASHBOARD)
            } catch (exception: Exception) {
                if (exception is HttpException && exception.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    isError.set(true)
                }
                router.navigateTo(SCREEN_ERROR, exception.message)
                Timber.e(exception)
            } finally {
                isLoading.set(false)
            }
        }
    }
}