package com.example.musicapp.prenster;

import android.content.Intent;
import android.view.View;

import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.base.BaseActivity;
import com.example.musicapp.model.MainModel;
import com.example.musicapp.view.activity.BannerContentActivity;
import com.example.musicapp.view.activity.SongSheetActivity;

import okhttp3.Callback;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class MainPresenter implements MainContract.MainPresenter {
    private MainContract.MainModel mainModel;
    private MainPresenter instance = null;

    public MainPresenter getInstance() {
        instance = new MainPresenter();
        return instance;
    }

    public MainPresenter() {
        mainModel = new MainModel().getInstance();
    }

    @Override
    public void getData(String address, Callback callback) {
        mainModel.getData(address, callback);
    }

    @Override
    public void clickBanner(View view, String msg) {
        Intent intent = new Intent(view.getContext(), BannerContentActivity.class);
        intent.putExtra("url", msg);
        view.getContext().startActivity(intent);
    }
    @Override
    public void clickSongSheet(View view, long id,String uri,String name,String author) {
        Intent intent = new Intent(view.getContext(), SongSheetActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("url", uri);
        intent.putExtra("sheetName",name);
        intent.putExtra("sheetAuthor",author);
        view.getContext().startActivity(intent);
    }
}
