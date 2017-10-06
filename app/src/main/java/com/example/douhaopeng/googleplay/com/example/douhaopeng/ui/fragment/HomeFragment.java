package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

/**
 * Created by Administrator on 2017\10\6 0006.
 */

public class HomeFragment extends BaseFragment {
    //如果加载数据成功就回调此方法，运行在主线程
    @Override
    public View onCreateSuccessView() {
        TextView view = new TextView(UIUtils.getContext());
        view.setText(getClass().getSimpleName());
        return view;
    }
    //已经运行在子线程，可以直接执行耗时操作
    @Override
    public LoadingPage.ResultState onLoad() {
        //请求网络
        return LoadingPage.ResultState.STATE_SUCCESS;
    }
}
