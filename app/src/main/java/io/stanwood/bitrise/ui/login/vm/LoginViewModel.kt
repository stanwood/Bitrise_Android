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
            val normalized = checkToken(value)
            setProperty(Properties.TOKEN, normalized)
            sharedPreferences
                    .edit()
                    .putString(Properties.TOKEN, normalized)
                    .apply()
        }
        get() = sharedPreferences.getString(Properties.TOKEN, checkToken(BuildConfig.BITRISE_API_TOKEN))

    private var deferred: Deferred<Any>? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun start() {
        checkToken(token)?.let {
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

    private suspend fun tryLogin(newToken: String) {
        checkToken(newToken)?.let {
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

    private fun checkToken(newToken: String?): String? =
            newToken.takeIf { it.isNullOrBlank().not() && it != "null" }
}