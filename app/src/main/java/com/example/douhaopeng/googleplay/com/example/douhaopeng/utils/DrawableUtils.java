package com.example.douhaopeng.googleplay.com.example.douhaopeng.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by Administrator on 2017\10\8 0008.
 */

public class DrawableUtils {
    //获取
    public static GradientDrawable getGradientDrawable(int color, int radius){
        //xml中定义的shape标签定义此类
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(radius);
        shape.setColor(color);
        return shape;
    }
//获取状太选择器
    public static StateListDrawable getSelector(Drawable normal, Drawable press){
        StateListDrawable selector = new StateListDrawable();
        selector.addState(new int[]{android.R.attr.state_pressed},press);
        selector.addState(new int[]{},normal);
        return selector;

    }
    public static StateListDrawable getSelector(int normal, int press,int radius){
        GradientDrawable bgNormal =  getGradientDrawable(normal,radius);
        GradientDrawable bgPress =  getGradientDrawable(press,radius);
        StateListDrawable selector =  getSelector(bgNormal,bgPress);
        return selector;

    }
}
