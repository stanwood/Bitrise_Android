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
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.google.gson.annotations.SerializedName
import io.stanwood.bitrise.R


enum class ArtifactType(
        @StringRes private val titleResId: Int,
        @DrawableRes private val iconResId: Int) {

    @SerializedName("file") FILE(R.string.artifact_type_file, R.drawable.ic_artifact_file),
    @SerializedName("android-apk") APK(R.string.artifact_type_ipa, R.drawable.ic_artifact_apk),
    @SerializedName("ios-ipa") IPA(R.string.artifact_type_ipa, R.drawable.ic_artifact_ipa);

    fun getTitle(resources: Resources) = resources.getString(titleResId)
    fun getIcon(resources: Resources) = resources.getDrawable(iconResId)
}