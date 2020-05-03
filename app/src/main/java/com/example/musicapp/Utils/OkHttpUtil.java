package com.example.musicapp.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author 徐国林
 * @data 2020/3/30
 * @decription 网络请求工具类
 */
public class OkHttpUtil {
    public static void get(final String address)
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .build();
        okHttpClient.newCall(request);
    }
    public static void get(final String address, Callback callback) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public static void post(final String address, String params,Callback callback) {
        MediaType mediaType=MediaType.parse("text/x-markdown;charset=utf-8");

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .build();
        RequestBody requestBody=RequestBody.create(mediaType,params);
        Request request = new Request.Builder()
                .url(address)
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
