package com.example.musicapp.view.bean;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class MyListBean {

    /**
     * subscribers : []
     * subscribed : false
     * creator : {"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/tc3Wk_XNPmwiR4hx9x-HnA==/18633423556612546.jpg","accountStatus":0,"gender":1,"city":440300,"birthday":768931200000,"userId":32953014,"userType":0,"nickname":"binaryify","signature":"深圳市爱猫人士","description":"","detailDescription":"","avatarImgId":18633423556612544,"backgroundImgId":109951163792144620,"backgroundUrl":"http://p1.music.126.net/WLTBvNL_l9ZKlslFwaCM9Q==/109951163792144631.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":11,"remarkName":null,"avatarImgIdStr":"18633423556612546","backgroundImgIdStr":"109951163792144631","avatarImgId_str":"18633423556612546"}
     * artists : null
     * tracks : null
     * updateFrequency : null
     * backgroundCoverId : 0
     * backgroundCoverUrl : null
     * titleImage : 0
     * titleImageUrl : null
     * englishTitle : null
     * opRecommend : false
     * recommendInfo : null
     * adType : 0
     * trackNumberUpdateTime : 1588235979316
     * subscribedCount : 3
     * cloudTrackCount : 0
     * createTime : 1407747901072
     * highQuality : false
     * userId : 32953014
     * coverImgId : 3396391419185092
     * updateTime : 1588235979316
     * newImported : false
     * anonimous : false
     * coverImgUrl : https://p2.music.126.net/LiXWeJQdgJ8gBJe454xe_w==/3396391419185092.jpg
     * specialType : 5
     * totalDuration : 0
     * trackCount : 853
     * commentThreadId : A_PL_0_24381616
     * privacy : 0
     * trackUpdateTime : 1588385856881
     * playCount : 12493
     * ordered : true
     * description : 描述
     * tags : ["学习"]
     * status : 0
     * name : binaryify喜欢的音乐
     * id : 24381616
     */

    private long userId;
    private String coverImgUrl;
    private String name;
    private long id;
    private Creator creator;

    public void setCreatorBean(CreatorBean creatorBean) {
        this.creator = creator;
    }

    public Creator getCreator() {
        return creator;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
