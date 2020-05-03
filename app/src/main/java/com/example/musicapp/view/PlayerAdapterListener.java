package com.example.musicapp.view;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public interface PlayerAdapterListener {
    void loadMedia(String musicUrl);
    void release();
    boolean isPlaying();
    void play();
    void reset();
    void pause();
    void mediaPreparedCompled();
    void seekTo(int position);
}
