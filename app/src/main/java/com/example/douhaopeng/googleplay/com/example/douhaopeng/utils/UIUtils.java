package com.example.douhaopeng.googleplay.com.example.douhaopeng.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.global.GooglePlayApplication;

/**
 * Created by Administrator on 2017\10\5 0005.
 */

public class UIUtils {
    public static Context getContext(){
        return GooglePlayApplication.getContext();
    }
    public static Handler getHandler(){
        return GooglePlayApplication.getmHandler();
    }
    public static int getMainThreadId(){
        return GooglePlayApplication.getMainThreradId();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //获取字符串
    public static String getString(int id){
        return  getContext().getResources().getString(id);
    }
    //获取字符串数组
    public static String[] getStringArray(int id){
        return getContext().getResources().getStringArray(id);
    }
    //加载图片
    public static Drawable getDrawable(int id){
        return  getContext().getResources().getDrawable(id);
    }
    //获取颜色
    public static int getColor(int id){
        return  getContext().getResources().getColor(id);
    }
    /**
     * 获取颜色状态集合
     */
    public static ColorStateList getColorStateList(int id) {
        return getContext().getResources().getColorStateList(id);
    }

    //获取尺寸
    public static int getDimen(int id){
        return getContext().getResources().getDimensionPixelSize(id);//返回具体像素值
    }

    /////////////////////dip 和 px 转换/////////////////////////////////////////////////////////////////////////////

    public static int dip2px(float dip){
       float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip*density+0.5f);
    }

    public static int px2dip(int px){
        float desity = getContext().getResources().getDisplayMetrics().density;
        return (int) (px/desity);
    }

    ////////////////////////加载布局文件/////////////////////////////////////
    public static View inflate(int id){
       return View.inflate(getContext(),id,null);
    }
    //判断项目是否在主线程中
    public static boolean isRunOnUIThread(){
       int myTid =  android.os.Process.myTid();
        if(myTid == getMainThreadId()){
            return  true;
        }
        return false;
    }

    public static void runOnUIThread(Runnable r){
        if(isRunOnUIThread()){
            r.run();
        }else{
            //如果是子线程借助handler让其运行在主线程
            getHandler().post(r);
        }
    }
}
