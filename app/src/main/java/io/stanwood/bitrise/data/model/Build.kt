package io.stanwood.bitrise.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

data class Build(
        @SerializedName("abort_reason") val abortReason: String?,
        @SerializedName("branch") val branch: String, //master
        @SerializedName("build_number") val number: Int, //20
        @SerializedName("commit_hash") val commitHash: String?, //null
        @SerializedName("commit_message") val commitMessage: String, //generate an APK
        @SerializedName("commit_view_url") val commitViewUrl: String?,
        @SerializedName("environment_prepare_finished_at") val environmentPrepareFinishedAt: Date?, //2017-11-08T13:24:33Z
        @SerializedName("finished_at") val finishedAt: Date?, //2017-11-08T13:26:54Z
        @SerializedName("is_on_hold") val isOnHold: Boolean, //false
        @SerializedName("original_build_params") val originalBuildParams: OriginalBuildParams,
        @SerializedName("pull_request_id") val pullRequestId: Int, //0
        @SerializedName("pull_request_target_branch") val pullRequestTargetBranch: String?,
        @SerializedName("pull_request_view_url") val pullRequestViewUrl: String?,
        @SerializedName("slug") val slug: String, //ddf4134555e833d8
        @SerializedName("stack_config_type") val stackConfigType: String, //standard1
        @SerializedName("stack_identifier") val stackIdentifier: String, //linux-docker-android
        @SerializedName("started_on_worker_at") val startedOnWorkerAt: String, //2017-11-08T13:24:33Z
        @SerializedName("status") val status: BuildStatus,
        @SerializedName("status_text") val statusText: String, //success
        @SerializedName("tag") val tag: String?,
        @SerializedName("triggered_at") val triggeredAt: Date, //2017-11-08T13:24:33Z
        @SerializedName("triggered_by") val triggeredBy: String, //manual-api-demo
        @SerializedName("triggered_workflow") val triggeredWorkflow: String //gen-apk
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readSerializable() as Date?,
            source.readSerializable() as Date?,
            1 == source.readInt(),
            source.readParcelable<OriginalBuildParams>(OriginalBuildParams::class.java.classLoader),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            BuildStatus.values()[source.readInt()],
            source.readString(),
            source.readString(),
            source.readSerializable() as Date,
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(abortReason)
        writeString(branch)
        writeInt(number)
        writeString(commitHash)
        writeString(commitMessage)
        writeString(commitViewUrl)
        writeSerializable(environmentPrepareFinishedAt)
        writeSerializable(finishedAt)
        writeInt((if (isOnHold) 1 else 0))
        writeParcelable(originalBuildParams, 0)
        writeInt(pullRequestId)
        writeString(pullRequestTargetBranch)
        writeString(pullRequestViewUrl)
        writeString(slug)
        writeString(stackConfigType)
        writeString(stackIdentifier)
        writeString(startedOnWorkerAt)
        writeInt(status.ordinal)
        writeString(statusText)
        writeString(tag)
        writeSerializable(triggeredAt)
        writeString(triggeredBy)
        writeString(triggeredWorkflow)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Build> = object : Parcelable.Creator<Build> {
            override fun createFromParcel(source: Parcel): Build = Build(source)
            override fun newArray(size: Int): Array<Build?> = arrayOfNulls(size)
        }
    }
}

data class OriginalBuildParams(
        @SerializedName("branch") val branch: String, //master
        @SerializedName("commit_message") val commitMessage: String, //generate an APK
        @SerializedName("workflow_id") val workflowId: String //gen-apk
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(branch)
        writeString(commitMessage)
        writeString(workflowId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OriginalBuildParams> = object : Parcelable.Creator<OriginalBuildParams> {
            override fun createFromParcel(source: Parcel): OriginalBuildParams = OriginalBuildParams(source)
            override fun newArray(size: Int): Array<OriginalBuildParams?> = arrayOfNulls(size)
        }
    }
}