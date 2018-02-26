package io.stanwood.bitrise.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class OriginalBuildParams(
        @SerializedName("branch") val branch: String, //master
        @SerializedName("commit_message") val commitMessage: String, //generate an APK
        @SerializedName("workflow_id") val workflowId: String //gen-apk
): Parcelable