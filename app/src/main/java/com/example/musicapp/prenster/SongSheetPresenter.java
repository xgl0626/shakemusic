package com.example.musicapp.prenster;

import android.content.Intent;
import android.view.View;

import com.example.musicapp.model.SongSheetModel;
import com.example.musicapp.view.activity.SongActivity;
import com.example.musicapp.view.activity.SongSheetActivity;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongSheetPresenter implements SongSheetContract.SongSheetPresenter {
    private SongSheetContract.SongSheetModel songSheetModel;
    private SongSheetContract.SongSheetPresenter instance=null;
    public SongSheetPresenter()
    {
        songSheetModel=new SongSheetModel().getInstance();
    }

    public SongSheetContract.SongSheetPresenter getInstance() {
        instance=new SongSheetPresenter();
        return instance;
    }

    @Override
    public void getData(String address, Callback callback) {
        songSheetModel.getData(address,callback);
    }
    public void clickItem(View view,String songName,long id)
    {
        Intent intent = new Intent(view.getContext(), SongActivity.class);
        intent.putExtra("songName", songName);
        intent.putExtra("id", id);
        view.getContext().startActivity(intent);
    }
}
