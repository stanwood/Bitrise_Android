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

import org.jetbrains.kotlin.config.AnalysisFlag.Flags.experimental
import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("project-report")
}

val properties = Properties()
val propertiesFile = project.rootProject.file("local.properties")
if (propertiesFile.exists()) {
    properties.load(DataInputStream(FileInputStream(propertiesFile)))
}
val bitriseApiToken = properties.getProperty("bitrise.api.token")

android {
    compileSdkVersion(Config.Build.sdkVersion)
    defaultConfig {
        applicationId = "io.stanwood.bitrise"
        minSdkVersion(Config.Build.minSdkVersion)
        targetSdkVersion(Config.Build.sdkVersion)
        versionCode = Config.Build.versionCode
        versionName = Config.Build.versionName
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        manifestPlaceholders["appName"] = "@string/app_name"

        buildConfigField("String", "BITRISE_API_BASE_URL", "\"https://api.bitrise.io/\"")
        buildConfigField("int", "DEFAULT_PAGE_SIZE", "10")
        buildConfigField("int", "PAGE_LOAD_THRESHOLD", "2")

        buildConfigField("String", "BITRISE_API_TOKEN", if (properties.containsKey("bitrise.api.token")) "\"$bitriseApiToken\"" else "null")
        buildConfigField("String", "API_DATE_TIME_FORMAT", "\"yyyy-MM-dd'T'HH:mm:ss'Z'\"")
        buildConfigField("long", "DOWNLOAD_STATUS_REFRESH_DELAY", "500L")
    }
    kotlin {
        experimental.coroutines = Coroutines.ENABLE
    }
    androidExtensions {
        isExperimental = true
    }
    dataBinding {
        isEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

project.afterEvaluate {
    android.applicationVariants.forEach { variant ->
        val buildTypeName = variant.buildType.name
        val flavorName = variant.flavorName
        when (buildTypeName) {
            "debug" -> {
                variant.mergedFlavor.manifestPlaceholders["appName"] =
                        "${Config.Build.buildNumber} Bitrise Unofficial $flavorName $buildTypeName"
            }
        }
    }
}

dependencies {
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Config.Libs.retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-gson:${Config.Libs.retrofitVersion}")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:${Config.Libs.retrofitCoroutinesVersion}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Config.Libs.logInterceptorVersion}")

    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Config.Kotlin.coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Config.Kotlin.coroutinesVersion}")
    implementation("org.jetbrains.kotlin:kotlin-android-extensions-runtime:${Config.Kotlin.androidExtensionsVersion}")

    // Support
    implementation("com.android.support:design:${Config.Android.supportLibVersion}")
    implementation("com.android.support.constraint:constraint-layout:${Config.Android.constraintLayoutVersion}")

    // Glide
    implementation("com.github.bumptech.glide:glide:${Config.Libs.glideVersion}")
    kapt("com.github.bumptech.glide:compiler:${Config.Libs.glideVersion}")

    // Other
    implementation("com.jakewharton.timber:timber:${Config.Libs.timberVersion}")
    implementation("org.ocpsoft.prettytime:prettytime:${Config.Libs.prettyTimeVersion}")
    implementation("joda-time:joda-time:${Config.Libs.jodaTimeVersion}")
    implementation("org.koin:koin-android:${Config.Libs.koinVersion}")

    implementation("android.arch.navigation:navigation-fragment:${Config.Android.navigationVersion}")
}
