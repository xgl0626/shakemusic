package com.example.musicapp.view.viewholder;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.prenster.SongSheetContract;
import com.example.musicapp.prenster.SongSheetPresenter;
import com.example.musicapp.view.MediaPlayerHolder;
import com.example.musicapp.view.PlaybackInfoListener;
import com.example.musicapp.view.activity.BannerContentActivity;
import com.example.musicapp.view.adapter.SongSheetContentAdapter;
import com.example.musicapp.view.bean.SongListBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.musicapp.Utils.Json.getElement;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongSheetContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private ImageView imageView;
    private TextView tv_song_count;
    private List<SongListBean>songListBeans;
    private TextView tv_song_name;
    private String count;
    private SongSheetContract.SongSheetPresenter songSheetPresenter;
    private SongSheetContentAdapter.OnItemClickListener onItemClickListener;
    public SongSheetContentViewHolder(@NonNull View itemView, ArrayList<SongListBean>songListBeans,SongSheetContentAdapter.OnItemClickListener onItemClickListener)
    {
        super(itemView);
        itemView.setOnClickListener(this::onClick);
        songSheetPresenter=new SongSheetPresenter().getInstance();
        this.onItemClickListener=onItemClickListener;
        this.songListBeans=songListBeans;
        imageView=itemView.findViewById(R.id.tv_song_time);
        tv_song_name=itemView.findViewById(R.id.tv_song_name);
        tv_song_count=itemView.findViewById(R.id.tv_song_count);
    }
    public void updateData(SongListBean songListBean,int position)
    {
        Log.d("tag",""+1);
        count=String.valueOf(position+1);
        tv_song_name.setText(songListBean.getName());
        tv_song_count.setText(count);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songSheetPresenter.clickItem(v,songListBean.getName(),songListBean.getId());
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener!= null){
            onItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
