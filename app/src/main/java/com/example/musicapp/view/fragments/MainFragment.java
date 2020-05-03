package com.example.musicapp.view.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.base.BaseFragment;
import com.example.musicapp.prenster.MainContract;
import com.example.musicapp.prenster.MainPresenter;
import com.example.musicapp.view.adapter.BannAdapter;
import com.example.musicapp.view.adapter.SongSheetAdapter;
import com.example.musicapp.view.bean.BannerBean;
import com.example.musicapp.view.bean.CreatorBean;
import com.example.musicapp.view.bean.SongSheetBean;
import com.example.musicapp.view.widget.banner.Banner;
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

public class MainFragment extends BaseFragment {
    private View mView;
    private Toolbar toolbar;
    private Banner banner;
    private BannAdapter adapter;
    private List<BannerBean> bannerBeans;
    private MainContract.MainPresenter mainPresenter;
    private RecyclerView recyclerView;
    private List<SongSheetBean>songSheetBeans;
    private SongSheetAdapter songSheetAdapter;
    private final int BANNER_MSG=2;
    private final int SONG=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(setLayout(), container, false);
        mainPresenter=new MainPresenter().getInstance();
        initView();
        initData();
        return mView;
    }
    @Override
    protected int setLayout() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) mView.findViewById(R.id.toolbar);
        banner=mView.findViewById(R.id.banner);
        recyclerView=mView.findViewById(R.id.rv_main);
    }
    @Override
    protected void initData() {
        initBanner();
        initSongSheet();
    }

    protected void initSongSheet() {
        songSheetBeans=new ArrayList<>();
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        songSheetAdapter=new SongSheetAdapter(this.getActivity());
        recyclerView.setAdapter(songSheetAdapter);
        final String SONGSHEET="http://47.99.165.194/top/playlist?limit=10&order=new";
        mainPresenter.getData(SONGSHEET, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                String sheetData = getElement(result, "playlists");
                LogUtil.d(sheetData);
                Gson gson = new Gson();
                songSheetBeans = gson.fromJson(sheetData, new TypeToken<List<SongSheetBean>>() {
                }.getType());
                sendMsg(SONG);
            }
        });
    }

    protected void initBanner() {
        bannerBeans=new ArrayList<>();
        adapter = new BannAdapter(this.getActivity());
        final String BANNER_LISTS="http://47.99.165.194/album/newest";
        mainPresenter.getData(BANNER_LISTS, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bannerData = response.body().string();
                String data = getElement(bannerData, "albums");
                Gson gson = new Gson();
                bannerBeans = gson.fromJson(data, new TypeToken<List<BannerBean>>() {
                }.getType());
                sendMsg(BANNER_MSG);
            }
        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1)
            {
                songSheetAdapter.refreshList((ArrayList<SongSheetBean>) songSheetBeans);
            }
            else if(msg.what==2) {
                adapter.setData(bannerBeans);
                banner.setDot(R.drawable.no_selected_dot, R.drawable.selected_dot);
                banner.setAdapter(adapter);
                banner.setOnItemClickListener(new BannerPagerAdapter.onItemClickListener() {
                    @Override
                    public void onClick(int position) {
                    }
                }).startAutoPlay();
            }
        }
    };
    public void sendMsg(int index) {
        Message message = new Message();
        message.what = index;
        handler.sendMessage(message);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
