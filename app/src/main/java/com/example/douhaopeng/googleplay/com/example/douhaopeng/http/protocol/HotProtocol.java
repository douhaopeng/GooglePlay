package com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.AppInfo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017\10\8 0008.
 */

public class HotProtocol extends BaseProtocol<ArrayList<String>>{
    @Override
    public String getKey() {
        return "hot";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<String> parseData(String result) {
        try {
            JSONArray ja = new JSONArray(result);
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0;i<ja.length();i++){
                String keyWord =ja.getString(i);
                list.add(keyWord);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
