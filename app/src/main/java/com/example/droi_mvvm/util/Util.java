package com.example.droi_mvvm.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.example.droi_mvvm.Const;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import okhttp3.CookieJar;

public class Util extends AppCompatActivity {

    public static Context mContext;

    // ------- 캐시 ------ //
    // 캐시에 데이터 설정
    public static void setCacheData(String strKey, Object value) {
        try {
            synchronized (Object.class) {
                SetCacheData_Pf(strKey, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getCacheDataForKey(String strKey) {
        try {
            synchronized (Object.class) {
                String r = (String) GetCacheData_Pf(strKey);
                return ((r.equals("")) ? null : r);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }


//    public static CookieJar initCookie(Context context) {
//
//        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(this));
//    }


    public static void goIntent(Activity from, Intent intent, boolean isFinish) {
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        from.startActivity(intent);
        if (isFinish) from.finish();
    }


//    public static void setRoundColor(RelativeLayout view, String num) {
//        int range = Integer.parseInt(num);
//        if (range <= 10) {
//            view.setBackgroundResource(R.drawable.round_c_yellow);
//        } else if (range >= 11 && range <= 20) {
//            view.setBackgroundResource(R.drawable.round_c_blue);
//        } else if (range >= 21 && range <= 30) {
//            view.setBackgroundResource(R.drawable.round_c_red);
//        } else if (range >= 31 && range <= 40) {
//            view.setBackgroundResource(R.drawable.round_c_gray);
//        } else if (range >= 41 && range <= 50) {
//            view.setBackgroundResource(R.drawable.round_c_green);
//        }
//    }


    public static String getBase64encode(String content){

        return Base64.encodeToString(content.getBytes(), 0);

    }
    public static String getBase64decode(String content){

        return new String(Base64.decode(content, 0));

    }

//
//    public static void setAds(Context context, AdView adView) {
//
//        MobileAds.initialize(context, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//
////        MobileAds.initialize(this, getString(R.string.admob_app_id));
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
//
//        // 광고가 제대로 로드 되는지 테스트 하기 위한 코드입니다.
//
//        adView.setAdListener(new AdListener() {
//
//            @Override
//            public void onAdLoaded() {
//                // Code to be executed when an ad finishes loading.
//                // 광고가 문제 없이 로드시 출력됩니다.
////                Logger.loge("onAdLoaded");
//            }
//
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                // Code to be executed when an ad request fails.
//                // 광고 로드에 문제가 있을시 출력됩니다.
////                Logger.loge("onAdFailedToLoad");
//            }
//
//            @Override
//            public void onAdOpened() {
//
//                // Code to be executed when an ad opens an overlay that
//
//                // covers the screen.
//
//            }
//
//
//            @Override
//            public void onAdClicked() {
//                // Code to be executed when the user clicks on an ad.
//            }
//
//
//            @Override
//            public void onAdLeftApplication() {
//                // Code to be executed when the user has left the app.
//            }
//
//
//            @Override
//            public void onAdClosed() {
//                // Code to be executed when the user is about to return
//                // to the app after tapping on an ad.
//            }
//
//        });
//    }


    public static void getReleaseHashKey() {
        byte[] sha1 = {
                (byte)0xF8,
                (byte)0x59,
                (byte)0x73,
                (byte)0x5F,
                (byte)0xA7,
                (byte)0x50,
                (byte)0x52,
                (byte)0xB4,
                (byte)0x47,
                (byte)0xF0,
                (byte)0x54,
                (byte)0xDD,
                (byte)0x14,
                (byte)0xE1,
                (byte)0xCB,
                (byte)0x0E,
                (byte)0x77,
                (byte)0xDC,
                (byte)0xE2,
                (byte)0xA6
        };
        Logger.loge("getReleaseHashKey: " + Base64.encodeToString(sha1, Base64.NO_WRAP));
    }

//    public static void setGradient(Context context, View view, int so) {
//        GradientDrawable drawable2 = (GradientDrawable) context.getDrawable(so);
//        view.setBackground(drawable2);
//        view.setClipToOutline(true);
//    }

    public static String countdday(String end) {
        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date endDate = dateFormat.parse(end);

            long endDateTime = endDate.getTime();

            Date curDate = new Date();
            curDate = dateFormat.parse(dateFormat.format(curDate));
            long curDateTime = curDate.getTime();

//            Logger.loge("endDateTime  :  "   +  endDateTime);
//            Logger.loge("curDateTime  :  "   +  curDateTime);

            long calc = curDateTime - endDateTime;

//            Calendar todaCal = Calendar.getInstance(); //오늘날자 가져오기
//            Calendar ddayCal = Calendar.getInstance(); //오늘날자를 가져와 변경시킴
//            mmonth -= 1; // 받아온날자에서 -1을 해줘야함.
//            ddayCal.set(myear,mmonth,mday);// D-day의 날짜를 입력
            long today = curDateTime / 86400000; //->(24 * 60 * 60 * 1000) 24시간 60분 60초 * (ms초->초 변환 1000)
            long dday = endDateTime / 86400000;

            long tTime = curDateTime / 3600000;
            long dTime = endDateTime / 3600000;

            long count = dTime - tTime; // 오늘 날짜에서 dday 날짜를 빼주게 됩니다.
//            Logger.loge("count  :  "   +  count);

//            long count = dday - today; // 오늘 날짜에서 dday 날짜를 빼주게 됩니다.
//            Logger.loge("count  :  "   +  count);
//            return (int) count;
//            String time = dateFormat.format(calc);

            String time = (count / 24) + "일 " + (count % 24) + "시간";

            return time;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String MillToDate(long mills) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = (String) formatter.format(new Timestamp(mills));
        return date;
    }


    public static long diffTime(String before, String interval) {
//        Gson gson = new Gson();
//        ArrayList mArray = (ArrayList<String>) gson.fromJson(list,
//                new TypeToken<ArrayList>() {}.getType());

        long diff = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date reqDate = dateFormat.parse(before);

//            Logger.loge("reqDate  :  "   +  reqDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(reqDate);
            cal.add(cal.MINUTE, Integer.parseInt(interval));
            Date beforeDate = new Date(cal.getTimeInMillis());
            long reqDateTime = beforeDate.getTime();

            Date curDate = new Date();
            curDate = dateFormat.parse(dateFormat.format(curDate));
            long curDateTime = curDate.getTime();

            long sec = (reqDateTime - curDateTime) / 1000;

            //분으로 표현
            long minute = (reqDateTime - curDateTime) / 60000;
//            Logger.loge("요청시간 : " + beforeDate);
//            Logger.loge("현재시간 : " + curDate);
//            Logger.loge(minute+"분 차이");

            long hour = TimeUnit.MINUTES.toHours(minute); // 3
            long minutes = TimeUnit.MINUTES.toMinutes(minute) - TimeUnit.HOURS.toMinutes(hour); // 44
//            Logger.loge("hour   :  "+  hour  +   "      minutes   :  "   +  minutes     + "     sec    :  "   +  sec);
//            diff = curDateTime - reqDateTime;
            diff = reqDateTime - curDateTime;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static long diffTime_now_end(String end) {
        long diff = 0;
        try {
//            Logger.loge("interval  :  "   +  end);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date endDate = dateFormat.parse(end);
//            Logger.loge("reqDate  :  "   +  reqDate);
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(endDate);
////            cal.add(cal.MINUTE, Integer.parseInt(interval));
//            Date beforeDate = new Date(cal.getTimeInMillis());
            long reqDateTime = endDate.getTime();

            Date curDate = new Date();
            curDate = dateFormat.parse(dateFormat.format(curDate));
            long curDateTime = curDate.getTime();

            long sec = (reqDateTime - curDateTime) / 1000;

            //분으로 표현
            long minute = (reqDateTime - curDateTime) / 60000;
//            Logger.loge("요청시간 : " + beforeDate);
//            Logger.loge("현재시간 : " + curDate);
//            Logger.loge(minute+"분 차이");

            long hour = TimeUnit.MINUTES.toHours(minute); // 3
            long minutes = TimeUnit.MINUTES.toMinutes(minute) - TimeUnit.HOURS.toMinutes(hour); // 44
            Logger.loge("hour   :  " + hour + "      minutes   :  " + minutes + "     sec    :  " + sec);
//            diff = curDateTime - reqDateTime;
            diff = reqDateTime - curDateTime;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static String getAlarmTime(String before, String interval) {
        String time = "";
        try {
            if (before.equals("")) return time;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date reqDate = dateFormat.parse(before);

//            Logger.loge("reqDate  :  "   +  reqDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(reqDate);
            cal.add(cal.MINUTE, Integer.parseInt(interval));
            time = dateFormat.format(cal.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static long diffTime_now(String time) {
        long diff = 0;
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
            Date reqDate = dateFormat.parse(time);

            SimpleDateFormat dateFormat_mm = new SimpleDateFormat("mm");
            String getMinite = dateFormat_mm.format(reqDate);

//            Logger.loge("reqDate  :  "   +  reqDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(reqDate);
            cal.set(cal.MINUTE, Integer.parseInt(getMinite));
            Date beforeDate = new Date(cal.getTimeInMillis());
            long reqDateTime = beforeDate.getTime();

            Date curDate = new Date();
            curDate = dateFormat.parse(dateFormat.format(curDate));
            long curDateTime = curDate.getTime();

            long sec = (reqDateTime - curDateTime) / 1000;

            //분으로 표현
            long minute = (reqDateTime - curDateTime) / 60000;
//            Logger.loge("요청시간 : " + beforeDate);
//            Logger.loge("현재시간 : " + curDate);
//            Logger.loge(minute+"분 차이");

            long hour = TimeUnit.MINUTES.toHours(minute); // 3
            long minutes = TimeUnit.MINUTES.toMinutes(minute) - TimeUnit.HOURS.toMinutes(hour); // 44
//            Logger.loge("hour   :  "+  hour  +   "      minutes   :  "   +  minutes     + "     sec    :  "   +  sec);
//            diff = curDateTime - reqDateTime;
            diff = reqDateTime - curDateTime;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static String diffTime_text(String before) {
//        20200116142730
        String diff = "";
        try {
//            Date curDate = new Date();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//            Date reqDate = dateFormat.parse(before);

//            Calendar cal = Calendar.getInstance();
//            cal.setTime(reqDate);
//            cal.add(Calendar.MINUTE, Integer.parseInt(interval));
//            reqDate = new Date(cal.getTimeInMillis());

            long reqDateTime = Long.parseLong(before);
//            curDate = dateFormat.parse(dateFormat.format(curDate));
//            long curDateTime = curDate.getTime();
//            Logger.loge("reqDateTime  :  "   +  reqDateTime);
            long sec = ((reqDateTime) / 1000);

            //분으로 표현
//            long minute = (reqDateTime) / 60000;
//            Logger.loge("현재시간 : " + curDate);
//            Logger.loge(minute+"분 차이");


//            long hour = TimeUnit.MINUTES.toHours(minute);
//            long minutes = TimeUnit.MINUTES.toMinutes(minute) - TimeUnit.HOURS.toMinutes(hour);
//            long secs = TimeUnit.MINUTES.toSeconds(minute) - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hour);
            long hour = TimeUnit.SECONDS.toHours(sec);
            long minutes = TimeUnit.SECONDS.toMinutes(sec) - TimeUnit.HOURS.toMinutes(hour);
            long secs = TimeUnit.SECONDS.toSeconds(sec) - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hour);

            String str_hour = String.valueOf(hour);
            String str_minutes = String.valueOf(minutes);
            String str_secs = String.valueOf(secs);

            if (str_hour.length() == 1) str_hour = "0" + str_hour;
            if (str_minutes.length() == 1) str_minutes = "0" + str_minutes;
            if (str_secs.length() == 1) str_secs = "0" + str_secs;

//            Logger.loge("TimeUnit.HOURS.toSeconds(hour)   :  "  +  TimeUnit.HOURS.toSeconds(hour) );
//            Logger.loge("TimeUnit.MINUTES.toSeconds(minute)   : "  +  TimeUnit.MINUTES.toSeconds(minutes));
//            Logger.loge("TimeUnit.MINUTES.toSeconds(minute)  :  "  +  TimeUnit.SECONDS.toSeconds(sec));
//
//            Logger.loge("hour   :  "+  hour  +   "      minutes   :  "   +  minutes     + "     sec    :  "   +  secs);
//            diff = curDateTime - reqDateTime;
            diff = str_hour + ":" + str_minutes + ":" + str_secs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return diff;
    }


    //시간계산
    public static String calcDate(String date) {
        // 날짜
        String calcDate = null;

        DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar today = Calendar.getInstance();
        String strToday = "" + today.get(Calendar.YEAR) + today.get(Calendar.MONTH) + today.get(Calendar.DATE);
        if (date.equals("")) {
            calcDate = "";
        } else {
            Calendar lastDate = Calendar.getInstance();
            try {
                lastDate.setTime(sdFormat.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String strDate = "" + lastDate.get(Calendar.YEAR) + lastDate.get(Calendar.MONTH) + lastDate.get(Calendar.DATE);
            if (strToday.compareTo(strDate) == 0) {
                String strAMPM = "";
                int iAMPM = lastDate.get(Calendar.AM_PM);
                if (iAMPM == Calendar.AM)
                    strAMPM = "오전";
                else
                    strAMPM = "오후";

                int nHour = lastDate.get(Calendar.HOUR_OF_DAY);
                if (nHour > 12)
                    nHour = nHour - 12;
                else if (nHour == 24)
                    nHour = 0;

                int nMinute = lastDate.get(Calendar.MINUTE);
                calcDate = strAMPM + " " + nHour + ":" + (nMinute < 10 ? "0" + nMinute : nMinute);
            } else {
                int month = (lastDate.get(Calendar.MONTH) + 1);
                String strMonth = month > 12 ? "1" : "" + month;

                int day = (lastDate.get(Calendar.DATE));
                String strDay = day < 10 ? "0" + day : "" + day;

                calcDate = lastDate.get(Calendar.YEAR) + "." + strMonth + "." + strDay;
            }
        }

        if (calcDate == null) {
            calcDate = "";
        }
        return calcDate;
    }

//    public static String getPhoneNumberFormat(String phoneNum) {
//        return PhoneNumberUtils.formatNumber(phoneNum, Locale.getDefault().getCountry());
//    }

    public static SpannableString getUnderbar(String str) {
        SpannableString content = new SpannableString(str);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        return content;
    }

    public static String myFormatter(String num) {
        try {
            if (num == null || num.equals("")) return "0";
            char tmp;
            boolean isnum = true;
            for (int i = 0; i < num.length(); i++) {
                tmp = num.charAt(i);
                if (!(tmp == '.') && !(('0' <= tmp && tmp <= '9'))) {
                    isnum = false;
                }
            }
            if (!isnum) return num;
            DecimalFormat myFormatter;
//            Logger.loge("num  :  "  + num);
            if (num.contains(".")) {
                String sub = num.substring(num.indexOf(".") + 1);
//                Logger.loge("sub  :  "  + sub);
                if (sub.length() > 1) {
                    if ((sub.charAt(0) + "").equals("0")) {
                        if ((sub.charAt(1) + "").equals("0")) {
                            myFormatter = new DecimalFormat("###,###,###");
                        } else {
                            myFormatter = new DecimalFormat("###,###,###.##");
                        }
                    } else {
                        if ((sub.charAt(1) + "").equals("0")) {
                            myFormatter = new DecimalFormat("###,###,###.#");
                        } else {
                            myFormatter = new DecimalFormat("###,###,###.##");
                        }
                    }
                } else if (sub.length() > 0) {
                    if ((sub.charAt(0) + "").equals("0")) {
                        myFormatter = new DecimalFormat("###,###,###");
                    } else {
                        myFormatter = new DecimalFormat("###,###,###.#");
                    }
                } else {
                    myFormatter = new DecimalFormat("###,###,###");
                }
            } else {
                myFormatter = new DecimalFormat("###,###,###");
            }
            return myFormatter.format(Double.parseDouble(num));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String myFormatter2(String num) {
//        if (num == null || num.equals("")) return "0";
//        DecimalFormat myFormatter = new DecimalFormat("#,##");
//        return myFormatter.format(Long.parseLong(num));
        if (num.length() > 2) {
            num = num.substring(0, 1) + "." + num.substring(1, num.length());
        } else {
            num = "0." + num;
        }
        return num;
    }

    public static String calcDis(String pay, String dis) {
        try {
            if (dis == null || dis.equals("") || dis.equals("0")) return pay;
            return String.valueOf((int) (Double.parseDouble(pay) * ((100 - Double.parseDouble(dis)) / 100)));
        } catch (Exception e) {
            return pay;
        }
    }

    public static String getDeviceID() {
        return Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static int getAge(int birthYear, int birthMonth, int birthDay) {
        Calendar current = Calendar.getInstance();
        int currentYear = current.get(Calendar.YEAR);
        int currentMonth = current.get(Calendar.MONTH) + 1;
        int currentDay = current.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - birthYear;
        // 생일 안 지난 경우 -1
        if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay)
            age--;
        return age;
    }

    public static boolean getlottoWeek() {
        boolean result = false;
        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR,Integer.parseInt("20"));

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String str = hour + "" + minute + "" + second;
        long calc = Long.parseLong(str);

//        Logger.loge("calc  :  "   +  calc);

//월 9  토 20
        switch (dayOfWeek) {
            case 1://일
                result = false;
                break;
            case 2:
                result = hour > 8;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                result = true;
                break;
            case 7://토
                result = hour < 20;
                break;
        }
        return result;
    }

    public static String getAppVersion() {
        PackageInfo packageInfo = null;
        String version = "";
        try {
            packageInfo = mContext.getPackageManager().getPackageInfo(getPackageName(mContext), 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return version;
    }

    public static String getDecode(String encodeStr) throws UnsupportedEncodingException {
        return URLDecoder.decode(encodeStr, "UTF-8");
    }

    public static String getEncode(String decodeStr) throws UnsupportedEncodingException {
        return URLEncoder.encode(decodeStr, "UTF-8");
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static JsonObject baseJson() {
//        String usr_key = (String) Util.getCacheDataForKey(Const.USR_KEY);
//        if (usr_key == null) usr_key = "0@0";
//        Logger.loge("usr_key  :  "  +  usr_key);
//        String deviceId = (String) Util.getCacheDataForKey(Const.USER_DEVICE_ID);
//        if (deviceId == null) {
//            deviceId = Util.getDeviceID();
//            Util.setCacheData(Const.USER_DEVICE_ID, deviceId);
//        }
//        String app_ver = Util.getAppVersion();
//        String auth_token = Util.cNull(Util.getCacheDataForKey(Const.AUTH_TOKEN));
//        String usr_key = Util.cNull(Util.getCacheDataForKey(Const.USR_KEY));
//        String access_token = (String) Util.getCacheDataForKey(Const.ACCESS_TOKEN);
//봄툰
//        Logger.loge("usr_key  :  "   +  usr_key);

//        ytWvjEyGGAn8p8OKOj72iJCHuRNyyNw68pSdNbjlNZM=

        JsonObject jsonObject = new JsonObject();
////        jsonObject.addProperty("usr_key", usr_key);
//        jsonObject.addProperty("app_ver", app_ver);
//        jsonObject.addProperty("usr_key", usr_key);
//        jsonObject.addProperty("app_cd", "A");
//        jsonObject.addProperty("auth_token", auth_token);
//        jsonObject.addProperty("dvc_id", deviceId);
//        jsonObject.addProperty("access_token", access_token);
//        jsonObject.addProperty("auth", access_token);

        return jsonObject;
    }




    // Preferences
    public static void SetCacheData_Pf(String key, Object v) {
        SharedPreferences spf = mContext.getSharedPreferences(Const.APP_CACHE, 0);
        SharedPreferences.Editor edit = spf.edit();

        if (v instanceof JSONObject)
            edit.putString(key, v.toString());

        if (v instanceof Integer)
            edit.putString(key, "" + (int) v);
        else
            edit.putString(key, (String) v);

        edit.commit();
    }

    public static Object GetCacheData_Pf(String key) {
        SharedPreferences spf = mContext.getSharedPreferences(Const.APP_CACHE, 0);
        SharedPreferences.Editor edit = spf.edit();

        return spf.getString(key, "");
    }

    public static void showKeyboard(Context context, final View view) {
        view.requestFocus();
        final InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 100);
    }

    public static void disKeyboard(Context context, View view) {
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static Bitmap resize(Context context, Uri uri, int resize) {
        Bitmap resizeBitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options); // 1번

            int width = options.outWidth;
            int height = options.outHeight;
            int samplesize = 1;

            while (true) {//2번
                if (width / 2 < resize || height / 2 < resize)
                    break;
                width /= 2;
                height /= 2;
                samplesize *= 2;
            }
            options.inSampleSize = samplesize;
            Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options); //3번
            resizeBitmap = bitmap;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resizeBitmap;
    }

    public static int exifOrientationToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }
        return 0;
    }

    public static Bitmap AutoResizeForImg(Bitmap bm) {
        float defaultWidth = 1080;
        float defaultHeight = 1920;
        float imgWidth = bm.getWidth();
        float imgHeight = bm.getHeight();

        if (imgWidth > defaultWidth) {
            float rate = defaultWidth / imgWidth; // 이미지크기를 기준되는 크기로 변경시 비율

            imgWidth = defaultWidth;    // 이미지크기 기준크기로 변경
            imgHeight = imgHeight * rate;  // 비율에따라 이미지 세로크기도 변경
        }

        Bitmap resized = Bitmap.createScaledBitmap(bm, (int) imgWidth, (int) imgHeight, true);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        resized.compress(Bitmap.CompressFormat.WEBP, 100, os); // 압축할때 50% 화질로 압축
        resized.compress(Bitmap.CompressFormat.PNG, 100, os); // 압축할때 50% 화질로 압축
        byte[] b90 = os.toByteArray();
//        //Logger.loge("b90  :  "  +  b90.length);
        return resized;
    }

    public static String cNull(Object obj) {
        if (obj == null)
            return "";
        else if (obj == "null")
            return "";
        else
            return (String) obj;
    }

    public static void showToast(Context ctxt, String str) {
        Toast toast;
        toast = Toast.makeText(ctxt, str, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 200);
//
//        LinearLayout toastLayout = (LinearLayout) toast.getView();
//        TextView toastTV = (TextView) toastLayout.getChildAt(0);
//        toastTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        toast.show();
    }

    public static void showSnackBar(View view, String text) {
        final Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        snackbar.setAction("close", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

//    public static void showSnackBar_top(Activity context, String text) {
//        final Snackbar snackbar = Snackbar.make(context.findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG);
//        View view = snackbar.getView();
//        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
//        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
//// calculate actionbar height
//        TypedValue tv = new TypedValue();
//        int actionBarHeight = 0;
//        if (context.getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
//            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
//        }
//// set margin
//        params.setMargins(0, actionBarHeight, 0, 0);
//        view.setLayoutParams(params);
//        snackbar.setAction("close", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                snackbar.dismiss();
//            }
//        });
//        if (!snackbar.isShown()) snackbar.show();
//
//    }

    public static String Encrypt(String str, String key, String key2) {
        String pw = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes("UTF-8"));

            pw = md.toString();

            byte b[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < b.length; i++)
                sb.append(String.format("%02x", b[i]));
            //sb.append( Integer.toString( (b[i] & 0xFF), 16 ).substring(1) );
            pw = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            pw = null;
            Logger.log("ENCRYPT", "ERROR : " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            pw = null;
            Logger.log("ENCRYPT", "ERROR : " + e.getMessage());
        }
        return pw;
    }

    public static boolean checkEmail(String email) {
        Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$");
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    public static boolean checkPnum(String pw) {
        Pattern PASSWORD_PATTERN = Pattern.compile("^[0-9]+$");
        return PASSWORD_PATTERN.matcher(pw).matches();
    }

    public static boolean checkLottonum(String pw) {
        boolean ismatches = false;
        Pattern PASSWORD_PATTERN = Pattern.compile("^[0-9]+$");
        if (PASSWORD_PATTERN.matcher(pw).matches()) {
            if (Integer.parseInt(pw) > 0 && Integer.parseInt(pw) < 46) {
                ismatches = true;
            }
        }
        return ismatches;
    }

    public static boolean checkId(String pw) {
        //최소 6글자 ~12자까지
        //영문+숫자+특수문자 Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$");
        if ((pw.length() < 4 || pw.length() > 10)) return false;
        Pattern PASSWORD_PATTERN = Pattern.compile("^[a-z0-9]+$");
        return PASSWORD_PATTERN.matcher(pw).matches();
    }

    public static boolean checkPw(String pw) {
        //최소 6글자 ~12자까지
        //영문+숫자+특수문자 Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$");
        if ((pw.length() < 4 || pw.length() > 20))
            return false;
        Pattern PASSWORD_PATTERN = Pattern.compile("^[0-9a-zA-Z!@#$%^*+=-]+$");
        return PASSWORD_PATTERN.matcher(pw).matches();
    }

    public static boolean checkkey(String pw) {
        //최소 6글자 ~12자까지
        //영문+숫자+특수문자 Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$");
        Pattern PASSWORD_PATTERN = Pattern.compile("^[ㄱ-ㅎ ㅏ-ㅣ ㆍ 가-힣 0-9a-zA-Z]+$");
        return PASSWORD_PATTERN.matcher(pw).matches();
    }

    public static boolean checkName(String pw) {
        //최소 6글자 ~12자까지
        //영문+숫자+특수문자 Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$");
        if ((pw.length() < 2 || pw.length() > 10))
            return false;
        Pattern PASSWORD_PATTERN = Pattern.compile("^[ㄱ-ㅎ 가-힣 0-9a-zA-Z!@#$%^*+=-]+$");
        return PASSWORD_PATTERN.matcher(pw).matches();
    }

    public static String getDateFormatTime(String str) {
        String time = null;
        SimpleDateFormat ori = new SimpleDateFormat("HHmmss");
        SimpleDateFormat tran = new SimpleDateFormat("HH:mm");
        try {
            Date oDate = ori.parse(str);
            time = tran.format(oDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String getDateFormatTime2(String str) {
        String time = null;
        SimpleDateFormat ori = new SimpleDateFormat("HHmmss");
        SimpleDateFormat tran = new SimpleDateFormat("HH시mm분");
        try {
            Date oDate = ori.parse(str);
            time = tran.format(oDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String getDateFormatDate(String str) {
        String time = null;
        SimpleDateFormat ori = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat tran = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date oDate = ori.parse(str);
            time = tran.format(oDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String getDateFormatDate3(String str) {
        String time = null;
        SimpleDateFormat ori = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat tran = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date oDate = ori.parse(str);
            time = tran.format(oDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String getDateFormatDate2(String str) {
        String time = null;
        SimpleDateFormat ori = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat tran = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat tran = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        try {
            Date oDate = ori.parse(str);
            time = tran.format(oDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TreeSet<Integer> set = new TreeSet();
        while (set.size() < 6) {
            int random = new Random().nextInt(45);
            set.add(random);
        }
        for (Integer i : set) {

        }


        return time;
    }

//    public static void getADID(Context context) {
//        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... params) {
//                AdvertisingIdClient.Info idInfo = null;
//                try {
//                    idInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
//                } catch (GooglePlayServicesNotAvailableException e) {
//                    e.printStackTrace();
//                } catch (GooglePlayServicesRepairableException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                String advertId = null;
//                try {
//                    advertId = idInfo.getId();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return advertId;
//            }
//
//            @Override
//            protected void onPostExecute(String advertId) {
//                advertId = advertId.replace("-", "");
////                Logger.loge("advertId : " + advertId);
//                Util.setCacheData(Const.GOOGLE_AD_KEY, advertId);
//            }
//        };
//        task.execute();
//    }


    public static void goPlayStore(Context context) {
        String appId = context.getPackageName();
        Intent rateIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + appId));
        boolean marketFound = false;

        // find all applications able to handle our rateIntent
        final List<ResolveInfo> otherApps = context.getPackageManager()
                .queryIntentActivities(rateIntent, 0);
        for (ResolveInfo otherApp : otherApps) {
            // look for Google Play application
            if (otherApp.activityInfo.applicationInfo.packageName
                    .equals("com.android.vending")) {

                ActivityInfo otherAppActivity = otherApp.activityInfo;
                ComponentName componentName = new ComponentName(
                        otherAppActivity.applicationInfo.packageName,
                        otherAppActivity.name
                );
                // make sure it does NOT open in the stack of your activity
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // task reparenting if needed
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                // if the Google Play was already open in a search result
                //  this make sure it still go to the app page you requested
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // this make sure only the Google Play app is allowed to
                // intercept the intent
                rateIntent.setComponent(componentName);
                context.startActivity(rateIntent);
                marketFound = true;
                break;

            }
        }

        // if GP not present on device, open web browser
        if (!marketFound) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + appId));
            context.startActivity(webIntent);
        }
    }

//    public static File bitmapToFile(Context context, Bitmap finalBitmap) {
//
////        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
//        String root = context.getExternalFilesDir(null).getAbsolutePath();
//        File myDir = new File(root + "/saved_images");
//        myDir.mkdirs();
//        long now = System.currentTimeMillis();
//        String id = (String) Util.getCacheDataForKey(Const.);
////        String sp[] = id.split("@");
////        id = sp[0] + now;
////        String fname = id + ".webp";
//        String fname = id + now + ".png";
//        File file = new File(myDir, fname);
//        if (file.exists()) file.delete();
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return file;
//    }

//    public static String getRealPathFromURI(final Context context, final Uri uri) {
//
//        // DocumentProvider
//        if (DocumentsContract.isDocumentUri(context, uri)) {
//            // ExternalStorageProvider
//            if (isExternalStorageDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//                if ("primary".equalsIgnoreCase(type)) {
////                    return Environment.getExternalStorageDirectory() + "/"+ split[1];
//                    return context.getExternalFilesDir(null) + "/" + split[1];
//                } else {
//                    String SDcardpath = getRemovableSDCardPath(context).split("/Android")[0];
//                    return SDcardpath + "/" + split[1];
//                }
//            }
//            // DownloadsProvider
//            else if (isDownloadsDocument(uri)) {
//                final String id = DocumentsContract.getDocumentId(uri);
//                final Uri contentUri = ContentUris.withAppendedId(
//                        Uri.parse("content://downloads/public_downloads"),
//                        Long.valueOf(id));
//
//                return getDataColumn(context, contentUri, null, null);
//            }
//
//            // MediaProvider
//            else if (isMediaDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                Uri contentUri = null;
//                if ("image".equals(type)) {
//                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//                } else if ("video".equals(type)) {
//                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//                } else if ("audio".equals(type)) {
//                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//                }
//
//                final String selection = "_id=?";
//                final String[] selectionArgs = new String[]{split[1]};
//
//                return getDataColumn(context, contentUri, selection,
//                        selectionArgs);
//            }
//        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
//            // Return the remote address
//            if (isGooglePhotosUri(uri))
//                return uri.getLastPathSegment();
//            return getDataColumn(context, uri, null, null);
//        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
//            return uri.getPath();
//        }
//        return null;
//    }

    public static String getRemovableSDCardPath(Context context) {
        File[] storages = ContextCompat.getExternalFilesDirs(context, null);
        if (storages.length > 1 && storages[0] != null && storages[1] != null)
            return storages[1].toString();
        else
            return "";
    }

    public static String getDataColumn(Context context, Uri uri,
                                       String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection,
                    selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri
                .getAuthority());
    }


    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri
                .getAuthority());
    }


    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri
                .getAuthority());
    }


    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri
                .getAuthority());
    }

    private TextWatcher textWatcher = new TextWatcher() {
        private EditText editText;

        public void TextWatcher(EditText editText) {
            this.editText = editText;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}


