package io.stanwood.bitrise.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
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
): Parcelable