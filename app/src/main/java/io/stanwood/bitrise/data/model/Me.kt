package io.stanwood.bitrise.data.model

import com.google.gson.annotations.SerializedName


data class Me(
        @SerializedName("username") val username: String)