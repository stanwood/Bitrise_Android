package io.stanwood.bitrise.data.model
import com.google.gson.annotations.SerializedName
import io.stanwood.bitrise.BuildConfig


data class NewBuildParams(
    @SerializedName("build_params") val buildParams: BuildParams,
    @SerializedName("hook_info") val hookInfo: HookInfo = HookInfo("bitrise"),
    @SerializedName("triggered_by") val triggeredBy: String = BuildConfig.APPLICATION_ID
)

data class HookInfo(
    @SerializedName("type") val type: String
)

data class BuildParams(
    @SerializedName("branch") val branch: String,
    @SerializedName("workflow_id") val workflowId: String
)