package io.stanwood.bitrise.data.net

import io.stanwood.bitrise.data.model.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface BitriseService {

    @GET("v0.1/me")
    fun login(@Header("Authorization") token: String): Deferred<Response<Me>>

    @GET("v0.1/me/apps")
    fun getApps(
            @Header("Authorization") token: String,
            @Query("limit") limit: Int = 10): Deferred<Response<List<App>>>

    @GET("v0.1/apps/{APP-SLUG}/builds")
    fun getBuilds(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Query("limit") limit: Int = 10,
            @Query("cursor") cursor: String? = null): Deferred<Response<List<Build>>>

    @GET("v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/log")
    fun getBuildLog(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Path("BUILD-SLUG") buildLog: String,
            @Query("limit") limit: Int = 10,
            @Query("cursor") cursor: String? = null): Deferred<Log>

    @GET("v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/artifacts")
    fun getBuildArtifacts(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Path("BUILD-SLUG") buildSlug: String,
            @Query("limit") limit: Int = 10,
            @Query("cursor") cursor: String? = null): Deferred<Response<List<Artifact>>>

    @GET("v0.1/apps/{APP-SLUG}/builds/{BUILD-SLUG}/artifacts/{ARTIFACT-SLUG}")
    fun getBuildArtifact(
            @Header("Authorization") token: String,
            @Path("APP-SLUG") appSlug: String,
            @Path("BUILD-SLUG") buildSlug: String,
            @Path("ARTIFACT-SLUG") artifactSlug: String): Deferred<Response<Artifact>>
}