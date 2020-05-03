package com.example.musicapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.view.bean.CreatorBean;
import com.example.musicapp.view.bean.SongSheetBean;
import com.example.musicapp.view.viewholder.SongSheetViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongSheetAdapter extends RecyclerView.Adapter {
    private List<SongSheetBean>list;
    private Context context;
    public SongSheetAdapter(Context context)
    {
        this.context=context;
        list=new ArrayList<>();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SongSheetViewHolder sheetViewHolder = new SongSheetViewHolder(inflater.inflate(R.layout.songsheet_item, parent, false), (ArrayList<SongSheetBean>)list);
        return sheetViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SongSheetViewHolder songSheetViewHolder= (SongSheetViewHolder) holder;
        ((SongSheetViewHolder) holder).updateData(list.get(position));
    }
    public void refreshList(ArrayList<SongSheetBean> sheetBeans) {
        list.clear();
        addList(sheetBeans);
    }
    public void addList(ArrayList<SongSheetBean> songSheetBeans) {
        list.addAll(songSheetBeans);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
