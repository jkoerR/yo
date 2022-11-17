//package com.everything.wonpick.util
//
//import android.app.Activity
//import android.content.Context
//import android.util.Log
//import androidx.fragment.app.FragmentActivity
//import com.android.billingclient.api.*
//import java.util.*
//
//
//class BillingEntireManager_kt : PurchasesUpdatedListener {
//
//    lateinit var mBillingClient: BillingClient
//
//    // 아이템 상세정보 리스트
//    private var mSkuDetailsList_item: List<SkuDetails>? = null
//
//    // 아이템 소비 리스너
//    lateinit var mConsumeListener: ConsumeResponseListener
//    lateinit var ctx: Context
//    private val TAG = "빌링"
//
//    fun _init(ctx: Context?) {
//        this.ctx = ctx!!
//        Log.e(TAG, "구글 결제 매니저를 초기화 하고 있습니다.")
//        mBillingClient =
//            BillingClient.newBuilder(ctx!!).setListener(this).enablePendingPurchases().build()
//        mBillingClient.startConnection(object : BillingClientStateListener {
//            override fun onBillingSetupFinished(billingResult: BillingResult) {
//                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
//                    Log.e(TAG, "구글 결제 서버에 접속을 성공하였습니다.")
//                    getSkuDetailList()
//
//                    // 아이템 결제 히스토리 가져옴
//                    val result_item = mBillingClient.queryPurchases(BillingClient.SkuType.INAPP)
//
//                    // 소모가 안된 상품 존재시 - 리스트에 아이템이 존재하게 된다
//                    val list_item = result_item.purchasesList
//                    for (i in list_item!!.indices) {
//                        val purchase = list_item[i]
//                        // 계속 보류중일때
//                        if (purchase.purchaseState != Purchase.PurchaseState.PURCHASED) {
//                            // 카드사 승인중인 결제 또는 결제 보류중
//                        } else {
//                            // 결제 승인된 경우
//                            handlePurchase(list_item[i])
//                        }
//                    }
//                } else {
//                    Log.e(
//                        TAG, """
//     구글 결제 서버 접속에 실패하였습니다.
//     오류코드: ${billingResult.responseCode}
//     """.trimIndent()
//                    )
//                    // case 구글 플레이스토어 계정 정보 인식 안될 때
//                }
//            }
//
//            override fun onBillingServiceDisconnected() {
//                Log.e(TAG, "구글 결제 서버와 접속이 끊어졌습니다.")
//            }
//        })
//        // 상품 소모결과 리스너
//        mConsumeListener =
//            ConsumeResponseListener { billingResult, purchaseToken ->
//                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
//                    Log.e(TAG, "상품을 성공적으로 소모하였습니다. 소모된 상품 => $purchaseToken")
//                    return@ConsumeResponseListener
//                } else {
//                    Log.e(
//                        TAG,
//                        "상품 소모에 실패하였습니다. 오류코드 (" + billingResult.responseCode + "), 대상 상품 코드: " + purchaseToken
//                    )
//                    return@ConsumeResponseListener
//                }
//            }
//    }
//
//
//    // 구입 가능한 상품의 리스트를 받아 오는 메소드
//    private fun getSkuDetailList() {
//        // 구글 상품 정보들의 ID를 만들어 줌
//        val Sku_ID_List_INAPP: MutableList<String> = ArrayList()
//        Sku_ID_List_INAPP.add("test1")
//        //        Sku_ID_List_INAPP.add(POINT_02_CODE);
////        Sku_ID_List_INAPP.add(POINT_03_CODE);
////        Sku_ID_List_INAPP.add(POINT_04_CODE);
////        Sku_ID_List_INAPP.add(POINT_05_CODE);
////        Sku_ID_List_INAPP.add(POINT_06_CODE);
//
//        // SkuDetailsList 객체를 만듬
//        val params_item = SkuDetailsParams.newBuilder()
//        params_item.setSkusList(Sku_ID_List_INAPP).setType(BillingClient.SkuType.INAPP)
//
//        // 비동기 상태로 앱의 정보를 가지고 옴
//        mBillingClient.querySkuDetailsAsync(params_item.build(),
//            SkuDetailsResponseListener { billingResult, skuDetailsList -> // 상품 정보를 가지고 오지 못한 경우
//                if (billingResult.responseCode != BillingClient.BillingResponseCode.OK) {
//                    Log.e(
//                        TAG, """
//     (인앱) 상품 정보를 가지고 오던 중 오류가 발생했습니다.
//     오류코드: ${billingResult.responseCode}
//     """.trimIndent()
//                    )
//                    return@SkuDetailsResponseListener
//                }
//                if (skuDetailsList == null) {
//                    Log.e(TAG, "(인앱) 상품 정보가 존재하지 않습니다.")
//                    return@SkuDetailsResponseListener
//                }
//                //응답 받은 데이터들의 숫자를 출력
//                Log.e(TAG, "(인앱) 응답 받은 데이터 숫자: " + skuDetailsList.size)
//
//                //받아온 상품 정보를 차례로 호출
//                for (sku_idx in skuDetailsList.indices) {
//                    //해당 인덱스의 객체를 가지고 옴
//                    val _skuDetail = skuDetailsList[sku_idx]
//                    //해당 인덱스의 상품 정보를 출력
//                    Log.e(TAG, _skuDetail.sku + ": " + _skuDetail.title + ", " + _skuDetail.price)
//                    Log.e(TAG, _skuDetail.originalJson)
//                }
//
//                //받은 값을 멤버 변수로 저장
//                mSkuDetailsList_item = skuDetailsList
//            })
//    }
//
//    // 결제 요청 후 상품에대해 소비시켜주는 함수
//    fun handlePurchase(purchase: Purchase) {
//        if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
//
//            // 인앱 소비
//            // TODO 인앱 구매 결과전송 함수 호출
//            val consumeParams = ConsumeParams.newBuilder()
//                .setPurchaseToken(purchase.purchaseToken)
//                .build()
//            mBillingClient.consumeAsync(consumeParams, mConsumeListener)
//        } else if (purchase.purchaseState == Purchase.PurchaseState.PENDING) {
//            // Here you can confirm to the user that they've started the pending
//            // purchase, and to complete it, they should follow instructions that
//            // are given to them. You can also choose to remind the user in the
//            // future to complete the purchase if you detect that it is still
//            // pending.
//            // ex 해당 아이템에 대해 소모되지 않은 결제가 있을시
//        }
//    }
//
//    //실제 구입 처리를 하는 메소드
//    fun purchase(item: String, act: Activity?) {
//        var skuDetails: SkuDetails? = null
//        if (null != mSkuDetailsList_item) {
//            for (i in mSkuDetailsList_item!!.indices) {
//                val details = mSkuDetailsList_item!![i]
//                if (details.sku == item) {
//                    skuDetails = details
//                    break
//                }
//            }
//            val flowParams = BillingFlowParams.newBuilder()
//                .setSkuDetails(skuDetails!!)
//                .build()
//            mBillingClient.launchBillingFlow(act!!, flowParams)
//        }
//    }
//
//    override fun onPurchasesUpdated(billingResult: BillingResult, purchases: MutableList<Purchase>?) {
//        //결제에 성공한 경우
//        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && purchases != null) {
//            Log.e(TAG, "결제에 성공했으며, 아래에 구매한 상품들이 나열됨")
//            for (_pur in purchases) {
//                Log.e(TAG, "purchases: $purchases")
//                handlePurchase(_pur)
//            }
//        } else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
//            Log.e(TAG, "사용자에 의해 결제취소")
//        } else {
//            Log.e(TAG, "결제가 취소 되었습니다. 종료코드: " + billingResult.getResponseCode())
//            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
//                // ex 해당 아이템에 대해 소모되지 않은 결제가 있을시
//            }
//        }
//    }
//
//
//}