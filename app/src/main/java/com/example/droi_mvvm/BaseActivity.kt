package com.example.droi_mvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.droi_mvvm.retrofit.Retrofit_Contract
import com.example.droi_mvvm.retrofit.Retrofit_Presenter
import com.example.droi_mvvm.callback.OnItemClick
import com.google.gson.Gson
import com.google.gson.JsonObject

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener, Retrofit_Contract.View,
    OnItemClick {


    //    lateinit var binding: ActivityCoinBinding
//    var retrofit_Presenter: Retrofit_Presenter? = null
    //    open  == Public 비슷한 개념 없으면 자바 final 개념
    var retrofit_Presenter: Retrofit_Presenter? = null
    var gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_coin)
//        retrofit_Presenter = Retrofit_Presenter(this, this)
        _init()
    }

    abstract fun _init()
//    binding = DataBindingUtil.setContentView(this, R.layout.activity_term)
//    retrofit_Presenter = Retrofit_Presenter(this, this)


    override fun onClick(v: View) {
//        var cPosition: Int?
//        var cIntent : Intent?
//        when (v.id) {
////            R.id.tvMainHello -> {
////
////            }
//            else -> {
//
//            }
//        }
    }

    override fun jk_result(result: JsonObject?, from: String?) {
//        if (App.preminum_usr_yn == ""){
//            App.preminum_usr_yn = result!!["preminum_usr_yn"].asString
//        }else{
//            if (App.preminum_usr_yn !=result!!["preminum_usr_yn"].asString){
//                App.preminum_usr_yn = result!!["preminum_usr_yn"].asString
//                finishAffinity()
//                val cIntent = Intent(this, IntroActivity::class.java)
//                Util.goIntent(this, cIntent, true)
//            }
//        }
//        App().disProgress()
//        Logger.loge("jk_result    :   " + result + "   from   :  " + from)
//        val code = result!!["rst_cd"].asString
//        var box_res: String
//        when (code) {
//            Const.API_SUC -> {
//                when (from) {
//                    Const.WHAT -> {
//
//                    }
//                }
//            }
//            else -> {
//
//            }
//        }
    }

    override fun onclic(v: View, position: Int) {

    }
}