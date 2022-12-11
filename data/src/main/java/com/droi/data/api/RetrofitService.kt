package com.droi.data.api

import com.droi.data.model.YoReponse
import retrofit2.http.*


interface RetrofitService {

    //    @GET("mobile-config/test_data_recruit_items.json")
//    fun recruit(
////    @Path("id") id: String?,
//    ): Call<JsonObject?>?
//    @GET("mobile-config/test_data_recruit_items.json")
//    suspend fun recruit(
////    @Path("id") id: String?,
//    ): Response<JsonObject?>
    @GET("users")
    suspend fun users(
        @Query("q") q: String,
    ): YoReponse.ResData


}