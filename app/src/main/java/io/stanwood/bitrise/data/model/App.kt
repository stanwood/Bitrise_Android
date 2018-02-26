package io.stanwood.bitrise.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class App(
        @SerializedName("is_disabled") val isDisabled: Boolean, //false
        @SerializedName("project_type") val projectType: Platform, //xamarin
        @SerializedName("provider") val provider: String, //github
        @SerializedName("repo_owner") val repoOwner: String, //bitrise-samples
        @SerializedName("repo_slug") val repoSlug: String, //sample-apps-xamarin-cross-platform
        @SerializedName("repo_url") val repoUrl: String, //https://github.com/bitrise-samples/sample-apps-xamarin-cross-platform.git
        @SerializedName("slug") val slug: String, //f46e89061e967f27
        @SerializedName("title") val title: String //sample-apps-xamarin-cross-platform
) : Parcelable