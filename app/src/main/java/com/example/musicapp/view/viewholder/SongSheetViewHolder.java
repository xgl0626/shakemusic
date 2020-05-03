package com.example.musicapp.view.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicapp.R;
import com.example.musicapp.Utils.MyApplication;
import com.example.musicapp.prenster.MainContract;
import com.example.musicapp.prenster.MainPresenter;
import com.example.musicapp.view.MediaPlayerHolder;
import com.example.musicapp.view.activity.BannerContentActivity;
import com.example.musicapp.view.activity.MainActivity;
import com.example.musicapp.view.activity.SongSheetActivity;
import com.example.musicapp.view.bean.CreatorBean;
import com.example.musicapp.view.bean.SongSheetBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongSheetViewHolder extends RecyclerView.ViewHolder{
    private ImageView iv_songSheet;
    private TextView tv_songSheetName;
    private TextView tv_songSheetAuthor;
    private RelativeLayout relativeLayout;
    private List<SongSheetBean>songSheetBeans;
    private MainContract.MainPresenter mainPresenter;
    public SongSheetViewHolder(@NonNull View itemView, ArrayList<SongSheetBean>songSheetBeans) {
        super(itemView);
        mainPresenter=new MainPresenter().getInstance();
        iv_songSheet=itemView.findViewById(R.id.musiclist_item);
        tv_songSheetAuthor=itemView.findViewById(R.id.list_author);
        tv_songSheetName=itemView.findViewById(R.id.list_name);
        relativeLayout=itemView.findViewById(R.id.rl_songsheet);
        this.songSheetBeans=songSheetBeans;
    }
    public void updateData(SongSheetBean songSheetBean)
    {
        tv_songSheetName.setText(songSheetBean.getName());
        tv_songSheetAuthor.setText(songSheetBean.getCreator().getNickname());
        Glide.with(itemView).load(songSheetBean.getCoverImgUrl()).into(iv_songSheet);
        OnClick(songSheetBean);
    }
    public void OnClick(SongSheetBean songSheetBean)
    {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.clickSongSheet(v,songSheetBean.getId(),songSheetBean.getCreator().getBackgroundUrl(),songSheetBean.getName(),songSheetBean.getCreator().getNickname());
            }
        });
    }
}
