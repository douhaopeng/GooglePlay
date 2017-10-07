package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

/**
 * Created by Administrator on 2017\10\7 0007.
 */

public class HomeHolder extends BaseHolder<String> {
    private   TextView tvContent;
    @Override
    public View initView() {
      View view =  UIUtils.inflate(R.layout.list_item_home);
         tvContent = view.findViewById(R.id.tv_content);
        return view;
    }

    @Override
    public void refreshView(String data) {
        tvContent.setText(data);
    }


}
