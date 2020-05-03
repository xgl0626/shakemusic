package com.example.musicapp.view.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.example.musicapp.R;
import com.example.musicapp.view.adapter.FragmentsAdapter;
import com.example.musicapp.view.fragments.MainFragment;
import com.example.musicapp.view.fragments.MyListFragment;
import com.example.musicapp.view.fragments.PersonFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private BottomNavigationView bottomNavigationView;
    private RelativeLayout player;
    private ViewPager viewpager;
    private FragmentsAdapter adapter;
    private ImageView iv_play;
    private ImageView iv_music_content;
    private TextView tv_music_name;
    private TextView tv_music_author;
    private AppCompatSeekBar seekBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
        setOnClickLister();
    }

    public void cancelActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    protected int setLayout() {
        return R.layout.activity_main;
    }

    protected void initView() {
        cancelActionBar();
        player=findViewById(R.id.divide_line);
        iv_music_content = findViewById(R.id.ig_music_content);
        iv_play = findViewById(R.id.iv_play);
        tv_music_author = findViewById(R.id.tv_music_author);
        tv_music_name = findViewById(R.id.tv_music_name);
        seekBar = findViewById(R.id.sk_music);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new MyListFragment());
        fragments.add(new PersonFragment());
        adapter = new FragmentsAdapter(fragments, getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        //BottomNavigationView 点击事件监听
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int menuId = menuItem.getItemId();
                // 跳转指定页面：Fragment
                switch (menuId) {
                    case R.id.tab_one:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.tab_two:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.tab_three:
                        viewpager.setCurrentItem(2);
                        player.setVisibility(View.GONE);
                        break;
                }
                return false;
            }
        });
        viewpager.addOnPageChangeListener((ViewPager.OnPageChangeListener) this);
    }

    public void setOnClickLister() {
        iv_play.setOnClickListener(this);
        iv_music_content.setOnClickListener(this);
    }

    protected void initData() {

    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==2)
            player.setVisibility(View.GONE);
        bottomNavigationView.getMenu().getItem(position).setChecked(true);
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

    }
}
