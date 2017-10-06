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

public abstract class LoadingPage extends FrameLayout {
    private View mSuccessPage;
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

        if(mSuccessPage == null && mCurrentState == STATE_LOAD_SUCCESS){
             mSuccessPage = onCreateSuccessView();
            if(mSuccessPage != null){
                addView(mSuccessPage);
            }
        }
        if(mSuccessPage!=null){
            mSuccessPage.setVisibility((mCurrentState == STATE_LOAD_SUCCESS)?View.VISIBLE:View.GONE);
        }
    }
    //开始异步加载数据
    public void loadData(){
        if(mCurrentState!=STATE_LOAD_LOADING){
        mCurrentState = STATE_LOAD_LOADING;

        new Thread(){
            @Override
            public void run() {
                super.run();
               final ResultState resultState =  onLoad();
                //运行在主线程
                UIUtils.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        if(resultState!=null){
                            mCurrentState = resultState.getState();//加载结束后更新网络状态
                        }
                        //根据最新状态刷新页面
                        showRightPage();
                    }
                });

            }
        }.start();
        }
    }
    //加载成功的布局,必须有调用者来实现
    public abstract View onCreateSuccessView();
    //加载网络，返回结束时状态
    public abstract  ResultState onLoad();

    public enum ResultState{
        STATE_SUCCESS(STATE_LOAD_SUCCESS),
        STATE_EMPTY(STATE_LOAD_EMPTY),
        STATE_ERROR(STATE_LOAD_ERROR);
        private int state;
        private ResultState(int state){
            this.state = state;
        }
        public int getState(){
            return state;
        }
    }
}
