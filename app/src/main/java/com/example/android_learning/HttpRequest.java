package com.example.android_learning;

import android.support.annotation.Nullable;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpRequest {
    // get获取网页的html源代码
    static String getHtml(String path) throws Exception {
        URL url = new URL(path);//新建URL对象
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);//设置超时
        conn.setRequestMethod("GET");//设置请求方法
        conn.setRequestProperty("Content-type", "application/json");//请求头
        if (conn.getResponseCode() == 200) {
            InputStream is = conn.getInputStream();//新建输入流对象
            byte[] data = StreamTool.read(is);//调用StreamTool在流中获取数据
            return new String(data, StandardCharsets.UTF_8);
        }
        return null;
    }

    static String postHtml(String path, @Nullable String params) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置运行输入,输出:
        conn.setDoOutput(true);
        conn.setDoInput(true);
        //设置请求方式,请求超时信息
        conn.setRequestMethod("POST");
        conn.setReadTimeout(5000);
        conn.setConnectTimeout(5000);
        // 配置请求Content-Type
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //Post方式不能缓存,需手动设置为false
        conn.setUseCaches(false);
        if (params != null) {
            byte[] postData = params.getBytes();
            //获取输出流
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.write(postData);
            out.flush();
            out.close();
        }
        if (conn.getResponseCode() == 200) {
            InputStream is = conn.getInputStream();//新建输入流对象
            byte[] data = StreamTool.read(is);//调用StreamTool在流中获取数据
            Log.e("code", String.valueOf(conn.getResponseCode()));
            return new String(data, StandardCharsets.UTF_8);
        }
        return null;
    }
}
