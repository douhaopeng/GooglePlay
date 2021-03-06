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

import java.util.ArrayList;

/**
 * Created by Administrator on 2017\10\6 0006.
 */

public abstract class BaseFragment extends Fragment {
    private  LoadingPage mLoadingPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         mLoadingPage = new LoadingPage(UIUtils.getContext()) {
             @Override
             public View onCreateSuccessView() {
                 //调用BAseFragment和onCreateSuccessView
                 return BaseFragment.this.onCreateSuccessView();
             }

             @Override
             public ResultState onLoad() {
                 return BaseFragment.this.onLoad();
             }


         };
        return mLoadingPage;
    }
    //加载成功的布局，必须子类实现
    public abstract View onCreateSuccessView();
    //加载网络数据必须由子类实现
    public abstract LoadingPage.ResultState onLoad();
    //对网络返回数据的合法性进行校验
    public LoadingPage.ResultState check(Object obj){
        if(obj!=null){
            if(obj instanceof ArrayList){
                ArrayList list = (ArrayList) obj;
                if(list.isEmpty()){
                    return LoadingPage.ResultState.STATE_EMPTY;
                }else{
                    return LoadingPage.ResultState.STATE_SUCCESS;
                }
            }
        }
        return LoadingPage.ResultState.STATE_ERROR;
    }
    //开始加载数据
    public void loadData(){
        if(mLoadingPage!=null){
            mLoadingPage.loadData();
        }
    }
}
