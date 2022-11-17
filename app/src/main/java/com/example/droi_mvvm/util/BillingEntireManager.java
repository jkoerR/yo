//package com.example.droi_mvvm.util;
//
//import android.app.Activity;
//import android.content.Context;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.android.billingclient.api.AcknowledgePurchaseParams;
//import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
//import com.android.billingclient.api.BillingClient;
//import com.android.billingclient.api.BillingClientStateListener;
//import com.android.billingclient.api.BillingFlowParams;
//import com.android.billingclient.api.BillingResult;
//import com.android.billingclient.api.ConsumeParams;
//import com.android.billingclient.api.ConsumeResponseListener;
//import com.android.billingclient.api.Purchase;
//import com.android.billingclient.api.PurchasesUpdatedListener;
//import com.android.billingclient.api.SkuDetails;
//import com.android.billingclient.api.SkuDetailsParams;
//import com.android.billingclient.api.SkuDetailsResponseListener;
//import com.everything.inlot.view.mypage.Call_back_sku;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BillingEntireManager implements PurchasesUpdatedListener {
//
//    private BillingClient mBillingClient;
//    AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener;
//    // 아이템 상세정보 리스트
//    private ArrayList<SkuDetails> mSkuDetailsList_item = new ArrayList<>();
//
//    // 아이템 소비 리스너
//    private ConsumeResponseListener mConsumeListener;
//    private Context ctx;
//    private String TAG = "빌링";
//    private Call_back_sku.View mCall_back_sku;
//    private ArrayList<String> Sku_ID_List_INAPP;
//    private List<Purchase> mPurchases_one = new ArrayList<>();
//    private List<Purchase> mPurchases_sub = new ArrayList<>();
//    private String type = "";
//
//    public void endConnection(){
//        mBillingClient.endConnection();
//    }
//
//    public BillingEntireManager(Context ctx, ArrayList<String> Sku_ID_List_INAPP, Call_back_sku.View call_back_sku) {
//        this.ctx = ctx;
//        this.mCall_back_sku = call_back_sku;
//        this.Sku_ID_List_INAPP = Sku_ID_List_INAPP;
////        Logger.loge("구글 결제 매니저를 초기화 하고 있습니다.");
//
//        acknowledgePurchaseResponseListener = new AcknowledgePurchaseResponseListener() {
//            @Override
//            public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
//                Logger.loge("onAcknowledgePurchaseResponse   :  " + billingResult.getResponseCode());
//                Logger.loge("onAcknowledgePurchaseResponse   :  " + billingResult.getDebugMessage());
////                dmapoefganfbdmnfinghoabf.AO-J1Ox0cAPi4RunQO8Eh4f2csVPOeYUIr0-rhls8S9XZgzoGc59dSO5PO9D1IGBu8uDkvQmeuJylz7RqREHtu5_MBghNmlTMw
////                ecbofcpicbaepjbmmioodpll.AO-J1Ow1ZDmiKJdWy4ynCfnTlncu3qSsb7yh7XwYUvzZGDrOJt9jYO6LxiDDIXNHphsrwG5ozFrg_dQU6DQSjjO9Hak5YZcoFw
//                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
//                    if (mPurchases_sub != null && mPurchases_sub.size() > 0) {
//                        call_back_sku.sku_callback(mPurchases_sub);
//                    }
//                }
//            }
//        };
//
//        mBillingClient = BillingClient.newBuilder(ctx).setListener(this).enablePendingPurchases().build();
//        mBillingClient.startConnection(billingClientStateListener);
//        // 상품 소모결과 리스너
//        mConsumeListener = new ConsumeResponseListener() {
//            @Override
//            public void onConsumeResponse(BillingResult billingResult, String purchaseToken) {
//                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
//                    if (mPurchases_one != null && mPurchases_one.size() > 0) {
//                        call_back_sku.sku_callback(mPurchases_one);
//                    }
//                    Logger.loge("상품을 성공적으로 소모하였습니다. 소모된 상품 => " + purchaseToken);
//                    return;
//                } else {
//                    Logger.loge("상품 소모에 실패하였습니다. 오류코드 (" + billingResult.getResponseCode() + "), 대상 상품 코드: " + purchaseToken);
////                    mBillingClient.startConnection(billingClientStateListener);
//                    return;
//                }
//            }
//        };
//    }
//
//    BillingClientStateListener billingClientStateListener = new BillingClientStateListener() {
//        @Override
//        public void onBillingSetupFinished(BillingResult billingResult) {
//            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
////                    Logger.loge( "구글 결제 서버에 접속을 성공하였습니다.");
////                    Logger.loge("Sku_ID_List_INAPP  :  "   +  Sku_ID_List_INAPP);
//                getSkuDetailList(Sku_ID_List_INAPP);
//                getSkuDetailList_sub(Sku_ID_List_INAPP);
//                // 아이템 결제 히스토리 가져옴
//                Purchase.PurchasesResult result_item = mBillingClient.queryPurchases(BillingClient.SkuType.INAPP);
//                Purchase.PurchasesResult result_item_sub = mBillingClient.queryPurchases(BillingClient.SkuType.SUBS);
//
//                // 소모가 안된 상품 존재시 - 리스트에 아이템이 존재하게 된다
//                Logger.loge("result_item.getPurchasesList()   :  " + result_item.getPurchasesList());
//                Logger.loge("result_item_sub.getPurchasesList()   :  " + result_item_sub.getPurchasesList());
////                mCall_back_sku.sku_callback(result_item_sub.getPurchasesList());
//                List<Purchase> list_item = result_item.getPurchasesList();
//                mPurchases_one.clear();
//                for (int i = 0; i < list_item.size(); i++) {
//                    Purchase purchase = list_item.get(i);
//                    // 계속 보류중일때
//                    if (purchase.getPurchaseState() != Purchase.PurchaseState.PURCHASED) {
//                        // 카드사 승인중인 결제 또는 결제 보류중
//                    } else {
//                        // 결제 승인된 경우
//                        mPurchases_one.add(purchase);
//                        handlePurchase(purchase);
//                    }
//                }
//                List<Purchase> list_item_sub = result_item_sub.getPurchasesList();
//                mPurchases_sub.clear();
//                for (int i = 0; i < list_item_sub.size(); i++) {
//                    Purchase purchase = list_item_sub.get(i);
//                    // 계속 보류중일때
//                    if (purchase.getPurchaseState() != Purchase.PurchaseState.PURCHASED) {
//                        // 카드사 승인중인 결제 또는 결제 보류중
//                    } else {
//                        // 결제 승인된 경우
//                        mPurchases_sub.add(purchase);
//                        handlePurchase_subs(purchase);
//                    }
//                }
//            } else {
//                Logger.loge("구글 결제 서버 접속에 실패하였습니다.\n오류코드: " + billingResult.getResponseCode());
//                // case 구글 플레이스토어 계정 정보 인식 안될 때
//            }
//        }
//
//        @Override
//        public void onBillingServiceDisconnected() {
//            Logger.loge("구글 결제 서버와 접속이 끊어졌습니다.");
//        }
//    };
//
//    private void getSkuDetailList_sub(ArrayList<String> Sku_ID_List_INAPP) {
//        // 구글 상품 정보들의 ID를 만들어 줌
////        List<String> Sku_ID_List_INAPP = new ArrayList<>();
////        Sku_ID_List_INAPP.add("test1");
////        Sku_ID_List_INAPP.add(POINT_02_CODE);
////        Sku_ID_List_INAPP.add(POINT_03_CODE);
////        Sku_ID_List_INAPP.add(POINT_04_CODE);
////        Sku_ID_List_INAPP.add(POINT_05_CODE);
////        Sku_ID_List_INAPP.add(POINT_06_CODE);
//
//        // SkuDetailsList 객체를 만듬
//        SkuDetailsParams.Builder params_item = SkuDetailsParams.newBuilder();
//        params_item.setSkusList(Sku_ID_List_INAPP).setType(BillingClient.SkuType.SUBS);
//        // 비동기 상태로 앱의 정보를 가지고 옴
//        mBillingClient.querySkuDetailsAsync(params_item.build(), new SkuDetailsResponseListener() {
//            @Override
//            public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> skuDetailsList) {
//                // 상품 정보를 가지고 오지 못한 경우
//                if (billingResult.getResponseCode() != BillingClient.BillingResponseCode.OK) {
//                    Logger.loge("(구독) 상품 정보를 가지고 오던 중 오류가 발생했습니다.\n오류코드: " + billingResult.getResponseCode());
//                    return;
//                }
//                if (skuDetailsList == null) {
//                    Logger.loge("(구독) 상품 정보가 존재하지 않습니다.");
//                    return;
//                }
//                //응답 받은 데이터들의 숫자를 출력
////                Logger.loge( "(구독) 응답 받은 데이터 숫자: " + skuDetailsList.size());
//
//                //받아온 상품 정보를 차례로 호출
//                for (int sku_idx = 0; sku_idx < skuDetailsList.size(); sku_idx++) {
//                    //해당 인덱스의 객체를 가지고 옴
//                    SkuDetails _skuDetail = skuDetailsList.get(sku_idx);
//                    //해당 인덱스의 상품 정보를 출력
////                    Logger.loge( _skuDetail.getSku() + ": " + _skuDetail.getTitle() + ", " + _skuDetail.getPrice());
////                    Logger.loge( _skuDetail.getOriginalJson()   + "  :  " );
//                }
//                //받은 값을 멤버 변수로 저장
//                mSkuDetailsList_item.addAll(skuDetailsList);
//            }
//        });
//    }
//
//    // 구입 가능한 상품의 리스트를 받아 오는 메소드
//    private void getSkuDetailList(ArrayList<String> Sku_ID_List_INAPP) {
//        // 구글 상품 정보들의 ID를 만들어 줌
////        List<String> Sku_ID_List_INAPP = new ArrayList<>();
////        Sku_ID_List_INAPP.add("test1");
////        Sku_ID_List_INAPP.add(POINT_02_CODE);
////        Sku_ID_List_INAPP.add(POINT_03_CODE);
////        Sku_ID_List_INAPP.add(POINT_04_CODE);
////        Sku_ID_List_INAPP.add(POINT_05_CODE);
////        Sku_ID_List_INAPP.add(POINT_06_CODE);
//
//        // SkuDetailsList 객체를 만듬
//        SkuDetailsParams.Builder params_item = SkuDetailsParams.newBuilder();
//        params_item.setSkusList(Sku_ID_List_INAPP).setType(BillingClient.SkuType.INAPP);
//        // 비동기 상태로 앱의 정보를 가지고 옴
//        mBillingClient.querySkuDetailsAsync(params_item.build(), new SkuDetailsResponseListener() {
//            @Override
//            public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> skuDetailsList) {
//                // 상품 정보를 가지고 오지 못한 경우
//                if (billingResult.getResponseCode() != BillingClient.BillingResponseCode.OK) {
//                    Logger.loge("(인앱) 상품 정보를 가지고 오던 중 오류가 발생했습니다.\n오류코드: " + billingResult.getResponseCode());
//                    return;
//                }
//                if (skuDetailsList == null) {
//                    Logger.loge("(인앱) 상품 정보가 존재하지 않습니다.");
//                    return;
//                }
//                //응답 받은 데이터들의 숫자를 출력
////                Logger.loge( "(인앱) 응답 받은 데이터 숫자: " + skuDetailsList.size());
//
//                //받아온 상품 정보를 차례로 호출
//                for (int sku_idx = 0; sku_idx < skuDetailsList.size(); sku_idx++) {
//                    //해당 인덱스의 객체를 가지고 옴
//                    SkuDetails _skuDetail = skuDetailsList.get(sku_idx);
//                    //해당 인덱스의 상품 정보를 출력
////                    Logger.loge( _skuDetail.getSku() + ": " + _skuDetail.getTitle() + ", " + _skuDetail.getPrice());
////                    Logger.loge( _skuDetail.getOriginalJson()   + "  :  " );
//                }
//
//                //받은 값을 멤버 변수로 저장
////                mSkuDetailsList_item = skuDetailsList;
//                mSkuDetailsList_item.addAll(skuDetailsList);
//            }
//        });
//    }
//
//    //실제 구입 처리를 하는 메소드
//    public void purchase(String item, Activity act,String type) {
//        this.type = type;
//        Logger.loge("purchase   " + item);
//        SkuDetails skuDetails = null;
//        if (null != mSkuDetailsList_item) {
//            for (int i = 0; i < mSkuDetailsList_item.size(); i++) {
//                SkuDetails details = mSkuDetailsList_item.get(i);
//                if (details.getSku().equals(item)) {
//                    skuDetails = details;
//                    break;
//                }
//            }
//            if (skuDetails != null) {
//                BillingFlowParams flowParams = BillingFlowParams.newBuilder()
//                        .setSkuDetails(skuDetails)
//                        .build();
//                mBillingClient.launchBillingFlow(act, flowParams);
//            }
//        }
//    }
//
//
//    void handlePurchase_subs(Purchase purchase) {
//        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
//            if (!purchase.isAcknowledged()) {
//                AcknowledgePurchaseParams acknowledgePurchaseParams =
//                        AcknowledgePurchaseParams.newBuilder()
//                                .setPurchaseToken(purchase.getPurchaseToken())
//                                .build();
//                mBillingClient.acknowledgePurchase(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
//            }
//        }
//    }
//
//
//    // 결제 요청 후 상품에대해 소비시켜주는 함수
//    void handlePurchase(Purchase purchase) {
//        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
//
//            // 인앱 소비
//            // TODO 인앱 구매 결과전송 함수 호출
//            ConsumeParams consumeParams =
//                    ConsumeParams.newBuilder()
//                            .setPurchaseToken(purchase.getPurchaseToken())
//                            .build();
//            mBillingClient.consumeAsync(consumeParams, mConsumeListener);
//
//        } else if (purchase.getPurchaseState() == Purchase.PurchaseState.PENDING) {
//            // Here you can confirm to the user that they've started the pending
//            // purchase, and to complete it, they should follow instructions that
//            // are given to them. You can also choose to remind the user in the
//            // future to complete the purchase if you detect that it is still
//            // pending.
//            // ex 해당 아이템에 대해 소모되지 않은 결제가 있을시
//        }
//    }
//
//    @Override
//    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> purchases) {
//        //결제에 성공한 경우
//        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && purchases != null) {
//            Logger.loge("결제에 성공했으며, 아래에 구매한 상품들이 나열됨");
//            mPurchases_sub.clear();
//            mPurchases_one.clear();
//            for (Purchase _pur : purchases) {
////                Logger.loge("_pur: " + _pur);
//                if (type.equals("sub")){
//                    mPurchases_sub.add(_pur);
//                    handlePurchase_subs(_pur);
//                }else if (type.equals("once")){
//                    mPurchases_one.add(_pur);
//                    handlePurchase(_pur);
//                }
//            }
//        }
//        // 사용자가 결제를 취소한 경우
//        else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
//            Logger.loge("사용자에 의해 결제취소");
//        }
//        // 그 외에 다른 결제 실패 이유
//        else {
//            Logger.loge("결제가 취소 되었습니다. 종료코드: " + billingResult.getResponseCode());
//            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
//                // ex 해당 아이템에 대해 소모되지 않은 결제가 있을시
//            }
//        }
//    }
//}
//
//
//        /*
//        (1) SUBSCRIPTION_RECOVERED - 정기 결제가 계정 보류에서 복구되었습니다.
//        (2) SUBSCRIPTION_RENEWED - 활성 정기 결제가 갱신되었습니다.
//        -(3) SUBSCRIPTION_CANCELED - 정기 결제가 자발적으로 또는 비자발적으로 취소되었습니다. 자발적 취소의 경우 사용자가 취소할 때 전송됩니다.
//        (4) SUBSCRIPTION_PURCHASED - 새로운 정기 결제가 구매되었습니다.
//        -(5) SUBSCRIPTION_ON_HOLD - 정기 결제가 계정 보류 상태가 되었습니다(사용 설정된 경우).
//        -(6) SUBSCRIPTION_IN_GRACE_PERIOD - 정기 결제가 유예 기간 상태로 전환되었습니다(사용 설정된 경우).
//        (7) SUBSCRIPTION_RESTARTED - 사용자가 Play > 계정 > 정기 결제에서 정기 결제를 다시 활성화했습니다(정기 결제 복원을 선택해야 함).
//        -(8) SUBSCRIPTION_PRICE_CHANGE_CONFIRMED - 사용자가 정기 결제 가격 변경을 확인했습니다.
//        -(9) SUBSCRIPTION_DEFERRED: 구독 갱신 기한이 연장되었습니다.
//        -(10) SUBSCRIPTION_PAUSED - 구독이 일시중지되었습니다.
//        -(11) SUBSCRIPTION_PAUSE_SCHEDULE_CHANGED - 정기 결제 일시중지 일정이 변경되었습니다.
//        -(12) SUBSCRIPTION_REVOKED - 정기 결제가 만료 시간 전에 사용자에 의해 취소되었습니다.
//        -(13) SUBSCRIPTION_EXPIRED - 정기 결제가 만료되었습니다.
//        */