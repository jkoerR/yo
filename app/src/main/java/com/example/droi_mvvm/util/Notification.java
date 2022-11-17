//package com.example.droi_mvvm.util;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.Build;
//
//import androidx.core.app.NotificationCompat;
//
////import com.everything.inlot.Const;
////import com.everything.inlot.R;
////import com.everything.inlot.fcm.PushActivity;
//import com.google.gson.JsonObject;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
////package com.dreamsolutech.jk_kotlin.util;
////import android.app.NotificationChannel;
////import android.app.NotificationManager;
////import android.app.PendingIntent;
////import android.content.Context;
////import android.content.Intent;
////import android.graphics.Color;
////import android.media.RingtoneManager;
////import android.os.Build;
////
////import androidx.core.app.NotificationCompat;
////
////import com.dreamsolutech.jk_kotlin.Const;
////import com.google.gson.JsonObject;
////
////import java.text.SimpleDateFormat;
////import java.util.Date;
////
////
//public class Notification {
//    public static void setNoti(Context ctxt, JsonObject jsonObject, int pid) {
//        Context mContext = ctxt;
////        Gson gson = new Gson();
////        JsonParser jsonParser = new JsonParser();
////
////        JsonObject jsonObject = (JsonObject) jsonParser.parse(message);
////        Logger.loge(jsonObject+ " : ");
//
//        Intent intent;
//        NotificationCompat.Builder builder;
//        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            String channelId = Const.NOTICHANNEL_ID;
//            String channelName = Const.NOTICHANNEL_NAME;
//            NotificationChannel channel = new NotificationChannel(channelId, channelName,
//                    NotificationManager.IMPORTANCE_LOW);
////            channel.setDescription(channelDescription);
//            //각종 채널에 대한 설정
//            channel.enableLights(true);
//            channel.setLightColor(Color.RED);
//            channel.enableVibration(true);
//            channel.setVibrationPattern(new long[]{100, 200, 300});
//            notificationManager.createNotificationChannel(channel);
//            builder = new NotificationCompat.Builder(mContext, channelId);
//        } else {
//            builder = new NotificationCompat.Builder(mContext);
//        }
//
////        int badgecount = 0;
////        if (Util.getCacheDataForKey(Const.BADGECOUNT) != null) {
////            String ao = String.valueOf(Util.getCacheDataForKey(Const.BADGECOUNT));
////            badgecount = Integer.parseInt(ao) + 1;
////        } else {
////            badgecount = badgecount + 1;
////        }
//
//        try {
//            intent = new Intent(mContext, PushActivity.class);
////            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//            String jo = jsonObject + "";
//            intent.putExtra("jo", jo);
//            builder.setSmallIcon(R.drawable.lotmo);  // 알림 왔을때 상단 작은 아이콘
//////            builder.setBadgeIconType(R.drawable.icon_c1); // 알림이 뜰때 잠깐 표시되는 Text  커스텀뷰일떈 필요없음
//            builder.setContentTitle(mContext.getString(R.string.app_name)); // 제목  커스텀뷰일떈 필요없음
//            builder.setContentText(jsonObject.get("title").getAsString()); // 내용  커스텀뷰일떈 필요없음
////
////            //커스텀 화면 만들기
////            RemoteViews remoteViews = new RemoteViews(ctxt.getPackageName(), R.layout.custom_notification);
////
//////            remoteViews.setImageViewResource(R.id.img, R.drawable.grand); //flag 에 따라 아이콘 나누자
////            switch (jsonObject.get("mb_level_cd").getAsString()) {
////                case "2":
//////                    iv_mypage.setVisibility(View.GONE);
//////                    builder.setSmallIcon(0);
////                    remoteViews.setImageViewResource(R.id.img, 0);
////                    break;
////                case "13":
////                    remoteViews.setImageViewResource(R.id.img, R.drawable.icon_c1);
////                    break;
////                case "14":
////                    remoteViews.setImageViewResource(R.id.img, R.drawable.icon_c2);
////                    break;
////                case "15":
////                    remoteViews.setImageViewResource(R.id.img, R.drawable.icon_c3);
////                    break;
////                case "16":
////                    remoteViews.setImageViewResource(R.id.img, R.drawable.icon_c4);
////                    break;
////            }
//
////            aa : am/pm
////            AA : AM/PM
////            yyyy.MM.dd kk:mm:ss -> 2013.05.07 15:23:45
////            yyyy.MM.dd hh:mm:ss  aa -> 2013.05.07 03:23:45 pm
//
//            long now = System.currentTimeMillis();
//            Date date = new Date(now);
//            SimpleDateFormat sdf = new SimpleDateFormat("aa hh:mm ");
//            String getTime = sdf.format(date);
//
////            remoteViews.setTextViewText(R.id.title, jsonObject.get("title").getAsString());
////            remoteViews.setTextViewText(R.id.date,getTime);
////
////            //노티피케이션에 커스텀 뷰 장착
////            builder.setContent(remoteViews);
//
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////                if (Util.cNull(Util.getCacheDataForKey(Const.ALARM_POP_USE.toString())).equals("Y") && Util.cNull(Util.getCacheDataForKey(Const.PUSH_YN)).equals("Y")) {
////                    builder.setCategory(android.app.Notification.CATEGORY_MESSAGE);
////                    builder.setPriority(android.app.Notification.PRIORITY_HIGH);
//////                    builder.setVisibility(android.app.Notification.VISIBILITY_PUBLIC);
////                }
////            }
////            // 알림시 사운드, 진동, 불빛을 설정 가능.
////            if (Util.cNull(Util.getCacheDataForKey(Const.ALARM_SOUND_USE)).equals("Y")) {
////                builder.setDefaults(android.app.Notification.DEFAULT_SOUND);
////                builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
////            }
////            if (Util.cNull(Util.getCacheDataForKey(Const.ALARM_VIB_USE)).equals("Y")) {
//////                builder.setDefaults(android.app.Notification.DEFAULT_VIBRATE);
////            }
////
////            Logger.loge("Util.cNull(Util.getCacheDataForKey(Const.PUSH_YN))   :  "   +  Util.cNull(Util.getCacheDataForKey(Const.PUSH_YN)));
//            if (Util.cNull(Util.getCacheDataForKey(Const.PUSH_YN)).equals("Y")) {
//                PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setAutoCancel(true); // 터치하면 자동으로 지워지도록 설정
//                builder.setOngoing(false);  //안지워지는?
//                builder.setContentIntent(pendingIntent); // 실행할 작업이 담긴 PendingIntent
//
////                notificationManager.notify(Const.NOTIBASEID, builder.build()); //노티 띄우기
//                if (pid != 0)now = pid;
//                notificationManager.notify((int) now, builder.build()); //노티 띄우기
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
////    /**
////     * XML로 직접만든 화면으로 보여주는 노티피케이션
////     */
////    private void showCustomLayoutNotification(Context ctxt, String message) {
////        NotificationCompat.Builder mBuilder = createNotification(ctxt);
////
////        //커스텀 화면 만들기
////        RemoteViews remoteViews = new RemoteViews(ctxt.getPackageName(), R.layout.custom_notification);
////        remoteViews.setImageViewResource(R.id.img, R.mipmap.ic_launcher);
////        remoteViews.setTextViewText(R.id.title, "Title");
////        remoteViews.setTextViewText(R.id.message, "message");
////
////        //노티피케이션에 커스텀 뷰 장착
////        mBuilder.setContent(remoteViews);
////        mBuilder.setContentIntent(createPendingIntent(ctxt));
////
////        NotificationManager mNotificationManager = (NotificationManager) ctxt.getSystemService(Context.NOTIFICATION_SERVICE);
////        mNotificationManager.notify(1, mBuilder.build());
////    }
//
//    /**
//     * 노티피케이션을 누르면 실행되는 기능을 가져오는 노티피케이션
//     * <p>
//     * 실제 기능을 추가하는 것
//     *
//     * @return
//     */
////    private PendingIntent createPendingIntent(Context context) {
////        Intent resultIntent = new Intent(context, PushActivity.class);
////        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
////        stackBuilder.addParentStack(PushActivity.class);
////        stackBuilder.addNextIntent(resultIntent);
////
////        return stackBuilder.getPendingIntent(
////                0,
////                PendingIntent.FLAG_UPDATE_CURRENT
////        );
////    }
//
//
////    /**
////     * 노티피케이션 빌드
////     * @return
////     * @param ctxt
////     */
////    private NotificationCompat.Builder createNotification(Context ctxt){
////        Bitmap icon = BitmapFactory.decodeResource(ctxt.getResources(), R.mipmap.ic_launcher);
////        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctxt)
////                .setSmallIcon(R.mipmap.ic_launcher)
////                .setLargeIcon(icon)
////                .setContentTitle("StatusBar Title")
////                .setContentText("StatusBar subTitle")
////                .setSmallIcon(R.mipmap.ic_launcher/*스와이프 전 아이콘*/)
////                .setAutoCancel(true)
////                .setWhen(System.currentTimeMillis())
////                .setDefaults(Notification.DEFAULT_ALL);
////        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
////            builder.setCategory(Notification.CATEGORY_MESSAGE)
////                    .setPriority(Notification.PRIORITY_HIGH)
////                    .setVisibility(Notification.VISIBILITY_PUBLIC);
////        }
////        return builder;
////    }
//}