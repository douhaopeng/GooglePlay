package com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.AppInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 *
 * 首页的封装
 * Created by Administrator on 2017\10\7 0007.
 */

public class HomeProtocol extends BaseProtocol<ArrayList<AppInfo>> {
    @Override
    public String getKey() {
        return "home";
    }

    @Override
    public String getParams() {
        return "";
    }
//JsonObject解析方式 如果遇到{}就是JsonObject;如果遇到[],就是JsonArray
    @Override
    public ArrayList<AppInfo> parseData(String result) {
        try {
            JSONObject jo = new JSONObject(result);
           JSONArray ja =  jo.getJSONArray("list");
            ArrayList<AppInfo> appInfoList = new ArrayList<AppInfo>();
            for(int i=0;i<ja.length();i++){
               JSONObject jo1 = ja.getJSONObject(i);
                AppInfo info = new AppInfo();
                info.des = jo1.getString("des");
                info.downloadUrl = jo1.getString("downloadUrl");
                info.id = jo1.getString("id");
                info.name = jo1.getString("name");
                info.packageName = jo1.getString("packageName");
                info.size = jo1.getLong("size");
                info.stars = (float) jo1.getDouble("stars");
                appInfoList.add(info);
            }
            //初始化轮播条的数据
           JSONArray ja1 = jo.getJSONArray("pictrue");
            ArrayList<String> pictrues = new ArrayList<>();
            for(int i =0;i<ja.length();i++){
               String pic =  ja1.getString(i);
                pictrues.add(pic);
            }
            return appInfoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
