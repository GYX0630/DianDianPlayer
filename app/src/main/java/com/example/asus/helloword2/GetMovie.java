package com.example.asus.helloword2;

import java.io.Serializable;

public class GetMovie implements Serializable {

    private static MovieLab instance = null;
    private String movie;
    private String url;
    private String list;
    private String iconurl;
    private String qingxi;



    public int getSize() {
        return Integer.parseInt(null);
    }
    public void setMovie(String movie){
        this.movie=movie;
    }
    public String getMovie() {
        return movie;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getUrl() {
        return url;
    }
    public void setIconurl(String iconurl){
        this.iconurl=iconurl;
    }
    public String getIconUrl(){
        return iconurl;
    }
    public void setQingxi(String qingxi){
        this.qingxi = qingxi;
    }
    public String getqiangxi(){
        return qingxi;
    }

}
