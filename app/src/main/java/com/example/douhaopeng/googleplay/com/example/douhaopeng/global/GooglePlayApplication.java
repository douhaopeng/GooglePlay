package com.example.douhaopeng.googleplay.com.example.douhaopeng.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2017\10\5 0005.
 */

public class GooglePlayApplication extends Application {
    private static int mainThreradId;
    private static Context context;
    private static  Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mHandler =new Handler();
        mainThreradId = android.os.Process.myTid();//主线程

    }

    public static int getMainThreradId() {
        return mainThreradId;
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getmHandler() {
        return mHandler;
    }
}
