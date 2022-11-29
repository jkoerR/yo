package com.everything.inlot.retrofit

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {



    @GET("mobile-config/test_data_recruit_items.json")
    fun recruit(
//    @Path("id") id: String?,
    ): Call<JsonObject?>?

    @GET("mobile-config/test_data_cell_items.json")
    fun cell(
//    @Path("id") id: String?,
//    @Query("lastMatch") lastMatch : Long?,
    ): Call<JsonObject?>?

}