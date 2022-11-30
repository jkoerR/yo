package com.example.droi_mvvm

import android.app.Application
import android.app.Dialog
import android.os.Handler
import android.os.Looper
import com.example.droi_mvvm.retrofit.RetrofitService
import com.example.droi_mvvm.retrofit.NetRetrofit
import com.example.droi_mvvm.util.Util
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.CookieJar
import java.util.*

class App : Application() {
    init {
        instance = this

    }

    override fun onCreate() {
        super.onCreate()
        if (Util.mContext == null) Util.mContext = this
        instance = this
        gMapTmpChunk = HashMap()
        cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(this))
//        retrofitService = NetRetrofit().getService(this)
    }

    companion object {
        @kotlin.jvm.JvmField
        var isQr: Boolean = false
        var move_tap: String = ""
        var instance: App? = null
        var dialog: Dialog? = null
        lateinit var gMapTmpChunk: HashMap<String, Any>
        fun disProgress() {
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    try {
                        if (dialog != null) {
                            if (dialog!!.isShowing) {
                                dialog!!.dismiss()
                                dialog = null
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }, 0
            )
        }

        lateinit var cookieJar: CookieJar
//        lateinit var retrofitService : RetrofitService
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    fun getGlobalApplicationContext(): App {
        checkNotNull(instance) { "this application does not inherit com.kakao.GlobalApplication" }
        return instance!!
    }



}