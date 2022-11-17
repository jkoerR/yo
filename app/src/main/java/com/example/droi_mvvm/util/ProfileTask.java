package com.example.droi_mvvm.util;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProfileTask extends AsyncTask<String, String, String> {
    String result;
    @Override
    protected String doInBackground(String... strings) {
        String token = strings[0];// 네이버 로그인 접근 토큰;
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            result = response.toString();
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        //result 값은 JSONObject 형태로 넘어옵니다.
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(s,JsonObject.class);
//            try {
//                //넘어온 result 값을 JSONObject 로 변환해주고, 값을 가져오면 되는데요.
//                // result 를 Log에 찍어보면 어떻게 가져와야할 지 감이 오실거에요.
//                JSONObject object = new JSONObject(result);
////                if(object.getString("resultcode").equals("00")) {
////                    jsonObject = new JSONObject(object.getString("response"));
//////                    SharedPreferences.Editor editor = activity.userData.edit();
//////                    editor.putString("email", jsonObject.getString("email"));
//////                    editor.putString("name", jsonObject.getString("name"));
//////                    editor.putString("nickname", jsonObject.getString("nickname"));
//////                    editor.putString("profile", jsonObject.getString("profile_image"));
//////                    editor.apply();
//////                    Intent intent = new Intent(activity, MainActivity.class);
//////                    activity.startActivity(intent);
////                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
    }
}