package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

/**根据当前状态显示不同页面自定义控件
 * 未加载-加载中-加载失败—数据为空-加载成功
 *
 * Created by Administrator on 2017\10\6 0006.
 */

public class LoadingPage extends FrameLayout {
    private View mEmptyPage;
    private View mErrorPage;
    private View mLoadingPage;
    private static final int STATE_LOAD_UNDO = 1;//未加载
    private static final int STATE_LOAD_LOADING = 2;//加载中
    private static final int STATE_LOAD_ERROR = 3;//加载失败
    private static final int STATE_LOAD_EMPTY = 4;//数据为空
    private static final int STATE_LOAD_SUCCESS = 5;//加载成功
    private int mCurrentState = STATE_LOAD_UNDO;
    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public LoadingPage(@NonNull Context context) {
        super(context);
        initView();
    }
    private void initView() {
        //初始化家在中的布局
        if (mLoadingPage == null) {
            mLoadingPage = UIUtils.inflate(R.layout.page_loading);
            addView(mLoadingPage);//将布局添加给当前帧布局
        }
        //初始化加载失败的布局
        if (mErrorPage == null) {
            mErrorPage = UIUtils.inflate(R.layout.page_error);
            addView(mErrorPage);
        }

        //加载数据为空
        if(mEmptyPage == null){
            mEmptyPage = UIUtils.inflate(R.layout.page_empty);
            addView(mEmptyPage);
        }
        showRightPage();
    }
//根据当前状态决定显示哪个布局
    private void showRightPage() {
//        if(mCurrentState == STATE_LOAD_UNDO||mCurrentState== STATE_LOAD_LOADING){
//            mLoadingPage.setVisibility(View.VISIBLE);
//        }else{
//            mLoadingPage.setVisibility(View.GONE);
//        }
        mLoadingPage.setVisibility((mCurrentState == STATE_LOAD_UNDO||mCurrentState== STATE_LOAD_LOADING)?View.VISIBLE:View.GONE);
        mErrorPage.setVisibility((mCurrentState ==STATE_LOAD_ERROR  )?View.VISIBLE:View.GONE);
        mEmptyPage.setVisibility((mCurrentState == STATE_LOAD_EMPTY)?View.VISIBLE:View.GONE);
    }
}
