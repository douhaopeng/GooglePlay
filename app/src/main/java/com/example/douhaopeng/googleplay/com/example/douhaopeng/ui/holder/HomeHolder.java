package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.AppInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.HttpHelper;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.BitmapHelper;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;
import com.lidroid.xutils.BitmapUtils;

/**
 * Created by Administrator on 2017\10\7 0007.
 */

public class HomeHolder extends BaseHolder<AppInfo> {
    private   TextView tvName,tvSize,tvDes;
    private ImageView ivIcon;
    private RatingBar rbStar;
    private BitmapUtils mBitmapUtils;
    @Override
    public View initView() {
      View view =  UIUtils.inflate(R.layout.list_item_home);

        tvName = view.findViewById(R.id.tv_name);
        tvSize = view.findViewById(R.id.tv_size);
        tvDes = view.findViewById(R.id.tv_des);
        ivIcon = view.findViewById(R.id.iv_icon);
        rbStar = view.findViewById(R.id.rb_star);
        mBitmapUtils = new BitmapUtils(UIUtils.getContext());
        mBitmapUtils= BitmapHelper.getBitmapUtils();
        return view;
    }

    @Override
    public void refreshView(AppInfo data) {
        tvName.setText(data.name);
        tvSize.setText(Formatter.formatFileSize(UIUtils.getContext(),data.size));
        tvDes.setText(data.des);
        rbStar.setRating(data.stars);
        mBitmapUtils.display(ivIcon, HttpHelper.URL+"image?name="+data.iconUrl);
    }




}
