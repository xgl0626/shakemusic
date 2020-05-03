package com.example.musicapp.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author 徐国林
 * @data 2020/4/29
 * @decription
 */
public class NetworkUtil {
    /**
     * 网络是否可用
     */
    public static boolean isNetworkAvailable(Context context){
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo network = cm.getActiveNetworkInfo();
            if(network != null && network.getState() == NetworkInfo.State.CONNECTED){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否有网络连接
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo network = mConnectivityManager
                    .getActiveNetworkInfo();
            if (network != null) {
                return network.isAvailable();
            }
        }
        return false;
    }
}
