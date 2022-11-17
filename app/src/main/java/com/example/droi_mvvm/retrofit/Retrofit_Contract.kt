package com.example.droi_mvvm.retrofit

import com.google.gson.JsonObject

interface Retrofit_Contract {

    interface model {
        interface onModelListener {
            fun onFinished(Sring: JsonObject?, from: String?)
        }

        fun intro(onModelListener: onModelListener?, jsonObject: JsonObject?)
        fun getw(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun terms(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun my_info(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun cs_board_list(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun cs_board_reg(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun winning(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun filter_list(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun filter_del(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun filter_load(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun filter_reg(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun seller(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun faq(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun board_list(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun board_view(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun my_lotto_set_load(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun filter_gbn_load(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun lastest_data_view(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun my_push_set(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun my_lotto_set(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun my_leave(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun my_lotto_list(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun my_lotto_del(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun analyze(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun filter_comb(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun machine_learning(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun sku_id_list(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun pay(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun buisness(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun deposit_reg(onModelListener: onModelListener?, jsonObject: JsonObject?)
//        fun check(onModelListener: onModelListener?, jsonObject: JsonObject?)
    }

    interface View {
        fun jk_result(result: JsonObject?, from: String?)
    }

    interface Presenter {
        fun intro(jsonObject: JsonObject?)
//        fun terms(jsonObject: JsonObject?)
//        fun my_info(jsonObject: JsonObject?)
//        fun cs_board_list(jsonObject: JsonObject?)
//        fun cs_board_reg(jsonObject: JsonObject?)
//        fun winning(jsonObject: JsonObject?)
//        fun filter_list(jsonObject: JsonObject?)
//        fun filter_del(jsonObject: JsonObject?)
//        fun filter_load(jsonObject: JsonObject?)
//        fun filter_reg(jsonObject: JsonObject?)
//        fun seller(jsonObject: JsonObject?)
//        fun faq(jsonObject: JsonObject?)
//        fun board_list(jsonObject: JsonObject?)
//        fun board_view(jsonObject: JsonObject?)
//        fun my_lotto_set_load(jsonObject: JsonObject?)
//        fun filter_gbn_load(jsonObject: JsonObject?)
//        fun lastest_data_view(jsonObject: JsonObject?)
//        fun my_push_set(jsonObject: JsonObject?)
//        fun my_lotto_set(jsonObject: JsonObject?)
//        fun my_leave(jsonObject: JsonObject?)
//        fun my_lotto_list(jsonObject: JsonObject?)
//        fun my_lotto_del(jsonObject: JsonObject?)
//        fun analyze(jsonObject: JsonObject?)
//        fun filter_comb(jsonObject: JsonObject?)
//        fun machine_learning(jsonObject: JsonObject?)
//        fun sku_id_list(jsonObject: JsonObject?)
//        fun pay(jsonObject: JsonObject?)
//        fun buisness(jsonObject: JsonObject?)
//        fun deposit_reg(jsonObject: JsonObject?)
//        fun check(jsonObject: JsonObject?)
    }

}