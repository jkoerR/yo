package com.example.droi_mvvm.retrofit

import com.example.droi_mvvm.model.DC_JOB
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


class ApiInterfaceImpl: RetrofitService {
//    override fun recruit(email: String): Observable<ServerResponse> =
//        ApiClient.getApiInterface().isRegisteredUser(email)

    override suspend fun recruit(): Response<DC_JOB.ResRecruit?> =
        NetRetrofit().getRetrofitService().recruit()

    override suspend fun cell(): Response<DC_JOB.ResCell?> =
        NetRetrofit().getRetrofitService().cell()
}