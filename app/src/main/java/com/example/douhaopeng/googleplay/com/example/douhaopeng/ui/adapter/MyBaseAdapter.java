package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.BaseHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.MoreHolder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017\10\7 0007.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private static final int TYPE_NORMAL = 0;//正常类型
    private static final int TYPE_MORE = 1;//更多类型
    private ArrayList<T> data;
    public MyBaseAdapter(ArrayList<T> data){
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size()+1;
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
    public View getView(int i, View view, ViewGroup viewGroup){
        BaseHolder holder;
        if(view == null){
            //1.加载布局
            //2.初始化控件findViewById
            //3.打一个标记Tag
            if(getItemViewType(i)==TYPE_MORE){
                //4.判断是否是加载更多类型
                holder = new MoreHolder(hasMore());
            }else{
                holder = getHolder();//子类返回具体对象
            }
        }else {
            holder = (BaseHolder) view.getTag();
        }
        if(getItemViewType(i)!=TYPE_MORE){
            holder.setData(getItem(i));
        }
        else{
            //加载更多布局
        }
        return holder.getRootView();
    }
    //子类可以重写此方法来决定是否可以加载
    public boolean hasMore() {
        return true;
    }

    //返回布局类型的个数
    @Override
    public int getViewTypeCount(){
        return 2;//返回普通布局，和加载更多布局
    }
    //返回当前位置应该展示的布局类型
    @Override
    public int getItemViewType(int position) {
        if(position == getCount()-1){
            return TYPE_MORE;
        }else{
           return getInnerType();
        }
    }
    //子类可以重写此方法
    public int getInnerType(){
        return TYPE_NORMAL;//默认普通类型
    }

    //返回当前页面holder对象，必须子类实现
    public abstract BaseHolder<T> getHolder();
}
