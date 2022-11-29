package com.example.droi_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.droi_mvvm.App
import com.example.droi_mvvm.model.DC_JOB
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//class MainViewModel(application: Application) : AndroidViewModel(application),
//    Retrofit_Contract.model.onModelListener {
class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gson = Gson()
    var liveData_ResRecruit: MutableLiveData<DC_JOB.ResRecruit> = MutableLiveData<DC_JOB.ResRecruit>()
    var liveData_ResCell: MutableLiveData<DC_JOB.ResCell> = MutableLiveData<DC_JOB.ResCell>()
    val context = getApplication<Application>().applicationContext

    init {

    }

    fun requsetRecruit() {
        val call_response: Call<JsonObject?>? = App.retrofitService.recruit(
        )
        call_response?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.body() != null) {
//                    Logger.loge("response.body()  :  " + response.body());
//                    onFinished(response.body(), "getw")
                    liveData_ResRecruit.value = gson.fromJson(response.body(), DC_JOB.ResRecruit::class.java)
//                    liveData_summoner.postValue(gson.fromJson(response.body()!!.get("summoner"), DC_OP.summoner::class.java))
                    Logger.loge("liveData_ResRecruit  :  ${liveData_ResRecruit.value}")
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })
    }
    fun requsetCell() {
        val call_response: Call<JsonObject?>? = App.retrofitService.cell(
        )
        call_response?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.body() != null) {
//                    Logger.loge("response.body()  :  " + response.body());
//                    onFinished(response.body(), "getw")
                    liveData_ResCell.value = gson.fromJson(response.body(), DC_JOB.ResCell::class.java)
//                    liveData_summoner.postValue(gson.fromJson(response.body()!!.get("summoner"), DC_OP.summoner::class.java))
                    Logger.loge("liveData_ResCell  :  ${liveData_ResCell.value}")
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })
    }

}