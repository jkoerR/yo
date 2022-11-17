//package com.example.droi_mvvm.retrofit
//
//import android.content.Context
//import com.example.droi_mvvm.retrofit.Retrofit_Contract.model.onModelListener
//import com.example.droi_mvvm.Const
//import com.example.droi_mvvm.util.Logger
//import com.example.droi_mvvm.util.Util
//import com.google.gson.JsonObject
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class Retrofit_Model(context: Context) : Retrofit_Contract.model {
//
//    private var context: Context? = context
//
////    fun setContext(context: Context?) {
////        this.context = context
////    }
//
//    override fun intro(onModelListener: onModelListener?, jsonObject: JsonObject?) {
//        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.intro(
//            jsonObject?.get("usr_key")?.asString,
//            jsonObject?.get("app_cd")?.asString,
//            jsonObject?.get("auth_token")?.asString,
//            jsonObject?.get("dvc_id")?.asString,
//            jsonObject?.get("app_ver")?.asString,
//            jsonObject?.get("email")?.asString,
//            jsonObject?.get("usr_nick")?.asString,
//            jsonObject?.get("sns_id")?.asString,
//            jsonObject?.get("fcm_key")?.asString,
//            jsonObject?.get("sns_type")?.asString,
//            jsonObject?.get("agree1")?.asString,
//            jsonObject?.get("agree2")?.asString,
//            jsonObject?.get("push_yn")?.asString
//        )
//        call_response?.enqueue(object : Callback<JsonObject?> {
//            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
//                if (response.body() != null) {
//                    //                    Logger.loge("response.body()  :  " + response.body());
//                    onModelListener?.onFinished(response.body(), "")
//                }
//            }
//
//            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
//                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
//                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
//            }
//        })
//    }
//    override fun getw(onModelListener: onModelListener?, jsonObject: JsonObject?) {
//        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.getw(
//            jsonObject?.get("id")?.asString,
//            jsonObject?.get("appid")?.asString,
//        )
//        call_response?.enqueue(object : Callback<JsonObject?> {
//            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
//                if (response.body() != null) {
//                    //                    Logger.loge("response.body()  :  " + response.body());
//                    onModelListener?.onFinished(response.body(), "getw")
//                }
//            }
//
//            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
//                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
//                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
//            }
//        })
//    }
//
////    override fun my_info(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.my_info(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MY_INFO)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun check(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<String?>? = NetRetrofit().getService_check(context)?.check(
////        )
////        call_response?.enqueue(object : Callback<String?> {
////            override fun onResponse(call: Call<String?>, response: Response<String?>) {
////
//////                Logger.loge("response.isSuccessful   :   ${response.isSuccessful}")
////
////                if (response.isSuccessful) {
////                    if (response.body() != null) {
////                        val obj = JsonObject()
////                        obj.addProperty("response", response.body().toString())
////                        onModelListener!!.onFinished(obj, Const.CHECK)
////                    }
////                } else {
////                    val obj = JsonObject()
////                    obj.addProperty("response", "N")
////                    onModelListener!!.onFinished(obj, Const.CHECK)
////                }
////            }
////
////            override fun onFailure(call: Call<String?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                val obj = JsonObject()
////                obj.addProperty("response", "N")
////                onModelListener!!.onFinished(obj, Const.CHECK)
////            }
////        })
////    }
////    override fun pay(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.pay(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("orderId")?.asString,
////            jsonObject?.get("packageName")?.asString,
////            jsonObject?.get("productId")?.asString,
////            jsonObject?.get("purchaseTime")?.asString,
////            jsonObject?.get("purchaseState")?.asString,
////            jsonObject?.get("purchaseToken")?.asString,
////            jsonObject?.get("autoRenewing")?.asString,
////            jsonObject?.get("acknowledged")?.asString,
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.PAY)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun sku_id_list(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.sku_id_list(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.SKU_ID_LIST)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun my_leave(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.my_leave(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MY_LEAVE)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun my_push_set(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////
////        if (jsonObject?.get("push_yn")?.asString == "Y") {
////            FcmTopicMng.RegistTopic(FcmTopicMng.TOPIC_STANDARD_FCM_ALL)
////        } else {
////            FcmTopicMng.UnRegistTopic(FcmTopicMng.TOPIC_STANDARD_FCM_ALL)
////        }
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.my_push_set(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("push_yn")?.asString
////
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MY_PUSH_SET)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun terms(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.terms(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.TERMS)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun buisness(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.buisness(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.BUISNESS)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun cs_board_list(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.cs_board_list(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("flag")?.asString,
////            jsonObject?.get("p")?.asString
////
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.CS_BOARD_LIST)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////
////    override fun winning(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.winning(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("snum")?.asString,
////            jsonObject?.get("enum")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.WINNING)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun analyze(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.analyze(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("nums1")?.asString,
////            jsonObject?.get("nums2")?.asString,
////            jsonObject?.get("nums3")?.asString,
////            jsonObject?.get("nums4")?.asString,
////            jsonObject?.get("nums5")?.asString
////
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.ANALYZE)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun filter_list(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.filter_list(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("p")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.FILTER_LIST)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun filter_comb(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.filter_comb(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("sq")?.asString,
////            jsonObject?.get("gold_yn")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.FILTER_COMB)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun filter_del(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.filter_del(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("sq")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.FILTER_DEL)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun filter_load(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.filter_load(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("sq")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.FILTER_LOAD)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun faq(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.faq(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.FAQ)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun board_list(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.board_list(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.BOARD_LIST)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun board_view(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.board_view(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("sq")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.BOARD_VIEW)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun deposit_reg(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.deposit_reg(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("sku_id")?.asString,
////            jsonObject?.get("deposit_pay")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.DEPOSIT_REG)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun my_lotto_set_load(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.my_lotto_set_load(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MY_LOTTO_SET_LOAD)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun my_lotto_list(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.my_lotto_list(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("snum")?.asString,
////            jsonObject?.get("enum")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MY_LOTTO_LIST)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun my_lotto_set(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.my_lotto_set(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("set_time")?.asString,
////            jsonObject?.get("w1")?.asString,
////            jsonObject?.get("w2")?.asString,
////            jsonObject?.get("w3")?.asString,
////            jsonObject?.get("w4")?.asString,
////            jsonObject?.get("w5")?.asString,
////            jsonObject?.get("w6")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MY_LOTTO_SET)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun filter_gbn_load(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.filter_gbn_load(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("sq")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.FILTER_GBN_LOAD)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun lastest_data_view(onModelListener: onModelListener?, jsonObject: JsonObject?) {
//////        Logger.loge(jsonObject?.get("list_gbn") + "   ")
////
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.lastest_data_view(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("list_gbn")?.asString
//////            gson.fromJson(jsonObject?.get("list_gbn"),ArrayList())
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.LASTEST_DATA_VIEW)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun machine_learning(onModelListener: onModelListener?, jsonObject: JsonObject?) {
//////        Logger.loge(jsonObject?.get("list_gbn") + "   ")
////
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.machine_learning(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString
//////            gson.fromJson(jsonObject?.get("list_gbn"),ArrayList())
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MACHINE_LEARNING)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////    override fun my_lotto_del(onModelListener: onModelListener?, jsonObject: JsonObject?) {
//////        Logger.loge(jsonObject?.get("list_gbn") + "   ")
////
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.my_lotto_del(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("idx")?.asString
//////            gson.fromJson(jsonObject?.get("list_gbn"),ArrayList())
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.MY_LOTTO_DEL)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun filter_reg(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.filter_reg(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("filter_nm")?.asString,
////            jsonObject?.get("sum123456_yn")?.asString,
////            jsonObject?.get("sum123456")?.asString,
////            jsonObject?.get("sum123_yn")?.asString,
////            jsonObject?.get("sum123")?.asString,
////            jsonObject?.get("sum1234_yn")?.asString,
////            jsonObject?.get("sum1234")?.asString,
////            jsonObject?.get("sum246_yn")?.asString,
////            jsonObject?.get("sum246")?.asString,
////            jsonObject?.get("sum_yn")?.asString,
////            jsonObject?.get("sum_min")?.asString,
////            jsonObject?.get("sum_max")?.asString,
////            jsonObject?.get("exp_num")?.asString,
////            jsonObject?.get("flex_num")?.asString,
////            jsonObject?.get("even_odd_yn")?.asString,
////            jsonObject?.get("even")?.asString,
////            jsonObject?.get("odd")?.asString,
////            jsonObject?.get("low_high_yn")?.asString,
////            jsonObject?.get("low_cnt")?.asString,
////            jsonObject?.get("high_cnt")?.asString,
////            jsonObject?.get("div5_yn")?.asString,
////            jsonObject?.get("div5")?.asString,
////            jsonObject?.get("div9_yn")?.asString,
////            jsonObject?.get("div9")?.asString,
////            jsonObject?.get("div15_yn")?.asString,
////            jsonObject?.get("div15")?.asString,
////            jsonObject?.get("flow2_cnt_yn")?.asString,
////            jsonObject?.get("flow2_cnt")?.asString,
////            jsonObject?.get("flow3")?.asString,
////            jsonObject?.get("patten_dir")?.asString,
////            jsonObject?.get("patten_dir2")?.asString,
////            jsonObject?.get("rank1")?.asString,
////            jsonObject?.get("rank2")?.asString,
////            jsonObject?.get("vline_yn")?.asString,
////            jsonObject?.get("vline")?.asString,
////            jsonObject?.get("vline_str")?.asString,
////            jsonObject?.get("hline_yn")?.asString,
////            jsonObject?.get("hline")?.asString,
////            jsonObject?.get("hline_str")?.asString,
////            jsonObject?.get("normal_num")?.asString,
////            jsonObject?.get("last_num_str_yn")?.asString,
////            jsonObject?.get("last_num_str")?.asString,
////            jsonObject?.get("flex_cnt_yn")?.asString,
////            jsonObject?.get("flex_cnt_min")?.asString,
////            jsonObject?.get("flex_cnt_max")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.FILTER_REG)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////    override fun seller(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)?.seller(
////            jsonObject?.get("usr_key")?.asString,
////            jsonObject?.get("app_cd")?.asString,
////            jsonObject?.get("auth_token")?.asString,
////            jsonObject?.get("latitude")?.asString,
////            jsonObject?.get("longitude")?.asString
////        )
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
////                    //                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.SELLER)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
////
////
////    override fun cs_board_reg(onModelListener: onModelListener?, jsonObject: JsonObject?) {
////        var part: MultipartBody.Part? = null
////        if (jsonObject!!["img_file"].asString != "") {
////            val file = File(jsonObject["img_file"].asString)
////            var extension = file.name
////            extension = extension.substring(extension.lastIndexOf(".") + 1, extension.length)
//////            part = MultipartBody.Part.createFormData("img_file", file.name, RequestBody.Companion.create("image/$extension".toMediaTypeOrNull(), file))
////            part = MultipartBody.Part.createFormData(
////                "img_file", file.name,
////                file.asRequestBody("image/$extension".toMediaTypeOrNull())
////            )
////
////        }
////        val usr_key: MultipartBody.Part =
////            MultipartBody.Part.createFormData("usr_key", jsonObject["usr_key"].asString)
////        val app_cd: MultipartBody.Part =
////            MultipartBody.Part.createFormData("app_cd", jsonObject["app_cd"].asString)
////        val auth_token: MultipartBody.Part =
////            MultipartBody.Part.createFormData("auth_token", jsonObject["auth_token"].asString)
////        val contents: MultipartBody.Part =
////            MultipartBody.Part.createFormData("contents", jsonObject["contents"].asString)
////        val flag: MultipartBody.Part =
////            MultipartBody.Part.createFormData("flag", jsonObject["flag"].asString)
////
////        val call_response: Call<JsonObject?>? = NetRetrofit().getService(context)
////            ?.cs_board_reg(usr_key, app_cd, auth_token, contents, flag, part)
////        call_response?.enqueue(object : Callback<JsonObject?> {
////            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
////                if (response.body() != null) {
//////                    Logger.loge("response.body()  :  " + response.body());
////                    onModelListener?.onFinished(response.body(), Const.CS_BOARD_REG)
////                }
////            }
////
////            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
////                App().disProgress()
////                Logger.loge("t.getLocalizedMessage()   :  " + t.localizedMessage)
////                Logger.loge("t.toString()   :  $t")
////                Logger.loge("t.getMessage()   :  " + t.message)
////                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
////            }
////        })
////    }
//
//
//}