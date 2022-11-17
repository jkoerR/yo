package com.example.droi_mvvm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.droi_mvvm.retrofit.Retrofit_Contract

import com.example.droi_mvvm.callback.OnItemClick
import com.google.gson.Gson
import com.google.gson.JsonObject

abstract class BaseFragment : Fragment(), View.OnClickListener, Retrofit_Contract.View,
    OnItemClick {

    var gson = Gson()
    override fun onStart() {
        super.onStart()
//        _init()
    }

    abstract fun _init()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _init()
    }

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
//        Logger.loge("${result}       ${from}     ${App.preminum_usr_yn} ")
//        if (App.preminum_usr_yn == ""){
//            App.preminum_usr_yn = result!!["preminum_usr_yn"].asString
//        }else{
//            if (App.preminum_usr_yn !=result!!["preminum_usr_yn"].asString){
//                App.preminum_usr_yn = result!!["preminum_usr_yn"].asString
//                activity!!.finishAffinity()
//                val cIntent = Intent(activity, IntroActivity::class.java)
//                Util.goIntent(activity, cIntent, true)
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
}