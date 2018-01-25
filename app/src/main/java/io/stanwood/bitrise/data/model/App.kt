package io.stanwood.bitrise.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class App(
        @SerializedName("is_disabled") val isDisabled: Boolean, //false
        @SerializedName("project_type") val projectType: Platform, //xamarin
        @SerializedName("provider") val provider: String, //github
        @SerializedName("repo_owner") val repoOwner: String, //bitrise-samples
        @SerializedName("repo_slug") val repoSlug: String, //sample-apps-xamarin-cross-platform
        @SerializedName("repo_url") val repoUrl: String, //https://github.com/bitrise-samples/sample-apps-xamarin-cross-platform.git
        @SerializedName("slug") val slug: String, //f46e89061e967f27
        @SerializedName("title") val title: String //sample-apps-xamarin-cross-platform
) : Parcelable {
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<App> = object : Parcelable.Creator<App> {
            override fun createFromParcel(source: Parcel): App = App(source)
            override fun newArray(size: Int): Array<App?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            1 == source.readInt(),
            Platform.valueOf(source.readString()),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt((if (isDisabled) 1 else 0))
        writeString(projectType.toString())
        writeString(provider)
        writeString(repoOwner)
        writeString(repoSlug)
        writeString(repoUrl)
        writeString(slug)
        writeString(title)
    }
}