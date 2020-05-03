package com.example.musicapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.musicapp.R;
import com.example.musicapp.view.bean.BannerBean;
import com.example.musicapp.view.widget.banner.BannerPagerAdapter;

import java.util.List;

/**
 * @author 徐国林
 * @data 2020/4/9
 * @decription
 */
public class BannAdapter extends BannerPagerAdapter {
    private Context mContext;
    private List<BannerBean>data;
    public BannAdapter(Context context) {
        mContext = context;
    }
    @Override
    public void setData(List data) {
        super.setData(data);
        this.data = data;
    }


    @Override
    public View setView(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.banner_img, null);
        ImageView iv_bannerImg = v.findViewById(R.id.banner_img);
        Glide.with(v).load((data.get(position).getPicUrl())).into(iv_bannerImg);
        return v;
    }
}
