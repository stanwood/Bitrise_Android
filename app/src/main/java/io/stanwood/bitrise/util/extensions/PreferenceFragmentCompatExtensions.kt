package io.stanwood.bitrise.util.extensions

import androidx.annotation.StringRes
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

fun PreferenceFragmentCompat.findPreference(@StringRes keyResId: Int): Preference {
    return findPreference(this.getString(keyResId))
}