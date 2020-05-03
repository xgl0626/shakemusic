package com.example.musicapp.view.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.Utils.MyApplication;
import com.example.musicapp.base.BaseFragment;
import com.example.musicapp.prenster.MyListContract;
import com.example.musicapp.prenster.MyListPresenter;
import com.example.musicapp.view.bean.MyListBean;
import com.example.musicapp.view.bean.PersonBean;
import com.example.musicapp.view.bean.SongSheetBean;
import com.example.musicapp.view.widget.banner.BannerPagerAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.musicapp.Utils.Json.getElement;

public class PersonFragment extends BaseFragment {
    final String PERSON="http://47.99.165.194/user/detail?uid=32953014";
    private TextView tv_follower;
    private TextView tv_following;
    private TextView tv_post;
    private TextView tv_personName;
    private TextView tv_personAddress;
    private ImageView iv_personImg;
    private Button bt_one;
    private Button bt_three;
    private Button bt_two;
    final int UPDATE=0;
    private View mView;
    private MyListContract.MyListPresenter myListPresenter;
    private PersonBean personBean;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView=inflater.inflate(R.layout.person_fragment, container, false);
        myListPresenter=new MyListPresenter().getInstance();
        initView();
        initData();
        return mView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected int setLayout() {
        return R.layout.person_fragment;
    }

    @Override
    protected void initView() {
        bt_one=mView.findViewById(R.id.bt_one);
        bt_two=mView.findViewById(R.id.bt_two);
        bt_three=mView.findViewById(R.id.bt_three);
        Drawable drawable1 = getResources().getDrawable(R.mipmap.like);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.ok);
        Drawable drawable3 = getResources().getDrawable(R.mipmap.message);
        drawable3.setBounds(0, 0, 80, 80);
        drawable2.setBounds(0, 0, 80, 80);
        drawable1.setBounds(0, 0, 80, 80);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        bt_one.setCompoundDrawables(null, drawable1, null, null);//只放左边
        bt_two.setCompoundDrawables(null, drawable2, null, null);
        bt_three.setCompoundDrawables(null, drawable3, null, null);
        tv_follower= mView.findViewById(R.id.tv_follower);
        tv_following=mView.findViewById(R.id.tv_following);
        tv_personAddress= mView.findViewById(R.id.tv_personaddress);
        tv_personName=mView.findViewById(R.id.tv_personname);
        tv_post=mView.findViewById(R.id.tv_post);
        iv_personImg= mView.findViewById(R.id.iv_personimg);
    }

    @Override
    protected void initData() {
        myListPresenter.getData(PERSON, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String results=response.body().string();
                String data=getElement(results, "profile");
                LogUtil.d(data);
                Gson gson = new Gson();
                personBean = gson.fromJson(data, new TypeToken<PersonBean>() {
                }.getType());
                sendMsg(UPDATE);
            }
        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0)
            {
                tv_follower.setText(String.valueOf(personBean.getFolloweds()));
                tv_following.setText(String.valueOf(personBean.getFollows()));
                tv_post.setText(String.valueOf(personBean.getEventCount()));
                tv_personAddress.setText(String.valueOf(personBean.getProvince()));
                tv_personName.setText(personBean.getNickname());
                Glide.with(MyApplication.getContext()).load(personBean.getAvatarUrl()).into(iv_personImg);
            }
        }
    };
    public void sendMsg(int index) {
        Message message = new Message();
        message.what = index;
        handler.sendMessage(message);
    }
}
