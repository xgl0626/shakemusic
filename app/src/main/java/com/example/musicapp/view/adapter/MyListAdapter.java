package com.example.musicapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.view.bean.MyListBean;
import com.example.musicapp.view.bean.SongSheetBean;
import com.example.musicapp.view.viewholder.MySheetListViewHolder;
import com.example.musicapp.view.viewholder.SongSheetViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class MyListAdapter extends RecyclerView.Adapter {
    private List<MyListBean>myListBeans;
    private Context context;
    public MyListAdapter(Context context)
    {
        this.context=context;
        myListBeans=new ArrayList<>();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MySheetListViewHolder viewHolder = new MySheetListViewHolder(inflater.inflate(R.layout.mysheet_item, parent, false), (ArrayList<MyListBean>)myListBeans);
        return viewHolder;
}

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MySheetListViewHolder viewHolder= (MySheetListViewHolder) holder;
        ((MySheetListViewHolder) holder).updateData(myListBeans.get(position));
    }

    public void refreshList(ArrayList<MyListBean> myListBean) {
        myListBeans.clear();
        addList(myListBean);
    }
    public void addList(ArrayList<MyListBean> myListBeanArrayList) {
        myListBeans.addAll(myListBeanArrayList);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return myListBeans.size();
    }
}
