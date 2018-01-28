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