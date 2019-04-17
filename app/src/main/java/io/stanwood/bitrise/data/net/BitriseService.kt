/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.stanwood.bitrise.data.net

import io.stanwood.bitrise.BuildConfig
import io.stanwood.bitrise.data.model.*
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
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
            @Query("limit") limit: Int? = null): Deferred<Log>

    @GET
    fun downloadFile(
            @Url url: String
    ): Deferred<ResponseBody>

    @GET("v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/artifacts")
    fun getBuildArtifacts(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Path("BUILD-SLUG") buildSlug: String,
            @Query("next") cursor: String? = null,
            @Query("limit") limit: Int? = null): Deferred<Response<List<Artifact>>>

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