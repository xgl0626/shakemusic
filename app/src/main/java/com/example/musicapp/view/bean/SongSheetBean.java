package com.example.musicapp.view.bean;

import java.util.List;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongSheetBean {

    /**
     * name : x
     * id : 2753126995
     * trackNumberUpdateTime : 1588334126420
     * status : 0
     * userId : 100589594
     * createTime : 1555124274960
     * updateTime : 1588334126420
     * subscribedCount : 0
     * trackCount : 92
     * cloudTrackCount : 0
     * coverImgUrl : http://p2.music.126.net/SVXAvVEUwQRhNZI4DSJICA==/109951163995170603.jpg
     * coverImgId : 109951163995170610
     * description : null
     * tags : []
     * playCount : 952
     * trackUpdateTime : 1588386603662
     * specialType : 0
     * totalDuration : 0
     * creator : {"defaultAvatar":false,"province":530000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/ZvhjfEj-4G37DDCpW7A1mw==/109951164757778086.jpg","accountStatus":0,"gender":2,"city":530100,"birthday":-2209017600000,"userId":100589594,"userType":0,"nickname":"谢闻鹏的小朋友","signature":"","description":"","detailDescription":"","avatarImgId":109951164757778080,"backgroundImgId":109951164757774340,"backgroundUrl":"http://p1.music.126.net/rpXY6aqSt9MynE6O2h4t9g==/109951164757774341.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164757778086","backgroundImgIdStr":"109951164757774341","avatarImgId_str":"109951164757778086"}
     * tracks : null
     * subscribers : []
     * subscribed : null
     * commentThreadId : A_PL_0_2753126995
     * newImported : false
     * adType : 0
     * highQuality : false
     * privacy : 0
     * ordered : false
     * anonimous : false
     * coverStatus : 3
     * recommendInfo : null
     * shareCount : 0
     * coverImgId_str : 109951163995170603
     * commentCount : 0
     */
    private String name;
    private long id;
    private String coverImgUrl;
    private CreatorBean creator;

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }
    public CreatorBean getCreator() {
        return creator;
    }
}
