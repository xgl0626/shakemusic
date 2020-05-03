package com.example.musicapp.prenster;

import com.example.musicapp.model.MyListModel;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class MyListPresenter implements MyListContract.MyListPresenter {
    private MyListContract.MyListModel model;
    private MyListContract.MyListPresenter instance;
    public MyListPresenter()
    {
        model=new MyListModel().getInstance();
    }
    public MyListContract.MyListPresenter getInstance() {
        instance=new MyListPresenter();
        return instance;
    }

    @Override
    public void getData(String address, Callback callback) {
        model.getData(address,callback);
    }
}
