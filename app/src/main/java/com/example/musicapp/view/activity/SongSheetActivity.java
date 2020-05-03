package com.example.musicapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicapp.R;
import com.example.musicapp.Utils.LogUtil;
import com.example.musicapp.Utils.MyApplication;
import com.example.musicapp.Utils.ToastUtils;
import com.example.musicapp.base.BaseActivity;
import com.example.musicapp.prenster.SongSheetContract;
import com.example.musicapp.prenster.SongSheetPresenter;
import com.example.musicapp.view.MediaPlayerHolder;
import com.example.musicapp.view.PlaybackInfoListener;
import com.example.musicapp.view.adapter.SongSheetContentAdapter;
import com.example.musicapp.view.bean.AlBean;
import com.example.musicapp.view.bean.BannerBean;
import com.example.musicapp.view.bean.SongBean;
import com.example.musicapp.view.bean.SongListBean;
import com.example.musicapp.view.bean.SongSheetBean;
import com.example.musicapp.view.viewholder.SongSheetContentViewHolder;
import com.example.musicapp.view.widget.banner.BannerPagerAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
public class SongSheetActivity extends BaseActivity implements PlaybackInfoListener {
    private Toolbar toolbar;
    private long songListId;
    private long songId;
    private String songSheetName;
    private String songbackUrl;
    private String songSheetAuthor;
    private ImageView iv_songsheet;
    private TextView tv_songsheet_name;
    private TextView tv_songsheet_author;
    private RecyclerView rv_songsheet;
    private String BASE = "http://47.99.165.194";
    String SONG_LISTS = "/playlist/detail?id=";
    final int S_LIST = 1;
    final String SONG = "/song/url?id=";
    final String isUse = "/check/music?id=";
    private SongSheetContentAdapter contentAdapter;
    private List<SongListBean> songListBeans;
    private List<AlBean> alBeans;
    private SongBean songBean;
    private SongSheetContract.SongSheetPresenter presenter;
    private MediaPlayerHolder mediaPlayerHolder;
    private List<String> musicUrl;
    private List<String> idList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        musicUrl = new ArrayList<>();
        idList = new ArrayList<>();
        mediaPlayerHolder = new MediaPlayerHolder();
        mediaPlayerHolder.setmPlaybackInfoListener(this);
        presenter = new SongSheetPresenter().getInstance();
        initView();
        initData();
    }

    public void initMusicUrl() {
        for (int i = 0; i < songListBeans.size(); i++) {
            presenter.getData(BASE + SONG + String.valueOf(songListBeans.get(i).getId()), new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String result = response.body().string();
                    try {
                        JSONArray data = new JSONObject(result).getJSONArray("data");
                        JSONObject js = data.getJSONObject(0);
                        String url = js.getString("url");
                        String id = js.getString("id");
                        musicUrl.add(url);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.songsheet_activity;
    }

    @Override
    protected void initView() {
        iv_songsheet = (ImageView) findViewById(R.id.iv_songsheet);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tv_songsheet_name = (TextView) findViewById(R.id.tv_songsheet_name);
        tv_songsheet_author = (TextView) findViewById(R.id.tv_songsheet_author);
        rv_songsheet = (RecyclerView) findViewById(R.id.rv_songlist);
    }

    @Override
    protected void initData() {
        songListBeans = new ArrayList<>();
        contentAdapter = new SongSheetContentAdapter(SongSheetActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SongSheetActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_songsheet.setLayoutManager(linearLayoutManager);
        rv_songsheet.setAdapter(contentAdapter);
        Intent intent = getIntent();
        songListId = intent.getLongExtra("id", 0);
        songSheetName = intent.getStringExtra("sheetName");
        songSheetAuthor = intent.getStringExtra("sheetAuthor");
        songbackUrl = intent.getStringExtra("url");
        presenter.getData(BASE + SONG_LISTS + String.valueOf(songListId), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String results = response.body().string();
                String firstData = getElement(results, "playlist");
                String data = getElement(firstData, "tracks");
                Gson gson = new Gson();
                LogUtil.d(data);
                songListBeans = gson.fromJson(data, new TypeToken<List<SongListBean>>() {
                }.getType());
                sendMsg(S_LIST);
                response.body().close();
                initMusicUrl();
            }
        });
        contentAdapter.setOnItemClickListener(new SongSheetContentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                    mediaPlayerHolder.loadMedia(musicUrl.get(position));
            }
        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                tv_songsheet_author.setText(songSheetAuthor);
                tv_songsheet_name.setText(songSheetName);
                if (songbackUrl == null)
                    iv_songsheet.setImageResource(R.mipmap.ic_launcher);
                else
                    Glide.with(MyApplication.getContext()).load(songbackUrl).into(iv_songsheet);
                LogUtil.d(songListBeans.toString());
                contentAdapter.refreshSongList((ArrayList<SongListBean>) songListBeans);
            }
        }
    };

    public void sendMsg(int index) {
        Message message = new Message();
        message.what = index;
        handler.sendMessage(message);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_menu, menu);
        return true;
    }

    //总时长
    @Override
    public void onDurationChanged(int duration) {

    }

    //当前时长进度
    @Override
    public void onPositionChanged(int position) {

    }

    //记录当前的状态
    @Override
    public void onStateChanged(int state) {
        switch (state) {
            case 4:
                mediaPlayerHolder.play();
                break;
            default:
                break;
        }
    }

    //播放完成回调
    @Override
    public void onPlaybackCompleted() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        musicUrl.clear();
        idList.clear();
    }
}
