package com.example.droi_mvvm.util;//package com.dreamsolutech.jk_kotlin.util;
//
//import android.app.usage.UsageEvents;
//import android.app.usage.UsageStatsManager;
//import android.content.Context;
//import android.content.pm.PackageInfo;
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.util.LongSparseArray;
//
//import androidx.annotation.NonNull;
//
//import com.dreamsolutech.openingbox.Const;
//
//public class UseGetStat {
//    public static String getTopPackageName(@NonNull Context context) {
//        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
//
//        long lastRunAppTimeStamp = 0L;
//
//        String inter = (String) Util.getCacheDataForKey(Const.INTERVAL);
//        if (inter ==null || inter.equals(""))inter = "95";
//        long interValue = Long.parseLong(inter);
//
//        final long INTERVAL = 1000 * 60 * interValue;
//        // 1 minute ago
//        final long end = System.currentTimeMillis();
//        final long begin = end - INTERVAL;
////        final long begin = end - 10000;
//
//
////        2020-05-29 13:56:08.170 7085-7790/com.dreamsolutech.openingbox E/Jk[Thread-17]: pkname  :  com.google.android.youtube   usegetstat  :     com.google.android.youtube   useTime  :  288000
////        at com.dreamsolutech.openingbox.UseStatService.getUse written in UseStatService.java[163 Line]
////        2020-05-29 13:56:09.213 7085-7790/com.dreamsolutech.openingbox E/Jk[Thread-17]: screenOn:   true      user_present   :  true
////        at com.dreamsolutech.openingbox.UseStatService.getUse written in UseStatService.java[162 Line]
////        2020-05-29 13:56:09.214 7085-7790/com.dreamsolutech.openingbox E/Jk[Thread-17]: pkname  :  com.google.android.youtube   usegetstat  :        useTime  :  289000
////        at com.dreamsolutech.openingbox.UseStatService.getUse written in UseStatService.java[163 Line]
//
//
//        LongSparseArray packageNameMap = new LongSparseArray<>();
//        UsageEvents usageEvents = usageStatsManager.queryEvents(begin, end);
//        while (usageEvents.hasNextEvent()) {
//            UsageEvents.Event event = new UsageEvents.Event();
//            usageEvents.getNextEvent(event);
//            if (isForeGroundEvent(event)) {
//                packageNameMap.put(event.getTimeStamp(), event.getPackageName());
//                if (event.getTimeStamp() > lastRunAppTimeStamp) {
//                    lastRunAppTimeStamp = event.getTimeStamp();
//                }
//            }
//        }
////        return packageNameMap.get(lastRunAppTimeStamp, "");
//        return packageNameMap.get(lastRunAppTimeStamp, "") + "";
//    }
//
//    private static boolean isForeGroundEvent(UsageEvents.Event event) {
//        if (event == null) {
//            return false;
//        }
//
////        if(BuildConfig.VERSION_CODE >= 29) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            return event.getEventType() == UsageEvents.Event.ACTIVITY_RESUMED;
//        }
////        }
//        return event.getEventType() == UsageEvents.Event.MOVE_TO_FOREGROUND;
//    }
//
//
//    public static String getAppsDetail(Context context, String packName, long useTime) {
//
//        PackageManager pm = context.getPackageManager();
////        for (ResolveInfo resolveInfo : emailResolveInfo) {
////            String packName = resolveInfo.activityInfo.packageName;
//        String appname = "";
//        try {
//            PackageInfo p = context.getPackageManager().getPackageInfo(packName, 0);
//            appname = p.applicationInfo.loadLabel(pm).toString();
////            Drawable icon = p.applicationInfo.loadIcon(pm);
////            Logger.loge("appname  :  " + appname
////                    + "     packName   :   " + packName
////                    + "     useTime   :   " + useTime
////                    + "     icon         " + icon);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return appname;
//    }
//
//}
