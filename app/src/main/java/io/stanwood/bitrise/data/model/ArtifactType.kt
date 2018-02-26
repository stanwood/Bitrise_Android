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