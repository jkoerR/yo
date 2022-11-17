package com.example.droi_mvvm.retrofit

import android.content.Context
import com.example.droi_mvvm.retrofit.Retrofit_Contract
import com.example.droi_mvvm.retrofit.Retrofit_Model
import com.google.gson.JsonObject

class Retrofit_Presenter : Retrofit_Contract.Presenter , Retrofit_Contract.model.onModelListener {

    var view: Retrofit_Contract.View? = null
    var model: Retrofit_Model? = null
    var context: Context? = null

//    constructor(view: Retrofit_Contract.View?, activity: Activity?) {
//        this.view = view
//        this.activity = activity
//        model = Retrofit_Model()
//        model!!.setContext(activity)
//    }
    constructor(view: Retrofit_Contract.View?, baseContext: Context) {
        this.view = view
        this.context = baseContext
//        model = Retrofit_Model()
//        model!!.setContext(context)
    }

//    fun Retrofit_Presenter(view: Retrofit_Contract.View?, activity: Activity?) {
//        this.view = view
//        model = Retrofit_Model()
//        this.activity = activity
//        model!!.setContext(activity)
//    }

    override fun onFinished(result: JsonObject?, from: String?) {
        view?.jk_result(result, from)
    }
    override fun intro(jsonObject: JsonObject?) {
        model?.intro(this, jsonObject)
    }
//    override fun check(jsonObject: JsonObject?) {
//        model?.check(this, jsonObject)
//    }
//    override fun terms(jsonObject: JsonObject?) {
//        model?.terms(this, jsonObject)
//    }
//    override fun my_info(jsonObject: JsonObject?) {
//        model?.my_info(this, jsonObject)
//    }
//    override fun pay(jsonObject: JsonObject?) {
//        model?.pay(this, jsonObject)
//    }
//    override fun sku_id_list(jsonObject: JsonObject?) {
//        model?.sku_id_list(this, jsonObject)
//    }
//    override fun my_leave(jsonObject: JsonObject?) {
//        model?.my_leave(this, jsonObject)
//    }
//    override fun my_push_set(jsonObject: JsonObject?) {
//        model?.my_push_set(this, jsonObject)
//    }
//    override fun cs_board_list(jsonObject: JsonObject?) {
//        model?.cs_board_list(this, jsonObject)
//    }
//    override fun winning(jsonObject: JsonObject?) {
//        model?.winning(this, jsonObject)
//    }
//    override fun analyze(jsonObject: JsonObject?) {
//        model?.analyze(this, jsonObject)
//    }
//    override fun filter_list(jsonObject: JsonObject?) {
//        model?.filter_list(this, jsonObject)
//    }
//    override fun filter_comb(jsonObject: JsonObject?) {
//        model?.filter_comb(this, jsonObject)
//    }
//    override fun filter_gbn_load(jsonObject: JsonObject?) {
//        model?.filter_gbn_load(this, jsonObject)
//    }
//    override fun lastest_data_view(jsonObject: JsonObject?) {
//        model?.lastest_data_view(this, jsonObject)
//    }
//    override fun machine_learning(jsonObject: JsonObject?) {
//        model?.machine_learning(this, jsonObject)
//    }
//    override fun filter_del(jsonObject: JsonObject?) {
//        model?.filter_del(this, jsonObject)
//    }
//    override fun filter_load(jsonObject: JsonObject?) {
//        model?.filter_load(this, jsonObject)
//    }
//    override fun filter_reg(jsonObject: JsonObject?) {
//        model?.filter_reg(this, jsonObject)
//    }
//    override fun seller(jsonObject: JsonObject?) {
//        model?.seller(this, jsonObject)
//    }
//    override fun cs_board_reg(jsonObject: JsonObject?) {
//        model?.cs_board_reg(this, jsonObject)
//    }
//    override fun faq(jsonObject: JsonObject?) {
//        model?.faq(this, jsonObject)
//    }
//    override fun board_list(jsonObject: JsonObject?) {
//        model?.board_list(this, jsonObject)
//    }
//    override fun board_view(jsonObject: JsonObject?) {
//        model?.board_view(this, jsonObject)
//    }
//    override fun my_lotto_set_load(jsonObject: JsonObject?) {
//        model?.my_lotto_set_load(this, jsonObject)
//    }
//    override fun my_lotto_set(jsonObject: JsonObject?) {
//        model?.my_lotto_set(this, jsonObject)
//    }
//    override fun my_lotto_list(jsonObject: JsonObject?) {
//        model?.my_lotto_list(this, jsonObject)
//    }
//    override fun my_lotto_del(jsonObject: JsonObject?) {
//        model?.my_lotto_del(this, jsonObject)
//    }
//    override fun buisness(jsonObject: JsonObject?) {
//        model?.buisness(this, jsonObject)
//    }
//    override fun deposit_reg(jsonObject: JsonObject?) {
//        model?.deposit_reg(this, jsonObject)
//    }

}