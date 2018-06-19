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

package io.stanwood.bitrise.data.net

import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.model.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*


interface BitriseService {

    @GET("v0.1/me")
    fun login(@Header("Authorization") token: String): Deferred<Response<Me>>

    @GET("v0.1/apps/{APP-SLUG}")
    fun getApp(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String): Deferred<Response<App>>

    @GET("v0.1/me/apps")
    fun getApps(
            @Header("Authorization") token: String,
            @Query("next")  cursor: String? = null,
            @Query("limit") limit: Int = BuildConfig.DEFAULT_PAGE_SIZE,
            @Query("sort_by") sortBy: SortBy = SortBy.last_build_at): Deferred<Response<List<App>>>

    @GET("v0.1/apps/{APP-SLUG}/builds")
    fun getBuilds(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Query("next") cursor: String? = null,
            @Query("limit") limit: Int = BuildConfig.DEFAULT_PAGE_SIZE): Deferred<Response<List<Build>>>

    @GET("v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/log")
    fun getBuildLog(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Path("BUILD-SLUG") buildLog: String,
            @Query("next") cursor: String? = null,
            @Query("limit") limit: Int = BuildConfig.DEFAULT_PAGE_SIZE): Deferred<Log>

    @GET("v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/artifacts")
    fun getBuildArtifacts(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Path("BUILD-SLUG") buildSlug: String,
            @Query("next") cursor: String? = null,
            @Query("limit") limit: Int = BuildConfig.DEFAULT_PAGE_SIZE): Deferred<Response<List<Artifact>>>

    @GET("v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/artifacts/{ARTIFACT-SLUG}")
    fun getBuildArtifact(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Path("BUILD-SLUG") buildSlug: String,
            @Path("ARTIFACT-SLUG") artifactSlug: String): Deferred<Response<Artifact>>

    @POST("/v0.1/apps/{APP-SLUG}/builds")
    fun startNewBuild(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Body params: NewBuildParams): Deferred<NewBuildResponse>
}