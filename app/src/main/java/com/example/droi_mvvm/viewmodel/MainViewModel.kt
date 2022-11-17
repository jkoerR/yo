package com.example.droi_mvvm.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.droi_mvvm.R
import com.example.droi_mvvm.retrofit.Retrofit_Contract
import com.example.droi_mvvm.retrofit.Retrofit_Model
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.retrofit.NetRetrofit
import com.example.droi_mvvm.ui.DetailActivity
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList


class MainViewModel(application: Application) : AndroidViewModel(application),
    Retrofit_Contract.model.onModelListener {

    var gson = Gson()
    var dtos = ArrayList<GDTO.city>()
    var liveData: MutableLiveData<ArrayList<GDTO.city>> = MutableLiveData<ArrayList<GDTO.city>>()
    var weatherData: MutableLiveData<GDTO.weather_base> = MutableLiveData<GDTO.weather_base>()

    val context = getApplication<Application>().applicationContext
    var retrofit_Model: Retrofit_Model = Retrofit_Model(application.baseContext)

    init {
    }

    fun call_assets() {
        val assetManager = context.resources.assets
        val inputStream = assetManager.open("citylist.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        var jsonArray = gson.fromJson(jsonString, JsonArray::class.java)
        for (json in jsonArray) {
            dtos.add(gson.fromJson(json, GDTO.city::class.java))
        }
        dtos.sortBy { it.country }
        liveData.postValue(dtos)
    }

    fun moveDetail(position: Int) {
        Logger.loge("${dtos[position].id}")
        var intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", dtos[position].id)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent)
    }

    fun requsetWeather(id: String) {
        var jsonObject = JsonObject()
        jsonObject.addProperty("id", id)
        jsonObject.addProperty("appid", context.getString(R.string.openweathermap))
        retrofit_Model.getw(this, jsonObject)

        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.getw(
            jsonObject?.get("id")?.asString,
            jsonObject?.get("appid")?.asString,
        )
        call_response?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.body() != null) {
                    //                    Logger.loge("response.body()  :  " + response.body());
                    onFinished(response.body(), "getw")
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })

    }

    override fun onFinished(json: JsonObject?, from: String?) {
        when (from) {
            "getw" -> {
                Logger.loge("${json}")
//                var weather = gson.fromJson(json?.get("weather").toString(),GDTO.weather::class.java)
                weatherData.value = gson.fromJson(json.toString(), GDTO.weather_base::class.java)
            }
        }
    }
}