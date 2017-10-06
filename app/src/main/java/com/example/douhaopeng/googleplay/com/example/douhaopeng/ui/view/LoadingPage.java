package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**根据当前状态显示不同页面自定义控件
 * 未加载-加载中-加载失败—数据为空-加载成功
 *
 * Created by Administrator on 2017\10\6 0006.
 */

public class LoadingPage extends FrameLayout {
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
    }
}
