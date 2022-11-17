package com.example.droi_mvvm.util;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Security {
    public static String encrypt(String input, String key) {
        byte[] crypted = null;
        String en = "";
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
            en = Base64.encodeToString(crypted, Base64.NO_WRAP);
//            en = en.replaceAll("\\n", "");
//            en = en.replaceAll(System.getProperty("line.separator"), "");
//            en = en.replaceAll("(\r\n|\r|\n|\n\r)", "");
//            en = URLDecoder.decode(en, "UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return en;
    }

    public static String decrypt(String input, String key) {
        byte[] output = null;
        String decodeStr = "";
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            output = cipher.doFinal(Base64.decode(input, Base64.NO_WRAP));
            decodeStr = new String(output);
            decodeStr = decodeStr.replace("\\r\\n", "\n");
            decodeStr = decodeStr.replace("\\n", "\n");
            decodeStr = decodeStr.replace("\\'", "'");

//            decodeStr = decodeStr.replaceAll("\\n", System.getProperty("line.separator"));
//            decodeStr = decodeStr.replaceAll("\n", System.getProperty("line.separator"));
//            decodeStr = decodeStr.replaceAll("(\r\n|\r|\n|\n\r)", "");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return decodeStr;
    }

    public static void main(String[] args) {
//        String key = "yaguin";
//        String data = "example";
//        System.out.println(Security.decrypt(Security.encrypt(data, key), key));
//        System.out.println(Security.encrypt(data, key));
    }
}