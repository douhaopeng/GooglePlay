package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.view.View;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.AppInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol.AppProtocol;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.adapter.MyBaseAdapter;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.BaseHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.MyListView;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.util.ArrayList;

/**应用
 * Created by Administrator on 2017\10\6 0006.
 */

public class AppFragment extends BaseFragment {
    private ArrayList<AppInfo> data;
    //只有成功才走此方法
    @Override
    public View onCreateSuccessView() {

        MyListView view =new MyListView(UIUtils.getContext());
        view.setAdapter(new AppAdapter(data));
        return view;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        AppProtocol protocol = new AppProtocol();
        data =protocol.getData(0);
        return check(data);
    }

class AppAdapter extends MyBaseAdapter<AppInfo>{


    public AppAdapter(ArrayList<AppInfo> data) {
        super(data);
    }

    @Override
    public BaseHolder<AppInfo> getHolder() {
        return null;
    }

    @Override
    public ArrayList<AppInfo> onLoadMore() {
        AppProtocol protocol = new AppProtocol();
       ArrayList<AppInfo> moreData = protocol.getData(getListSize());
        return moreData;
    }
}
}
