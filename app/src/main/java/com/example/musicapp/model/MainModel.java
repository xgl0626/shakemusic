package com.example.musicapp.model;

import com.example.musicapp.Utils.OkHttpUtil;
import com.example.musicapp.prenster.MainContract;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class MainModel implements MainContract.MainModel {
    private MainModel instance=null;

    public MainModel getInstance() {
        instance=new MainModel();
        return instance;
    }

    @Override
    public void getData(String address, Callback callback) {
        try {
            OkHttpUtil.get(address,callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
