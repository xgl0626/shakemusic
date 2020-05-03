package com.example.musicapp.view.adapter;

import android.content.Context;
import android.icu.text.MessagePattern;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.Utils.ToastUtils;
import com.example.musicapp.prenster.SongSheetContract;
import com.example.musicapp.view.activity.SongSheetActivity;
import com.example.musicapp.view.bean.SongListBean;
import com.example.musicapp.view.bean.SongSheetBean;
import com.example.musicapp.view.viewholder.SongSheetContentViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongSheetContentAdapter extends RecyclerView.Adapter {
    private List<SongListBean>songListBeans;
    private Context context;
    private OnItemClickListener onItemClickListener;
    public SongSheetContentAdapter(Context context)
    {
        this.context=context;
        songListBeans=new ArrayList<>();
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener= listener;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        SongSheetContentViewHolder viewHolder=new SongSheetContentViewHolder(inflater.inflate(R.layout.song_item,parent,false), (ArrayList<SongListBean>) songListBeans,onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SongSheetContentViewHolder songSheetContentViewHolder= (SongSheetContentViewHolder) holder;
        ((SongSheetContentViewHolder) holder).updateData(songListBeans.get(position),position);
    }
    public void refreshSongList(ArrayList<SongListBean> songListBean) {
        songListBeans.clear();
        addSongList(songListBean);
    }
    public void addSongList(ArrayList<SongListBean> songListBean) {
        songListBeans.addAll(songListBean);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return songListBeans.size();
    }
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

}
