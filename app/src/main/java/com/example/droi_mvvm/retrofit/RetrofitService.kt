package com.example.droi_mvvm.retrofit

import com.example.droi_mvvm.model.DC_yo
import com.google.gson.JsonObject
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