package com.droi.viewmodel

import android.app.Application
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.droi.db.AppDatabase
import com.droi.db.Contacts
import com.droi.model.DC_yo
import com.droi.retrofit.RetrofitService
import com.droi.util.Logger
import com.droi.util.Util
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application, private val repo: RetrofitService) : BaseViewModel(application) {

    var gson = Gson()
    var liveData_Res: MutableLiveData<DC_yo.Res> = MutableLiveData<DC_yo.Res>()
    var change: Int  = -1;
    val context = application

    init {

    }

    fun requsetUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.users("shop")
            if (response.isSuccessful) {
                response.body()?.let { setLike(it) }
            } else {
                var handler = android.os.Handler(Looper.getMainLooper())
                com.droi.util.Util.showToast("${response.code()} ${response.message()}")
            }
        }
    }

    fun setLike(body: DC_yo.Res) {
        val db = AppDatabase.getInstance(context)
        for ((i, b) in body.items.withIndex()) {
            val result = db?.contactsDao()?.findByResult(b.id)
            if (result != null) {
                b.like = true
                body.items[i] = b
            }
        }
        liveData_Res.postValue(body)
    }

    fun isLike(position: Int) {
        val db = AppDatabase.getInstance(context)
        val res = liveData_Res.value
        val item = res?.items?.get(position)
        if (item != null) {
            val result = db?.contactsDao()?.findByResult(item.id)
            com.droi.util.Logger.loge("result   ${result}")
            if (result == null) {
                db?.contactsDao()?.insert(Contacts(0,item.id))
                item.like = true
            } else {
                db.contactsDao().delete(result)
                item.like = false
            }
            res.items[position] = item
            change = position
            liveData_Res.postValue(res!!)
        }
    }

//    https://api.github.com/search/users?q=shop
}