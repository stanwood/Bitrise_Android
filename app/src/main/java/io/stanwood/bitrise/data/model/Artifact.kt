package io.stanwood.bitrise.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Artifact(
        @SerializedName("artifact_type") val artifactType: ArtifactType, //android-apk
        @SerializedName("expiring_download_url") val expiringDownloadUrl: String, //https://bitrise-prod-build-storage.s3.amazonaws.com/builds/ddf4134555e833d8/artifacts/3205846/app-debug.apk?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAIOC7N256G7J2W2TQ%2F20171122%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20171122T135501Z&X-Amz-Expires=600&X-Amz-SignedHeaders=host&X-Amz-Signature=bad4467b83a1d98a6046b59a1b232bb0888decf203e039c9b3798f7b4950b68c
        @SerializedName("file_size_bytes") val fileSizeBytes: Int, //607185
        @SerializedName("is_public_page_enabled") val isPublicPageEnabled: Boolean, //true
        @SerializedName("public_install_page_url") val publicInstallPageUrl: String?, //https://www.bitrise.io/artifact/3205846/p/300e0121b50985fd631fe304d549006f
        @SerializedName("slug") val slug: String, //5a9f5da8d5f1057c
        @SerializedName("title") val title: String //app-debug.apk
) : Parcelable {
    constructor(source: Parcel) : this(
            ArtifactType.values()[source.readInt()],
            source.readString(),
            source.readInt(),
            1 == source.readInt(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(artifactType.ordinal)
        writeString(expiringDownloadUrl)
        writeInt(fileSizeBytes)
        writeInt((if (isPublicPageEnabled) 1 else 0))
        writeString(publicInstallPageUrl)
        writeString(slug)
        writeString(title)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Artifact> = object : Parcelable.Creator<Artifact> {
            override fun createFromParcel(source: Parcel): Artifact = Artifact(source)
            override fun newArray(size: Int): Array<Artifact?> = arrayOfNulls(size)
        }
    }
}