package io.stanwood.bitrise.util.extensions

import org.koin.KoinContext
import org.koin.standalone.StandAloneContext


fun Any.setProperty(key: String, value: Any?) {
    value?.let {
        (StandAloneContext.koinContext as KoinContext).setProperty(key, it)
    } ?: (StandAloneContext.koinContext as KoinContext).releaseProperties(key)

}