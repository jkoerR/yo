package com.example.droi_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.droi_mvvm.App
import com.example.droi_mvvm.model.DC_OP
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
    var dtos = ArrayList<DC_OP.summoner>()
    var liveData_matches: MutableLiveData<DC_OP.matches> = MutableLiveData<DC_OP.matches>()
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
//                    liveData_summoner.postValue(gson.fromJson(response.body()!!.get("summoner"), DC_OP.summoner::class.java))
//                    Logger.loge("liveData_summoner  :  ${liveData_summoner.value}")
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })

    }

    fun requsetmatches(id: String,lastMatch: Long) {
        val call_response: Call<JsonObject?>? = App.retrofitService.matches(
            id,
            lastMatch,
        )
        call_response?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.body() != null) {
//                    Logger.loge("response.body()  :  " + response.body());
//                    liveData_games.value = gson.fromJson(response.body()!!.get("games").asJsonArray, ArrayList<DC_OP.games>()::class.java)
                    if (lastMatch != 0L){
                        val game = liveData_games.value
                        game?.addAll(gson.fromJson(response.body()!!, DC_OP.matches()::class.java).games)
                        liveData_games.postValue(game!!)
                    }else{
                        liveData_matches.postValue(gson.fromJson(response.body()!!, DC_OP.matches()::class.java))
                    }

                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })
    }

    fun calcMost(champions: ArrayList<DC_OP.champions>): ArrayList<DC_OP.champions> {
        val arr = ArrayList<DC_OP.champions>()
        for ((i, champ) in champions.withIndex()) {
            val iter = arr.listIterator()
//            Logger.loge("${arr.size}   :  ${champ.name}  ${(champ.wins.toDouble() / champ.games.toDouble())}")
            if (arr.size == 0) {
                iter.add(champ)
            } else {
                val iter = arr.listIterator()
//                Logger.loge("iter.hasNext() : ${iter.hasNext()}")
                while (iter.hasNext()) {
                    val n = iter.next().copy()
//                    Logger.loge("n   :   ${n.name}    ${(n.wins.toDouble() / n.games.toDouble())}")
                    if ((n.wins.toDouble() / n.games.toDouble()) < (champ.wins.toDouble() / champ.games.toDouble())) {
                        iter.remove()
                        iter.add(champ)
                        iter.add(n)
                        break
                    } else {
                        iter.add(champ)
                    }
                }
            }
        }
        return arr
    }
    fun calcPosition(positions: ArrayList<DC_OP.positions>): String{
        var position = ""
        var num = 0
        for (po in positions){
            if (num < po.games){
                num = po.games
                position = po.positionName
            }
        }
        return  position
    }
    fun calcPosiper(positions: ArrayList<DC_OP.positions>): String{
        var positper = 0
        var num = 0
        var all = 0
        for (po in positions){
            all += po.games
            if (num < po.games){
                num = po.games
                positper = po.games
            }
        }
        return  "${((positper.toDouble()/all.toDouble())*100).toInt()}%"
    }
}