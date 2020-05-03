package com.example.musicapp.view.bean;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class SongListBean {

    /**
     * name : 夏天的风
     * id : 1436709403
     * pst : 0
     * t : 0
     * ar : [{"id":34522800,"name":"火羊瞌睡了","tns":[],"alias":[]}]
     * alia : ["原唱：温岚"]
     * pop : 100
     * st : 0
     * rt :
     * fee : 8
     * v : 17
     * crbt : null
     * cf :
     * al : {"id":87339204,"name":"夏天的风","picUrl":"http://p1.music.126.net/rFUKVdOjqxgwAT6Zi6qv7A==/109951164906689206.jpg","tns":[],"pic_str":"109951164906689206","pic":109951164906689200}
     * dt : 221750
     * h : {"br":320000,"fid":0,"size":8872365,"vd":-47450}
     * m : {"br":192000,"fid":0,"size":5323437,"vd":-44837}
     * l : {"br":128000,"fid":0,"size":3548973,"vd":-43103}
     * a : null
     * cd : 01
     * no : 1
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * djId : 0
     * copyright : 0
     * s_id : 0
     * mark : 0
     * originCoverType : 0
     * noCopyrightRcmd : null
     * mst : 9
     * cp : 0
     * mv : 0
     * rtype : 0
     * rurl : null
     * publishTime : 0
     */

    private String name;
    private long id;
    private CreatorBean creatorBean;
    private AlBean alBean;
    private ArBean arBean;

    public AlBean getAlBean() {
        return alBean;
    }

    public ArBean getArBean() {
        return arBean;
    }

    public void setAlBean(AlBean alBean) {
        this.alBean = alBean;
    }

    public void setArBean(ArBean arBean) {
        this.arBean = arBean;
    }

    public CreatorBean getCreatorBean() {
        return creatorBean;
    }

    public void setCreatorBean(CreatorBean creatorBean) {
        this.creatorBean = creatorBean;
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
