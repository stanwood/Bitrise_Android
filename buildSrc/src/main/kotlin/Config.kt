object Config {

    object Build {
        val versionCode = 1
        val versionName = "1.3"
        val minSdkVersion = 21
        val sdkVersion = 27
        val buildNumber = System.getenv("BITRISE_BUILD_NUMBER") ?: "local"
    }

    object Kotlin {
        val kotlinVersion = "1.2.71"
        val coroutinesVersion = "0.22.5"
        val androidExtensionsVersion = "1.2.21"
    }

    object Android {
        val supportLibVersion = "27.1.1"
        val gradlePluginVersion = "3.2.0"
        val constraintLayoutVersion = "1.1.2"
        val navigationVersion = "1.0.0-alpha05"
    }

    object Libs {
        val retrofitVersion = "2.3.0"
        val retrofitCoroutinesVersion = "1.0.0"
        val glideVersion = "4.7.1"
        val timberVersion = "4.7.0"
        val prettyTimeVersion = "4.0.1.Final"
        val logInterceptorVersion = "3.9.1"
        val jodaTimeVersion = "2.9.9"
        val koinVersion = "0.9.3"
    }
}