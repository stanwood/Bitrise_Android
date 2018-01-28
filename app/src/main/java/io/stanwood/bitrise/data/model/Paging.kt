package io.stanwood.bitrise.data.model

import com.google.gson.annotations.SerializedName


data class Paging(
        @SerializedName("total_item_count") val itemCount: Int,
        @SerializedName("page_item_limit") val pageLimit: Int,
        @SerializedName("next") val nextCursor: String)