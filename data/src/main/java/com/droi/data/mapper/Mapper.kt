package com.droi.data.mapper

import com.droi.data.model.YoReponse
import com.droi.domain.model.YoEntity

object Mapper {

    fun mapperToRes(yoResponse: YoReponse.ResData): YoEntity.Res {
        return YoEntity.Res(
            total_count = yoResponse.total_count,
            incomplete_results = yoResponse.incomplete_results,
            items = yoResponse.items,
        )
    }

//    @SerializedName("total_count") val total_count: Int,
//    @SerializedName("incomplete_results") val incomplete_results: Boolean,
//    @SerializedName("items") val items: ArrayList<YoEntity.Items>,

}