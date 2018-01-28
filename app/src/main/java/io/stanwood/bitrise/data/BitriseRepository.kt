package io.stanwood.bitrise.data

import android.content.SharedPreferences
import android.util.Log
import io.stanwood.bitrise.data.net.BitriseService


private const val KEY_TOKEN = "token"

class BitriseRepository(
//        private val preferences: SharedPreferences,
        private val service: BitriseService) {

    private val token: String?
        get() = "test"//preferences.getString(KEY_TOKEN, null)

    @Throws(UnsupportedOperationException::class)
    suspend fun login() {
        token?.let {
            try {
            service.login(it).await()
            } catch (e: Exception) {
                Log.e("pagelx", e.message)
            }
        } ?: throw UnsupportedOperationException("Token is null")
    }

    suspend fun login(token: String) {
        service
            .login(token)
    }
}