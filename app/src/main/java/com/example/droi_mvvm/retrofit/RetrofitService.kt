package com.example.droi_mvvm.retrofit

import com.example.droi_mvvm.model.DC_JOB
import com.google.gson.JsonObject
import retrofit2.Call
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
    @GET("mobile-config/test_data_recruit_items.json")
    suspend fun recruit(
//    @Path("id") id: String?,
    ): Response<DC_JOB.ResRecruit?>

    @GET("mobile-config/test_data_cell_items.json")
    suspend fun cell(
//    @Path("id") id: String?,
//    @Query("lastMatch") lastMatch : Long?,
    ): Response<DC_JOB.ResCell?>

}