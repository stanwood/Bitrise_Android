package io.stanwood.bitrise.data.net

import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path
import io.stanwood.bitrise.data.model.Trigger
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.Body


interface BitriseTriggerService {

    @POST("{APP-SLUG}/build/start.json")
    fun start(@Path("APP-SLUG") appSlug: String, @Body trigger: Trigger): Deferred<Any>

}