package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.MyListView;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

/**
 * 游戏
 * Created by Administrator on 2017\10\6 0006.
 */

public class GameFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
//        TextView view = new TextView(UIUtils.getContext());
//        view.setText("GameFragment");
        MyListView view = new MyListView(UIUtils.getContext());

        return view;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_SUCCESS;
    }
}
