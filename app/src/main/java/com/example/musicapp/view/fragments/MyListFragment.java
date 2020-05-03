package com.example.musicapp.view.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.base.BaseFragment;
import com.example.musicapp.prenster.MyListContract;
import com.example.musicapp.prenster.MyListPresenter;
import com.example.musicapp.view.activity.SongSheetActivity;
import com.example.musicapp.view.adapter.MyListAdapter;
import com.example.musicapp.view.bean.MyListBean;
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

import static android.os.Build.VERSION_CODES.BASE;
import static com.example.musicapp.Utils.Json.getElement;

/**
 * @author 徐国林
 * @data 2020/5/1
 * @decription
 */
public class MyListFragment extends BaseFragment {
    private View mView;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private MyListAdapter myListAdapter;
    private MyListContract.MyListPresenter myListPresenter;
    private String MY_LIST="http://47.99.165.194/user/playlist?uid=32953014";
    final int MSG=1;
    private List<MyListBean> myListBeans;
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.mylist_fragment, container, false);
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
        return R.layout.mylist_fragment;
    }

    @Override
    protected void initView() {
        toolbar=mView.findViewById(R.id.toolbar);
        recyclerView=mView.findViewById(R.id.rv_mylist);

    }

    @Override
    protected void initData() {
        myListBeans=new ArrayList<>();
        myListAdapter=new MyListAdapter(this.getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myListAdapter);

        myListPresenter.getData( MY_LIST, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                String sheetData = getElement(result, "playlist");
                LogUtil.d(sheetData);
                Gson gson = new Gson();
                myListBeans = gson.fromJson(sheetData, new TypeToken<List<MyListBean>>() {
                }.getType());
                sendMsg(MSG);
            }
        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1)
            {
                myListAdapter.refreshList((ArrayList<MyListBean>) myListBeans);
            }
        }
    };
    public void sendMsg(int index) {
        Message message = new Message();
        message.what = index;
        handler.sendMessage(message);
    }
}
