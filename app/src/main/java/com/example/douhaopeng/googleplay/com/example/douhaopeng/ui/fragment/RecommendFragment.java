package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol.RecommendProtocol;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.fly.ShakeListener;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.fly.StellarMap;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * 推荐
 * Created by Administrator on 2017\10\6 0006.
 */

public class RecommendFragment extends BaseFragment {
    private ArrayList<String> data;
    @Override
    public View onCreateSuccessView() {
        final StellarMap stellar = new StellarMap(UIUtils.getContext());

        stellar.setAdapter(new RecommendAdapter());
        //9行6列
        stellar.setRegularity(6,9);
        int padding = UIUtils.dip2px(10);
        stellar.setInnerPadding(padding,padding,padding,padding);
        //默认页面
        stellar.setGroup(0,true);
        ShakeListener shake = new ShakeListener(UIUtils.getContext());
        shake.setOnShakeListener(new ShakeListener.OnShakeListener() {
            @Override
            public void onShake() {
                stellar.zoomIn();//跳到下一页
            }
        });
        return stellar;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        RecommendProtocol protocol = new RecommendProtocol();
        data = protocol.getData(0);
        return check(data);
    }

    class  RecommendAdapter implements StellarMap.Adapter {

        @Override
        public int getGroupCount() {
            return 2;
        }

        @Override
        public int getCount(int group) {
            int count = data.size()/getGroupCount();
            if(group == getGroupCount()-1){
                count+=data.size()%getGroupCount();
            }
            return count;
        }

        @Override
        public View getView(int group, int position, View convertView) {
            position += (group-1)*getCount(group-1);
           final String keyWord =  data.get(position);
            TextView view  = new TextView(UIUtils.getContext());
            view.setText(keyWord);

            //随机大小
            Random random = new Random();
           int size= 16+ random.nextInt(10);
            view.setTextSize(TypedValue.COMPLEX_UNIT_DIP,size);
            //随机颜色
            int r = 30+random.nextInt(200);
            int b = 30+random.nextInt(200);
            int g = 30+random.nextInt(200);
            view.setTextColor(Color.rgb(r,g,b));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(UIUtils.getContext(),keyWord,Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
        //返回下一组id
        @Override
        public int getNextGroupOnZoom(int group, boolean isZoomIn) {
            if(isZoomIn){//下滑加载上一页
                if(group>0){
                    group --;
                }else {
                    group = getGroupCount()-1;
                }

            }else {
                //上滑加载下一页
                if(group<getGroupCount()-1){
                    group++;
                }else{
                    group = 0;
                }
            }
            return group;
        }
    }
}
