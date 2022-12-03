package com.example.droi_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.droi_mvvm.App
import com.example.droi_mvvm.model.DC_JOB
import com.example.droi_mvvm.retrofit.NetRetrofit
import com.example.droi_mvvm.retrofit.RetrofitService
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//class MainViewModel(application: Application) : AndroidViewModel(application),
//    Retrofit_Contract.model.onModelListener {
class MainViewModel(application: Application,private val repo: RetrofitService) : BaseViewModel(application) {

//    var retrofitService : RetrofitService = NetRetrofit().getRetrofitService()
    var gson = Gson()
    var liveData_ResRecruit: MutableLiveData<DC_JOB.ResRecruit> = MutableLiveData<DC_JOB.ResRecruit>()
    var liveData_ResCell: MutableLiveData<DC_JOB.ResCell> = MutableLiveData<DC_JOB.ResCell>()
    val context = application

    init {

    }

    fun requsetRecruit() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.recruit()
            if (response.isSuccessful){
                liveData_ResRecruit.postValue(response.body())
            }else{
                Util.showToast("${response.code()} ${response.message()}")
            }
        }
    }
    fun requsetCell() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.cell()
            if (response.isSuccessful){
                liveData_ResCell.postValue(response.body())
            }else{
                Util.showToast("${response.code()} ${response.message()}")
            }
        }
    }
}