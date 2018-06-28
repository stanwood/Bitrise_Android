package io.stanwood.bitrise.ui.login.vm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.SharedPreferences
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import androidx.navigation.NavController
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.di.Properties
import io.stanwood.bitrise.util.extensions.bundleOf
import io.stanwood.bitrise.util.extensions.setProperty
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import retrofit2.HttpException
import timber.log.Timber
import java.net.HttpURLConnection


class LoginViewModel(
        private val service: BitriseService,
        private val router: NavController,
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
                bundleOf(Properties.TOKEN to token).apply {
                    router.navigate(R.id.action_login_to_dashboard, this)
                }
            } catch (exception: Exception) {
                if (exception is HttpException && exception.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    isError.set(true)
                }
                bundleOf(Properties.MESSAGE to exception.message).apply {
                    router.navigate(R.id.action_error, this)
                }
                Timber.e(exception)
            } finally {
                isLoading.set(false)
            }
        }
    }
}