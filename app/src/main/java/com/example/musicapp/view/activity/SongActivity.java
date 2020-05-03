package com.example.musicapp.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.Toolbar;

import com.example.musicapp.R;
import com.example.musicapp.base.BaseActivity;
import com.example.musicapp.view.MediaPlayerHolder;
import com.example.musicapp.view.PlaybackInfoListener;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongActivity extends BaseActivity implements OnClickListener, PlaybackInfoListener {
    private TextView tv_startTime;
    private TextView tv_endTime;
    private Button bt_start;
    private Button bt_end;
    private Button bt_music;
    private ImageView iv_music;
    private ImageView repeat;
    private ImageView shaffle;
    private Toolbar toolbar;
    private AppCompatSeekBar seekBar;
    private MediaPlayerHolder mediaPlayerHolder;
    private int time;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }

    @Override
    protected int setLayout() {
        return R.layout.song_activity;
    }

    @Override
    protected void initView() {
        mediaPlayerHolder=new MediaPlayerHolder();
        tv_startTime= (TextView) bindView(R.id.tv_starttime);
        tv_endTime=(TextView)bindView(R.id.tv_endtime);
        iv_music= (ImageView) bindView(R.id.iv_music);
        bt_end= (Button) bindView(R.id.ib_end);
        bt_start= (Button) bindView(R.id.ib_start);
        toolbar= (Toolbar) bindView(R.id.toolbar);
        setSupportActionBar(toolbar);
        repeat= (ImageView) bindView(R.id.repeat);
        shaffle= (ImageView) bindView(R.id.shaffle);
        seekBar= (AppCompatSeekBar) bindView(R.id.sk_music);
        bt_music= (Button) bindView(R.id.ib_play);
        bt_end.setOnClickListener(this);
        bt_music.setOnClickListener(this);
        bt_start.setOnClickListener(this);
        repeat.setOnClickListener(this);
        repeat.setOnClickListener(this);
    }

    @Override
    protected void initData() {

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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ib_play:
        }
    }
    //总时长
    @Override
    public void onDurationChanged(int duration) {
        time=duration;
        tv_startTime.setText("0:00");
        tv_endTime.setText(String.valueOf(duration));
    }
    //当前时长进度
    @Override
    public void onPositionChanged(int position) {

           seekBar.setProgress(position);
    }
    //记录当前的状态
    @Override
    public void onStateChanged(int state) {

    }
    //播放完成回调
    @Override
    public void onPlaybackCompleted() {

    }
}
