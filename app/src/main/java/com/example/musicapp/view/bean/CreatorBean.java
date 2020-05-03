package com.example.musicapp.view.bean;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class CreatorBean {
    /**
     * defaultAvatar : false
     * province : 530000
     * authStatus : 0
     * followed : false
     * avatarUrl : http://p1.music.126.net/ZvhjfEj-4G37DDCpW7A1mw==/109951164757778086.jpg
     * accountStatus : 0
     * gender : 2
     * city : 530100
     * birthday : -2209017600000
     * userId : 100589594
     * userType : 0
     * nickname : 谢闻鹏的小朋友
     * signature :
     * description :
     * detailDescription :
     * avatarImgId : 109951164757778080
     * backgroundImgId : 109951164757774340
     * backgroundUrl : http://p1.music.126.net/rpXY6aqSt9MynE6O2h4t9g==/109951164757774341.jpg
     * authority : 0
     * mutual : false
     * expertTags : null
     * experts : null
     * djStatus : 0
     * vipType : 0
     * remarkName : null
     * avatarImgIdStr : 109951164757778086
     * backgroundImgIdStr : 109951164757774341
     * avatarImgId_str : 109951164757778086
     */

    private String avatarUrl;
    private long userId;
    private String nickname;
    private long avatarImgId;
    private long backgroundImgId;
    private String backgroundUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public long getBackgroundImgId() {
        return backgroundImgId;
    }

    public void setBackgroundImgId(long backgroundImgId) {
        this.backgroundImgId = backgroundImgId;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
}
