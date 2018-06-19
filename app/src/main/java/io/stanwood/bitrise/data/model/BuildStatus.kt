/*
 * Copyright 2018 stanwood Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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