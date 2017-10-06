package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.view.View;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;

/**
 * 游戏
 * Created by Administrator on 2017\10\6 0006.
 */

public class GameFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_EMPTY;
    }
}
