package com.example.asus.helloword2;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2019/5/7.
 */

public class MovieLab {
//    private String movie;
//    private String url;
//    private String list;
//    private String iconurl;

    private Context context;

    public MovieLab(Context ctx) {
        context = ctx;
    }



//    public static MovieLab get() {
//        if (null == instance) {
//            instance = new MovieLab();
//        }
//        return instance;
//
//    }

//    public int getSize() {
//        return Integer.parseInt(null);
//    }
//    public void setMovie(String movie){
//        this.movie=movie;
//    }
//    public String getMovie() {
//        return movie;
//    }
//    public void setUrl(String url){
//        this.url=url;
//    }
//    public String getUrl() {
//        return url;
//    }
//    public void setIconurl(String iconurl){
//        this.iconurl=iconurl;
//    }
//    public String getIconUrl(){
//        return iconurl;
//    }

    private void chaifen() {
        int n = 0;

//        for (String i : list) {
//            String[] tmp = i.split(",");
//            movie.add(tmp[0]);
//            url.add(tmp[1]);
//            iconurl.add(tmp[2]);
//        }

    }

    private void init() {
//        movie = new ArrayList<>();
//        url = new ArrayList<>();
//        list = new ArrayList<>();
//        iconurl = new ArrayList<>();
//        list.add("CCTV1,http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-1_180817.png");
//        list.add("CCTV2,http://ivi.bupt.edu.cn/hls/cctv2.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-2_180817.png");
//        list.add("CCTV3,http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-3_180817.png");
//        list.add("CCTV4,http://ivi.bupt.edu.cn/hls/cctv4.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-4_180817.png");
//        list.add("CCTV6,http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-6_180817.png");
//        list.add("CCTV7,http://ivi.bupt.edu.cn/hls/cctv7.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-7_180817.png");
//        list.add("CCTV8,http://ivi.bupt.edu.cn/hls/cctv8hd.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-8_180817.png");
//        list.add("CCTV9,http://ivi.bupt.edu.cn/hls/cctv9.m3u8,http://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1532314258547503/cctv-9_180817.png");
//        list.add("四川妇女,http://scgctvshow.sctv.com/hdlive/sctv7/3.m3u8");
//        list.add("四川公共,http://scgctvshow.sctv.com/sdlive/sctv9/3.m3u8");

//        CCTV4,http://223.110.245.165/ott.js.chinamobile.com/PLTV/3/224/3221225534/index.m3u8
//        CCTV4,http://223.110.245.159/ott.js.chinamobile.com/PLTV/3/224/3221225781/index.m3u8
//        CCTV4,http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221225534/index.m3u8
//        CCTV4FHD,http://223.110.245.163/ott.js.chinamobile.com/PLTV/3/224/3221227378/index.m3u8

//        list.add("");

        chaifen();
    }

    public String loadJSONFromAsset(String filename){
        String json = null;

      try {
          InputStream is = context.getAssets().open(filename);
          int size = is.available();
          byte[] buffer = new byte[size];
          is.read(buffer);
          is.close();
          json = new String(buffer, "UTF-8");

      } catch (IOException e) {
          Log.e("FFPLAY", e.getMessage());
          e.printStackTrace();
      }
        return json;
    }


    public List<GetMovie> getChannels(String filename) {
        List<GetMovie> result = new ArrayList<>();
        String json = loadJSONFromAsset(filename);
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray data =obj.getJSONArray("data");
            for(int i= 0 ; i < data.length();i++){
                GetMovie c= new GetMovie();
                JSONObject item = data.getJSONObject(i);
                c.setMovie(item.getString("title"));
                c.setUrl(item.getString("url"));
                c.setIconurl(item.getString("iconurl"));
                c.setQingxi(item.getString("quality"));
                result.add(c);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

}

