package com.example.musicapp.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.musicapp.R;
import com.example.musicapp.Utils.MyApplication;
import com.example.musicapp.base.BaseActivity;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class LoginActivity extends BaseActivity {
    private Button bt_login;
    private ImageView imageView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }

    @Override
    protected int setLayout() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {
        bt_login=findViewById(R.id.bt_login);
        imageView=findViewById(R.id.iv_img);
    }

    @Override
    protected void initData() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
