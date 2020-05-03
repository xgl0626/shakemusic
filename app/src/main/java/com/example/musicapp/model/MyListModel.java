package com.example.musicapp.model;

import com.example.musicapp.Utils.OkHttpUtil;
import com.example.musicapp.prenster.MainContract;
import com.example.musicapp.prenster.MyListContract;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class MyListModel implements MyListContract.MyListModel {
    private MyListContract.MyListModel instance;

    public MyListContract.MyListModel getInstance() {
        instance=new MyListModel();
        return instance;
    }

    @Override
    public void getData(String address, Callback callback) {
        OkHttpUtil.get(address,callback);
    }
}
