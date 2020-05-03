package com.example.musicapp.base;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 徐国林
 * @data 2020/3/30
 * @decription
 */
public interface BasePresenter<T> {
    void addView(T View);
    void destroyView();
}
