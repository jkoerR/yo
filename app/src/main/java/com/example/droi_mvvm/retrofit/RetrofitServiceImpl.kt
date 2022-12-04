package com.example.droi_mvvm.retrofit

import com.example.droi_mvvm.model.DC_yo
import com.google.gson.JsonObject
import retrofit2.Response


class ApiInterfaceImpl: RetrofitService {
//    override fun recruit(email: String): Observable<ServerResponse> =
//        ApiClient.getApiInterface().isRegisteredUser(email)

    override suspend fun users(q:String?): Response<DC_yo.Res?> =
        NetRetrofit().getRetrofitService().users(q)
}