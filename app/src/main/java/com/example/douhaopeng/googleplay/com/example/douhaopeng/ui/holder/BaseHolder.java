package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder;

import android.view.View;

/**
 * Created by Administrator on 2017\10\7 0007.
 */

public abstract class BaseHolder<T>{
    private View mRootView;
    private T data;
    public BaseHolder(){
        mRootView = initView();
        //3.打一个标记tag
        mRootView.setTag(this);
    }
    //1.加载布局文件
    //2.初始化控件findViewByid;
    public abstract View initView();
    //返回item布局
    public View getRootView(){
        return mRootView;
    }
    //设置当前item数据
    public void setData(T data){
        this.data = data;
        refreshView(data);
    }
    //获取数据
    public T getData(){
        return data;
    }

    //4.根据数据刷新界面
    public abstract void refreshView(T data);
}


