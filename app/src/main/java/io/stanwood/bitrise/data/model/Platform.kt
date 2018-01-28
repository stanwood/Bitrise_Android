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