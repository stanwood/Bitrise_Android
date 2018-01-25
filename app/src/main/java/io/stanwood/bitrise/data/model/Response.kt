package io.stanwood.bitrise.data.model

import com.google.gson.annotations.SerializedName


data class Response<T>(
        @SerializedName("data") val data: T,
        @SerializedName("paging") val paging: Paging)