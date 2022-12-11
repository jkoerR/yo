package com.droi.data.model

import com.droi.domain.model.YoEntity
import java.io.Serializable
import com.google.gson.annotations.SerializedName

class YoReponse {
    data class ResData(
        @SerializedName("total_count") val total_count: Int,
        @SerializedName("incomplete_results") val incomplete_results: Boolean,
        @SerializedName("items") val items: ArrayList<YoEntity.Items>,
    ) : Serializable

//    data class Items(
//        var login: String = "",
//        var id: Int = 0,
//        var avatar_url: String = "",
//        var html_url: String = "",
//        var like: Boolean = false,
//    ) : Serializable
}


