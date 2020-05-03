package com.example.musicapp.view.bean;

/**
 * @author 徐国林
 * @data 2020/5/2
 * @decription
 */
public class BannerBean {


    /**
     * name : 暗示
     * id : 88627345
     * type : EP/Single
     * size : 2
     * picId : 109951164943562860
     * blurPicUrl : http://p3.music.126.net/1UWVS742R3IBkoY1UsQZhw==/109951164943562862.jpg
     * companyId : 0
     * pic : 109951164943562860
     * picUrl : http://p4.music.126.net/1UWVS742R3IBkoY1UsQZhw==/109951164943562862.jpg
     * publishTime : 1588089600000
     * description :
     * tags :
     * company : 网易云音乐
     * briefDesc :
     * artist : {"name":"周深","id":1030001,"picId":109951164854660830,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p3.music.126.net/u7I488Oi44qH4mqQuqFnqA==/109951164854660837.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":64,"alias":[],"trans":"","musicSize":263,"topicPerson":0,"picId_str":"109951164854660837","img1v1Id_str":"18686200114669622"}
     * songs : null
     * alias : []
     * status : 0
     * copyrightId : 1416778
     * commentThreadId : R_AL_3_88627345
     * artists : [{"name":"周深","id":1030001,"picId":0,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}]
     * paid : false
     * onSale : false
     * picId_str : 109951164943562862
     */

    private int id;
    private String blurPicUrl;
    private String picUrl;

    public int getId() {
        return id;
    }

    public String getBlurPicUrl() {
        return blurPicUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setBlurPicUrl(String blurPicUrl) {
        this.blurPicUrl = blurPicUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
