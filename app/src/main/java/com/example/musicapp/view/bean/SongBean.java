package com.example.musicapp.view.bean;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongBean {
    /**
     * id : 1436709403
     * url : http://m701.music.126.net/20200502151912/822a54ad3b8427b1cd2fd45f93a96541/jdymusic/obj/w5zDlMODwrDDiGjCn8Ky/2180586519/98b2/4d51/b6d3/c8c65de6a0bf053a2cd94d1f9473d069.mp3
     * br : 128000
     * size : 3548973
     * md5 : c8c65de6a0bf053a2cd94d1f9473d069
     * code : 200
     * expi : 1200
     * type : mp3
     * gain : 0
     * fee : 8
     * uf : null
     * payed : 0
     * flag : 64
     * canExtend : false
     * freeTrialInfo : null
     * level : standard
     * encodeType : mp3
     */

    private int id;
    private String url;
    private int br;
    private int size;
    private String md5;
    private int code;
    private int expi;
    private String type;
    private int gain;
    private int fee;
    private Object uf;
    private int payed;
    private int flag;
    private boolean canExtend;
    private Object freeTrialInfo;
    private String level;
    private String encodeType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getBr() {
        return br;
    }

    public void setBr(int br) {
        this.br = br;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getExpi() {
        return expi;
    }

    public void setExpi(int expi) {
        this.expi = expi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Object getUf() {
        return uf;
    }

    public void setUf(Object uf) {
        this.uf = uf;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public boolean isCanExtend() {
        return canExtend;
    }

    public void setCanExtend(boolean canExtend) {
        this.canExtend = canExtend;
    }

    public Object getFreeTrialInfo() {
        return freeTrialInfo;
    }

    public void setFreeTrialInfo(Object freeTrialInfo) {
        this.freeTrialInfo = freeTrialInfo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEncodeType() {
        return encodeType;
    }

    public void setEncodeType(String encodeType) {
        this.encodeType = encodeType;
    }
}
