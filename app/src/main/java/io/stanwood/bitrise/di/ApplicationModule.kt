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

package io.stanwood.bitrise.di

import android.preference.PreferenceManager
import androidx.navigation.Navigation
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.R
import io.stanwood.bitrise.data.net.BitriseService
import io.stanwood.bitrise.util.Snacker
import io.stanwood.bitrise.util.gson.GsonDateFormatAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


val applicationModule = applicationContext {

    /**
     * Gson
     */
    bean {
        GsonBuilder()
            .registerTypeAdapter(Date::class.java, GsonDateFormatAdapter(BuildConfig.API_DATE_TIME_FORMAT))
            .create()
    }

    /**
     * OkHttpClient
     */
    bean {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()
    }

    /**
     * Retrofit
     */
    bean {
        Retrofit
                .Builder()
                .baseUrl(BuildConfig.BITRISE_API_BASE_URL)
                .client(get())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
    }

    /**
     * BitriseService
     */
    bean { get<Retrofit>().create(BitriseService::class.java) }

    /**
     * Cicerone
     */
    bean { Navigation.findNavController(getProperty(Properties.ACTIVITY), R.id.root) }

    /**
     * SharedPreferences
     */
    bean { PreferenceManager.getDefaultSharedPreferences(androidApplication()) }

    /**
     * Snacker
     */
    bean {
        Snacker(
            activity = getProperty(Properties.ACTIVITY),
            layoutResId = R.id.root)
    }
}
