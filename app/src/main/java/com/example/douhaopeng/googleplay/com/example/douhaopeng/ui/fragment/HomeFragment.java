package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.AppInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol.HomeProtocol;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.activity.BaseActivity;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.adapter.MyBaseAdapter;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.BaseHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.HomeHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.MyListView;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Administrator on 2017\10\6 0006.
 */

public class HomeFragment extends BaseFragment {
    private  ArrayList<AppInfo> data;
    //private ArrayList<String> data;
    //如果加载数据成功就回调此方法，运行在主线程
    @Override
    public View onCreateSuccessView() {

        MyListView view =new MyListView(UIUtils.getContext());
        view.setAdapter(new HomeAdapter(data));
        return view;
    }
    //已经运行在子线程，可以直接执行耗时操作
    @Override
    public LoadingPage.ResultState onLoad() {
        //请求网络
        HomeProtocol protocol = new HomeProtocol();
        data = protocol.getData(0);//加载第一页
        return check(data);//校验数据
    }

    class HomeAdapter extends MyBaseAdapter<AppInfo>{

        public HomeAdapter(ArrayList<AppInfo> data){
            super(data);
        }
        @Override
        public BaseHolder<AppInfo> getHolder(){
            return new HomeHolder();
        }

        @Override
        public ArrayList<AppInfo> onLoadMore() {
//            ArrayList<String> moreData = new ArrayList<>();
//            for (int i=0;i<20;i++){
//                moreData.add("ncjasc"+i);
//            }
//            SystemClock.sleep(2000);
//            return moreData;
            HomeProtocol protocol = new HomeProtocol();
            ArrayList<AppInfo> moreData =protocol.getData(getListSize());
            return null;
        }

        @Override
        public boolean hasMore() {
            return true;
        }

        //
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            ViewHolder holder;
//            if(view==null){
//                view = UIUtils.inflate(R.layout.list_item_home);
//                holder = new ViewHolder();
//                holder.tvContent = view.findViewById(R.id.tv_content);
//                view.setTag(holder);
//            }else{
//               holder = (ViewHolder) view.getTag();
//            }
//            String content =getItem(i);
//            holder.tvContent.setText(content);
//            return view;
//        }
    }
    static class ViewHolder{
        public TextView tvContent;
    }
}
