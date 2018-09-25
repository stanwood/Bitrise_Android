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

package io.stanwood.bitrise.ui.settings.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.preference.PreferenceFragmentCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.stanwood.bitrise.R
import kotlinx.android.synthetic.main.layout_toolbar.*
import io.stanwood.bitrise.util.extensions.*
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import android.content.Intent
import android.net.Uri
import io.stanwood.bitrise.BuildConfig

class SettingsFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(bundle: Bundle?, s: String?) {
        addPreferencesFromResource(R.xml.settings)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val currentActivity = activity
        if (currentActivity is AppCompatActivity) {
            toolbar.let {
                //currentActivity.setSupportActionBar(it)
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findPreference(R.string.pref_key_contribute).setOnPreferenceClickListener {
            onContributeClick()
            true
        }
        findPreference(R.string.pref_key_licenses).setOnPreferenceClickListener {
            onLicensesClick()
            true
        }
    }

    private fun onContributeClick() {
        Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(BuildConfig.REPO_URL)
            startActivity(this)
        }
    }

    private fun onLicensesClick() {
        startActivity(Intent(context, OssLicensesMenuActivity::class.java))
    }
}