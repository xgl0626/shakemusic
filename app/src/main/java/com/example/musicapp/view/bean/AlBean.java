package com.example.musicapp.view.bean;

import java.util.List;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class AlBean {

    /**
     * id : 87339204
     * name : 夏天的风
     * picUrl : http://p1.music.126.net/rFUKVdOjqxgwAT6Zi6qv7A==/109951164906689206.jpg
     * tns : []
     * pic_str : 109951164906689206
     * pic : 109951164906689200
     */

    private int id;
    private String name;
    private String picUrl;
    private String pic_str;
    private long pic;
    private List<?> tns;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPic_str() {
        return pic_str;
    }

    public void setPic_str(String pic_str) {
        this.pic_str = pic_str;
    }

    public long getPic() {
        return pic;
    }

    public void setPic(long pic) {
        this.pic = pic;
    }

    public List<?> getTns() {
        return tns;
    }

    public void setTns(List<?> tns) {
        this.tns = tns;
    }
}
