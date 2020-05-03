package com.example.musicapp.view.bean;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class PersonBean {
    /**
     * avatarImgIdStr : 18633423556612546
     * backgroundImgIdStr : 109951163792144631
     * description :
     * userId : 32953014
     * createTime : 1407747900967
     * nickname : binaryify
     * djStatus : 0
     * accountStatus : 0
     * province : 440000
     * vipType : 11
     * followed : false
     * remarkName : null
     * mutual : false
     * avatarImgId : 18633423556612544
     * birthday : 768931200000
     * gender : 1
     * userType : 0
     * avatarUrl : http://p1.music.126.net/tc3Wk_XNPmwiR4hx9x-HnA==/18633423556612546.jpg
     * authStatus : 0
     * detailDescription :
     * experts : {}
     * expertTags : null
     * city : 440300
     * defaultAvatar : false
     * backgroundImgId : 109951163792144620
     * backgroundUrl : http://p1.music.126.net/WLTBvNL_l9ZKlslFwaCM9Q==/109951163792144631.jpg
     * signature : 深圳市爱猫人士
     * authority : 0
     * followeds : 22
     * follows : 9
     * blacklist : false
     * eventCount : 18
     * allSubscribedCount : 0
     * playlistBeSubscribedCount : 3
     * avatarImgId_str : 18633423556612546
     * followTime : null
     * followMe : false
     * artistIdentity : []
     * cCount : 0
     * sDJPCount : 0
     * playlistCount : 17
     * sCount : 0
     * newFollows : 9
     */

    private String nickname;
    private int province;
    private String avatarUrl;
    private int city;
    private String backgroundUrl;
    private String signature;
    private int followeds;
    private int follows;
    private int eventCount;

    public int getCity() {
        return city;
    }

    public int getEventCount() {
        return eventCount;
    }

    public int getFolloweds() {
        return followeds;
    }

    public int getFollows() {
        return follows;
    }

    public int getProvince() {
        return province;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public void setFolloweds(int followeds) {
        this.followeds = followeds;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
