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
import com.google.gson.annotations.SerializedName
import io.stanwood.bitrise.R


enum class Platform(@DrawableRes private val iconResId: Int) {

    @SerializedName("android") ANDROID(R.drawable.ic_platform_android),
    @SerializedName("ios") IOS(R.drawable.ic_platform_ios),
    @SerializedName("xamarin") XAMARIN(R.drawable.ic_platform_xamarin),
    @SerializedName("macos") MACOS(R.drawable.ic_platform_macos);

    fun getIcon(resources: Resources) = resources.getDrawable(iconResId)
}