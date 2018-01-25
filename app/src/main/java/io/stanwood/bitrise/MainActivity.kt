package io.stanwood.bitrise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.stanwood.bitrise.di.PROPERTY_ACTIVITY
import io.stanwood.bitrise.navigation.Navigator
import io.stanwood.bitrise.navigation.SCREEN_SPLASH
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainActivity: AppCompatActivity() {

    private val navigator: Navigator by inject()
    private val navigatorHolder: NavigatorHolder by inject()
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
        setProperty(PROPERTY_ACTIVITY, this)
        setContentView(R.layout.activity_main)
        router.newRootScreen(SCREEN_SPLASH, true)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}