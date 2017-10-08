package com.example.douhaopeng.googleplay.com.example.douhaopeng.utils;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by Administrator on 2017\10\8 0008.
 */

public class BitmapHelper {
    private static BitmapUtils mBitmapUtils = null;
    //单例懒汉模式
    public static synchronized BitmapUtils getBitmapUtils(){
        if(mBitmapUtils == null){
            synchronized (BitmapHelper.class){
                if(mBitmapUtils==null){
                    mBitmapUtils = new BitmapUtils(UIUtils.getContext());
                }
            }
        }
        return mBitmapUtils;
    }
}
