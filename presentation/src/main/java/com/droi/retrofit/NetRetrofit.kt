package com.droi.retrofit

import com.droi.App
import com.droi.Const
import com.droi.util.Logger
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetRetrofit {
    var slog: String? = null
    val gson = GsonBuilder().setLenient().create()
    var interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(s: String) {
//            Logger.loge("slog :   $s");
            if (s.contains("FAILED")
                || s.contains("Failed")
                || s.contains("failed")
                || s.contains("error")
                || s.contains("Error")
                || s.contains("Not Found")
            ) {
                slog = slog + s + "\n"
                com.droi.util.Logger.loge("RESULT!!!!   :   " + slog)
            }
        }
    }).setLevel(HttpLoggingInterceptor.Level.BODY)


    var defaultHttpClient = OkHttpClient.Builder() //.connectionPool(cPool)
        //            .connectTimeout(1, TimeUnit.SECONDS)
        //            .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .cookieJar(com.droi.App.cookieJar)
        .addInterceptor(interceptor)
        .build()
    var defaultHttpClient_check = OkHttpClient.Builder() //.connectionPool(cPool)
        //            .connectTimeout(1, TimeUnit.SECONDS)
        //            .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()


    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson)) // 파싱등록
        .client(defaultHttpClient)
        .build()
    var service = retrofit.create(RetrofitService::class.java)

    fun getRetrofitService(): RetrofitService {
        return service
    }
//    fun getRetrofitServiceContext(context: Context): RetrofitService {
//        if (!NetRetrofit.isTimeAutomatic(context)) {
//            Util.showToast(context, "시간설정을 네트워크에서 제공하는 시간으로 설정해 주세요")
//            context.finish()
//            Process.killProcess(Process.myPid())
//            System.runFinalization()
//            System.exit(0)
//        }
//        return service
//    }


}