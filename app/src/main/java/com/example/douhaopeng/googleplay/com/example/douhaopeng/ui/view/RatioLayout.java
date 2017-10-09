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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
    //1.获取到宽度
        //2.根据宽度和比例，计算控件高度
    //3.重新测量控件
        int width = MeasureSpec.getSize(widthMeasureSpec);//获取宽度值

        // MeasureSpec.EXACTLY 确定值, 比如把宽高值写死,或者match_parent
        // MeasureSpec.AT_MOST 至多, 能撑多大就多大, 类似wrap_content
        // MeasureSpec.UNSPECIFIED 未指定大小

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);//获取宽度模式
        int height = MeasureSpec.getSize(heightMeasureSpec);//高度值
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);//获取高度模式
        //宽度确定，高度不确定，ratio合法，才计算高度值
        if(widthMode == MeasureSpec.EXACTLY && heightMode!=MeasureSpec.EXACTLY && ratio>0){
            //图片宽度 = 控件宽度 - 左侧宽度 - 右侧宽度
            int imageWidth = width - getPaddingLeft() - getPaddingRight();
            //图片高度 = 图片宽度/宽高比例
            int imageHeight = (int) (imageWidth / ratio + 0.5f);
            //空间高度 = 图片高度+上册内边距+下册内边距
            height = imageHeight+getPaddingTop()+getPaddingBottom();
            //根据最新的高度生成heightMeasureSpec(高度模式是确定模式)
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY);
        }
//按照最新的高度测量控件
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
