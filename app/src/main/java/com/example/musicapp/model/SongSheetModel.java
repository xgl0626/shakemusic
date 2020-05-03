package com.example.musicapp.model;

import com.example.musicapp.Utils.OkHttpUtil;
import com.example.musicapp.prenster.SongSheetContract;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongSheetModel implements SongSheetContract.SongSheetModel {
    private SongSheetContract.SongSheetModel instance=null;

    public SongSheetContract.SongSheetModel getInstance() {
        instance=new SongSheetModel();
        return instance;
    }

    @Override
    public void getData(String address, Callback callback) {
        OkHttpUtil.get(address,callback);
    }
}
