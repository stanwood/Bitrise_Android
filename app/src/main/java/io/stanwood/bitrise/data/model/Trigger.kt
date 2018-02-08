package io.stanwood.bitrise.data.model

import com.google.gson.annotations.SerializedName

data class Trigger(
        @SerializedName("hook_info") val hookInfo: HookInfo,
        @SerializedName("build_params") val buildParams: BuildParams,
        @SerializedName("triggered_by") val triggeredBy: String = "bitrise_unofficial_android"
)

data class BuildParams(
        @SerializedName("commit_message") val commitMessage: String = "Started via Bitrise Unofficial (Android)",
        @SerializedName("workflow_id") val workflowId: String,
        @SerializedName("commit_hash") val commitHash: String?,
        @SerializedName("tag") val tag: String?,
        @SerializedName("branch") val branch: String?
)

data class HookInfo(
        @SerializedName("type") val type: String = "bitrise",
        @SerializedName("api_token") val apiToken: String
)