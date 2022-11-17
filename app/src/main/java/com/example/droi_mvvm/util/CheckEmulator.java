//package com.example.droi_mvvm.util;
//
//import android.app.ActivityManager;
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorManager;
//import android.os.Build;
//import android.telephony.TelephonyManager;
//
//
//import com.example.droi_mvvm.Const;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static android.content.Context.ACTIVITY_SERVICE;
//import static android.content.Context.SENSOR_SERVICE;
//import static android.content.Context.TELEPHONY_SERVICE;
//
//public class CheckEmulator {
//
//    public static boolean check_build(Context context) {
//        String info = "";
//
//        TelephonyManager telManager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
//
//        String networkinfo = telManager.getNetworkOperatorName();
//
//        info += "BOARD =" + Build.BOARD + "\n";
//
//        info += "BRAND =" + Build.BRAND + "\n";
//
//        info += "DEVICE =" + Build.DEVICE + "\n";
//
//        info += "FINGERPRINT =" + Build.FINGERPRINT.startsWith("generic") + "\n";
//
//        info += "DISPLAY =" + Build.DISPLAY + "\n";
//
//        info += "MANUFACTURER =" + Build.MANUFACTURER + "\n";
//
//        info += "MODEL =" + Build.MODEL + "\n";
//
//        info += "PRODUCT =" + Build.PRODUCT + "\n";
//
//        info += "networkinfo =" + networkinfo + "\n";
//
//        info += "getRadioVersion() =" + Build.getRadioVersion() + "\n";
//
//        info += "SUPPORTED_32_BIT_ABIS =" + Build.SUPPORTED_32_BIT_ABIS + "\n";
//
//        info += "SUPPORTED_64_BIT_ABIS =" + Build.SUPPORTED_64_BIT_ABIS + "\n";
//
////        Logger.loge("Build.SUPPORTED_32_BIT_ABIS  :  "  +  Arrays.toString(Build.SUPPORTED_32_BIT_ABIS));
////        Logger.loge("Build.SUPPORTED_64_BIT_ABIS  :  "  +  Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
//        Util.setCacheData(Const.BIT_ABIS,Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
//
//        SensorManager manager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
//
//        if (manager.getSensorList(Sensor.TYPE_ALL).isEmpty()) {
//            // running on an emulator
//            info += "running on an emulator!! sensor empty ";
//        } else {
//            // running on a device
//            info += "running on an device!! sensor use";
//        }
//        ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
//        List<ActivityManager.RunningAppProcessInfo> list = am.getRunningAppProcesses();
//        List<ActivityManager.RunningServiceInfo> listservice = am.getRunningServices(Integer.MAX_VALUE);
//        for (int i = 0; i < listservice.size(); i++) {
//            //실행중인 서비스 이름(패키지명)
//            info += "\n" + (listservice.get(i).process);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            //실행중인 프로세스 이름(패키지명)
//            info += ("\n" + list.get(i).processName);
//        }
//        return Build.getRadioVersion()==null||Build.getRadioVersion().equals("");
//    }
//
//
//    public static boolean isVirtualDeivce() {
//        String msg = "BOARD = " + Build.BOARD +
//                "\nBOOOTLOADER = " + Build.BOOTLOADER +
//                "\nBRAND = " + Build.BRAND +
//                "\nDEVICE = " + Build.DEVICE +
//                "\nDISPLAY = " + Build.DISPLAY +
//                "\nFINGERPRINT = " + Build.FINGERPRINT +
//                "\nHARDWARE = " + Build.HARDWARE +
//                "\nHOST = " + Build.HOST +
//                "\nID = " + Build.ID +
//                "\nMANUFACTURER = " + Build.MANUFACTURER +
//                "\nMODEL = " + Build.MODEL +
//                "\nPRODUCT = " + Build.PRODUCT +
//                "\nRADIO = " + Build.getRadioVersion() +
//                "\nSERIAL = " + Build.SERIAL +
//                "\nTAGS = " + Build.TAGS +
//                "\nTYPE = " + Build.TYPE +
//                "\nUSER = " + Build.USER;
//        return Build.FINGERPRINT.startsWith("generic")
//                || Build.FINGERPRINT.startsWith("unknown")
//                || Build.MODEL.contains("google_sdk")
//                || Build.MODEL.contains("Emulator")
//                || Build.MODEL.contains("Android SDK built for x86")
//                || Build.MANUFACTURER.contains("Genymotion")
//                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
//                || "google_sdk".equals(Build.PRODUCT);
//    }
//
//    // Below, forked from https://github.com/oguzhantopgul/Android-Emulator-Detection/blob/master/src/com/ouz/evasion/EvasionMainActivity.java
//// (IMO) "ro.secure", "ro.kernel.qemu" cann't work with jailbreak.
//// This properties mean adb shell as root. So not only virtual device, also jailbreak too.
//    public static Boolean isEmulator(Context paramContext) {
//        Boolean isEmulator = false;
//        try {
//            Class SystemProperties = Class.forName("android.os.SystemProperties");
//            TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService(TELEPHONY_SERVICE);
//            if (getProperty(SystemProperties, "ro.secure").equalsIgnoreCase("0"))
//                isEmulator = Boolean.valueOf(true);
//            else if (getProperty(SystemProperties, "ro.kernel.qemu").equalsIgnoreCase("1"))
//                isEmulator = Boolean.valueOf(true);
//            else if (Build.PRODUCT.contains("sdk"))
//                isEmulator = Boolean.valueOf(true);
//            else if (Build.MODEL.contains("sdk"))
//                isEmulator = Boolean.valueOf(true);
//            else if (localTelephonyManager.getSimOperatorName().equals("Android"))
//                isEmulator = Boolean.valueOf(true);
//            else if (localTelephonyManager.getNetworkOperatorName().equals("Android"))
//                isEmulator = Boolean.valueOf(true);
//            else
//                isEmulator = Boolean.valueOf(false);
//
//            String msg = "ro.secure = " + getProperty(SystemProperties, "ro.secure") +
//                    "\nro.kernel.qemu = " + getProperty(SystemProperties, "ro.kernel.qemu") +
//                    "\nSimOperatorName = " + localTelephonyManager.getSimOperatorName() +
//                    "\nNetworkOperatorName = " + localTelephonyManager.getNetworkOperatorName();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isEmulator;
//    }
//
//    private static String getProperty(Class myClass, String propertyName) throws Exception {
//        return (String) myClass.getMethod("get", String.class).invoke(myClass, propertyName);
//    }
//}
