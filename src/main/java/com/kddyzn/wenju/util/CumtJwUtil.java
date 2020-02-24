package com.kddyzn.wenju.util;

import com.alibaba.fastjson.JSON;
import com.kddyzn.wenju.constant.AppConstant;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class CumtJwUtil {

    public String getLoginToken(String userId, String password) {
        String loginUrl = AppConstant.CUMT_JW_API + "/login";
        RequestBody body = new FormBody.Builder()
                .add("username", userId)
                .add("password", password)
                .build();
        try {
            Map map = (Map) JSON.parse(sendPostRequest(loginUrl, body));
            if (map.containsKey("token")) {
                return map.get("token").toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sendPostRequest(String url, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        if (response.body() != null) {
            return response.body().string();
        }
        return "";
    }
}
