package com.example.musicapp.prenster;

import android.view.View;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public interface MainContract {
    interface MainPresenter {
        void getData(String address,Callback callback);
        void clickBanner(View v, String url);
        void clickSongSheet(View v,long id,String url,String name,String author);
    }
    interface MainModel {
        void getData(String address, Callback callback);
    }
}

