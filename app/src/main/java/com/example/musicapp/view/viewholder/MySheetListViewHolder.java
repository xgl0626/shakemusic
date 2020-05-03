package com.example.musicapp.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.prenster.MainContract;
import com.example.musicapp.prenster.MainPresenter;
import com.example.musicapp.prenster.MyListContract;
import com.example.musicapp.view.bean.MyListBean;
import com.example.musicapp.view.widget.banner.RoundImageView;

import java.util.ArrayList;
import java.util.List;

import static com.example.musicapp.R.id.tv_mysheet_name;
import static com.example.musicapp.R.id.tv_songsheet_name;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class MySheetListViewHolder extends RecyclerView.ViewHolder {
    private ImageView iv_mysheet;
    private TextView tv_songsheet_name;
    private TextView tv_songsheet_author;
    private ImageView iv_play;
    private ImageView iv_content;
    private List<MyListBean> myListBeans;
    private MainContract.MainPresenter mainPresenter;
    private RelativeLayout rl_item;
    public MySheetListViewHolder(@NonNull View itemView, ArrayList<MyListBean> myListBeans) {
        super(itemView);
        rl_item=itemView.findViewById(R.id.rl_mylist);
        mainPresenter=new MainPresenter().getInstance();
        iv_mysheet=itemView.findViewById(R.id.iv_mysheet);
        iv_content=itemView.findViewById(R.id.iv_content);
        iv_play=itemView.findViewById(R.id.iv_play);
        tv_songsheet_author=itemView.findViewById(R.id.tv_mysheet_author);
        tv_songsheet_name=itemView.findViewById(tv_mysheet_name);
        this.myListBeans=myListBeans;

    }
    public void updateData(MyListBean myListBean)
    {
        Glide.with(itemView).load(myListBean.getCoverImgUrl()).into(iv_mysheet);
        tv_songsheet_name.setText(myListBean.getName());
        tv_songsheet_author.setText(myListBean.getCreator().getNickname());
        rl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.clickSongSheet(v,myListBean.getId(),myListBean.getCoverImgUrl(),myListBean.getName(),myListBean.getCreator().getNickname());
            }
        });
    }
}
