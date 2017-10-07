package com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol;

import android.drm.ProcessedData;
import android.util.Log;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.AppInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.HttpHelper;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.IOUtils;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.StringUtils;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 访问网络的基类
 * Created by Administrator on 2017\10\7 0007.
 */

public abstract class BaseProtocol<T> {
    //private String result;
    private  BufferedReader reader = null;
    private String line;
    private StringBuffer sb = new StringBuffer();

    public T getData(int index){
        String result=getCache(index);
        if(StringUtils.isEmpty(result)){//如果没有缓存或者失效
            result = getDataFromServer(index);
        }
        if(result!=null){
           T data =  parseData(result);
            return data;
        }
        return null;
    }
    //从网络获取数据
    //index表示从哪个位置开始返回20条数据，用于分页
    private String getDataFromServer(int index) {
       HttpHelper.HttpResult httpResult = HttpHelper.get(HttpHelper.URL+getKey()+"?index="+index+getParams());
        if(httpResult!=null){
            String result = httpResult.getString();
            System.out.println("访问结果+"+result);
            return result;
        }
        return null;
    }
//获取网络连接关键字
    public abstract String getKey() ;

    //获取网络连接参数
    public abstract String getParams();
    //Url为key,json为value
    public void setCache(int index,String json){
        //以url为文件名，以json为文件内容，保存在本地
        File cacheDir = UIUtils.getContext().getCacheDir();
        File cacheFile = new File(cacheDir,getKey()+"?index="+index+getParams());
        FileWriter writer = null;
        try {
             writer = new FileWriter(cacheFile);
            //缓存截止的时间
            long deadline = System.currentTimeMillis()+30*60*1000;
            writer.write(deadline+"\n");
            writer.write(json);//写入json
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.close(writer);
        }
    }
    public String getCache(int index){
        //以url为文件名，以json为文件内容，保存在本地
        File cacheDir = UIUtils.getContext().getCacheDir();
        File cacheFile = new File(cacheDir,getKey()+"?index="+index+getParams());
        //判断是否存在
        if(cacheFile.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(cacheFile));
              String deadline = reader.readLine();
                long deadtime =Long.parseLong(deadline);
                if(System.currentTimeMillis()<deadtime){
                    while ((line =reader.readLine())!=null){
                        sb.append(line);
                    }
                    return sb.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                IOUtils.close(reader);
            }
        }
        return null;
    }
//解析数据
    public abstract T parseData(String result);
}
