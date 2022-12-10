package com.droi.retrofit

import com.droi.model.DC_yo
import retrofit2.Response
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
    @Query("q") q: String?,
    ): Response<DC_yo.Res?>


}