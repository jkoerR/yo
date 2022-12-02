package com.example.droi_mvvm

import android.app.Application
import android.app.Dialog
import android.os.Handler
import android.os.Looper
import com.example.droi_mvvm.util.Util
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.CookieJar
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
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

        startKoin {
            androidContext(this@App)
//            androidLogger()
            // 위의 메서드 2개는 없어도 작동하긴 한다
            /* modules() : 컨테이너에 로드할 Koin 모듈 목록 설정. listOf()로 appModule을 구성한 예제가 있었다 */
            modules(appModule)
        }


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