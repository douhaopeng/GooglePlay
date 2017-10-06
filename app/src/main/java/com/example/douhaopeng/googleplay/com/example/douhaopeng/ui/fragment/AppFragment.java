package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.view.View;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;

/**应用
 * Created by Administrator on 2017\10\6 0006.
 */

public class AppFragment extends BaseFragment {
    //只有成功才走此方法
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_ERROR;
    }

}
