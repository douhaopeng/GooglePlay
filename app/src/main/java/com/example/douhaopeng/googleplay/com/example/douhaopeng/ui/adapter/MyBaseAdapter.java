package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.BaseHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.MoreHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017\10\7 0007.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private boolean isLoadMore=false;
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
            //一旦加载更多布局就开始加载更多
            //只有在更多数据的状态下才加载更多
            MoreHolder moreHolder = (MoreHolder) holder;
            if(moreHolder.getData() == MoreHolder.STATE_MORE_MORE){
                LoadMore(moreHolder);
            }
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
        return 3;//返回普通布局，和加载更多布局
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

    public void LoadMore(final MoreHolder holder){
        if(!isLoadMore){
            isLoadMore = true;
            new Thread(new Runnable(){
                @Override
                public void run(){
                    final ArrayList<T> moreData = onLoadMore();
                    UIUtils.runOnUIThread(new Runnable(){
                        @Override
                        public void run(){
                            if(moreData!=null){
                                if(moreData.size()<20){
                                    holder.setData(MoreHolder.STATE_MORE_NONE);
                                    Toast.makeText(UIUtils.getContext(),"没有更多数据了",Toast.LENGTH_SHORT).show();
                                }else{
                                    holder.setData(MoreHolder.STATE_MORE_MORE);
                                }
                                //将更多数据追加到当前集合中
                                data.addAll(moreData);
                                //刷新界面
                                MyBaseAdapter.this.notifyDataSetChanged();
                            }else{
                                holder.setData(MoreHolder.STATE_MORE_ERROE);
                            }
                            isLoadMore = false;
                        }
                    });

                }
            }).start();
        }

    }

    public abstract ArrayList<T> onLoadMore();
    public  int getListSize(){
        return data.size();
    }
}
