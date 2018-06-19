/*
 * Copyright 2018 stanwood Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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