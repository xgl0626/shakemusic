package com.example.musicapp.prenster;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public interface MyListContract {
    interface MyListPresenter
    {
        void getData(String address, Callback callback);
    }
    interface MyListModel
    {
        void getData(String address, Callback callback);
    }
}
