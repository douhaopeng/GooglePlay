package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.SubjectInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol.HotProtocol;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol.SubjectProtocol;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.FlowLayout;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.DrawableUtils;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * 排行
 * Created by Administrator on 2017\10\6 0006.
 */

public class HotFragment extends BaseFragment {
    private  ArrayList<String> data;
    @Override
    public View onCreateSuccessView() {
        ScrollView scrollView  =new ScrollView(UIUtils.getContext());
        FlowLayout flow = new FlowLayout(UIUtils.getContext());
        int padding = UIUtils.dip2px(10);
        flow.setPadding(padding,padding,padding,padding);
        flow.setHorizontalSpacing(UIUtils.dip2px(6));
        flow.setVerticalSpacing(UIUtils.dip2px(8));
        for (int i =0;i<data.size();i++){
           final String keyWord = data.get(i);
            TextView view = new TextView(UIUtils.getContext());
            view.setText(keyWord);
            view.setTextColor(Color.WHITE);
            view.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
            view.setPadding(padding,padding,padding,padding);
            view.setGravity(Gravity.CENTER);
            Random random = new Random();
            int r = 30+random.nextInt(200);
            int b = 30+random.nextInt(200);
            int g = 30+random.nextInt(200);
            int color= 0xffcecece;
//           GradientDrawable bgNormal =  DrawableUtils.getGradientDrawable(Color.rgb(r,g,b),UIUtils.dip2px(6));
//            GradientDrawable bgPress =  DrawableUtils.getGradientDrawable(color,UIUtils.dip2px(6));
//               StateListDrawable selector = DrawableUtils.getSelector(bgNormal,bgPress);
            StateListDrawable selector =  DrawableUtils.getSelector(Color.rgb(r,g,b),color,UIUtils.dip2px(6));
            view.setBackgroundDrawable(selector);
            flow.addView(view);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Toast.makeText(UIUtils.getContext(),keyWord,Toast.LENGTH_SHORT).show();
                }
            });
        }
        scrollView.addView(flow);
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad(){
        HotProtocol protocol = new HotProtocol();
         data = protocol.getData(0);
        return check(data);
    }
}
