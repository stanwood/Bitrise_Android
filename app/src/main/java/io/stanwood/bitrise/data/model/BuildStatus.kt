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

package io.stanwood.bitrise.data.model

import android.content.res.Resources
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.google.gson.annotations.SerializedName
import io.stanwood.bitrise.R

enum class BuildStatus(
        @StringRes private val titleResId: Int,
        @ColorRes private val colorResId: Int,
        @DrawableRes private val iconResId: Int) {

    @SerializedName("0")
    IN_PROGRESS(
            R.string.build_status_in_progress,
            R.color.build_status_in_progress,
            R.drawable.ic_build_status_in_progress),

    @SerializedName("1")
    SUCCESS(
            R.string.build_status_success,
            R.color.build_status_success,
            R.drawable.ic_build_status_success),


    @SerializedName("2")
    FAILURE(
            R.string.build_status_failure,
            R.color.error_color_material,
            R.drawable.ic_build_status_error),


    @SerializedName("3")
    ABORTED(
            R.string.build_status_aborted,
            R.color.build_status_aborted,
            R.drawable.ic_build_status_aborted);

    fun getTitle(resources: Resources) = resources.getString(titleResId)
    fun getColor(resources: Resources) = resources.getColor(colorResId)
    fun getIcon(resources: Resources) = resources.getDrawable(iconResId)
}