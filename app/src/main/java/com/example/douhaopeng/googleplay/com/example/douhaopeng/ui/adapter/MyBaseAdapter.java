package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.BaseHolder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017\10\7 0007.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private ArrayList<T> data;
    public MyBaseAdapter(ArrayList<T> data){
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseHolder holder;
        if(view ==null){
            //1.加载布局
            //2.初始化控件findViewById
            //3.打一个标记Tag
            holder = getHolder();//子类返回具体对象
        }else {
            holder = (BaseHolder) view.getTag();
        }
        holder.setData(getItem(i));
        return holder.getRootView();
    }
    //返回当前页面holder对象，必须子类实现
    public abstract BaseHolder<T> getHolder();
}
