package com.example.droi_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.droi_mvvm.App
import com.example.droi_mvvm.model.DC_OP
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//class MainViewModel(application: Application) : AndroidViewModel(application),
//    Retrofit_Contract.model.onModelListener {
class MainViewModel(application: Application) : AndroidViewModel(application){

    var gson = Gson()
    var dtos = ArrayList<DC_OP.summoner>()
    var liveData_games: MutableLiveData<ArrayList<DC_OP.games>> = MutableLiveData<ArrayList<DC_OP.games>>()
    var liveData_summoner: MutableLiveData<DC_OP.summoner> = MutableLiveData<DC_OP.summoner>()
    val context = getApplication<Application>().applicationContext

    init {

    }

    fun requsetSummoner(id: String) {
        val call_response: Call<JsonObject?>? = App.retrofitService.summoner(
            id,
        )
        call_response?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.body() != null) {
//                    Logger.loge("response.body()  :  " + response.body());
//                    onFinished(response.body(), "getw")
                    liveData_summoner.value = gson.fromJson(response.body()!!.get("summoner"), DC_OP.summoner::class.java)
//                    liveData_summoner.postValue(gson.fromJson(response.body().toString(), DC_OP.summoner::class.java))
                    Logger.loge("liveData_summoner  :  ${liveData_summoner.value}")
                    requsetmatches("genetory")
                }
            }
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })

    }
    fun requsetmatches(id: String) {
        val call_response: Call<JsonObject?>? = App.retrofitService.matches(
            id,
            "",
        )
        call_response?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.body() != null) {
//                    Logger.loge("response.body()  :  " + response.body());
//                    onFinished(response.body(), "getw")
                    liveData_games.value = gson.fromJson(response.body()!!.get("games").asJsonArray, ArrayList<DC_OP.games>()::class.java)
//                    liveData_games.postValue(gson.fromJson(response.body()!!.get("games").asJsonArray, ArrayList<DC_OP.games>()::class.java))

//                    Logger.loge("liveData_games  :  ${liveData_games.value}")
                }
            }
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })

    }

//    override fun onFinished(json: JsonObject?, from: String?) {
//        when (from) {
//            "getw" -> {
//                Logger.loge("${json}")
////                var weather = gson.fromJson(json?.get("weather").toString(),GDTO.weather::class.java)
//                weatherData.value = gson.fromJson(json.toString(), GDTO.weather_base::class.java)
//            }
//        }
//    }
}