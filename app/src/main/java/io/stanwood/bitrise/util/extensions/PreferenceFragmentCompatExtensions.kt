package io.stanwood.bitrise.util.extensions

import android.support.annotation.StringRes
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceFragmentCompat

fun PreferenceFragmentCompat.findPreference(@StringRes keyResId: Int): Preference {
    return findPreference(this.getString(keyResId))
}