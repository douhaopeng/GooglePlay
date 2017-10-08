package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.example.douhaopeng.googleplay.R;

/**
 * Created by Administrator on 2017\10\8 0008.
 */

public class RatioLayout extends FrameLayout {
    private  float ratio;
    public RatioLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public RatioLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
       TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.RatioLayout);
        ratio =  typeArray.getFloat(R.styleable.RatioLayout_ratio, -1);
        typeArray.recycle();//回收typrArray
    }
    public RatioLayout(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
