package com.example.musicapp.prenster;

import android.view.View;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public interface SongSheetContract {
    interface SongSheetPresenter {
        void getData(String address, Callback callback);
        void clickItem(View view,String songName,long id);
    }
    interface SongSheetModel {
        void getData(String address, Callback callback);
    }
}
