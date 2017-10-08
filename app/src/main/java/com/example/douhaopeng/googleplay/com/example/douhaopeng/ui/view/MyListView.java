package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ListView;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment.HomeFragment;

/**
 * Created by Administrator on 2017\10\8 0008.
 */

public class MyListView extends ListView {
    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public MyListView(Context context) {
        super(context);
        initView();
    }
    private void initView() {
        this.setSelector(new ColorDrawable());//设置背景状态选择器为全透明
        this.setDivider(null);
        this.setCacheColorHint(Color.TRANSPARENT);//滑动listView为全透明
    }
}
