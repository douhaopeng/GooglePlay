package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

/**
 * Created by Administrator on 2017\10\6 0006.
 */

public class BaseFragment extends Fragment {
    private  LoadingPage mLoadingPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //textView显示当前类名
//        TextView view = new TextView(UIUtils.getContext());
//        view.setText(getClass().getSimpleName());
         mLoadingPage = new LoadingPage(UIUtils.getContext());
        return mLoadingPage;
    }
}
