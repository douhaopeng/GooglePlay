package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.SubjectInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.HttpHelper;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.BitmapHelper;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;

/**
 * 专题的holder
 * Created by Administrator on 2017\10\8 0008.
 */

public class SubjectHolder extends BaseHolder<SubjectInfo> {

    private ImageView ivPic;
    private TextView tvTitle;
    private BitmapUtils mBitmapUtils;
    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.list_item_subject);
        ivPic = view.findViewById(R.id.iv_pic);
        tvTitle  =view.findViewById(R.id.tv_title);
         mBitmapUtils = BitmapHelper.getBitmapUtils();
        return view;
    }

    @Override
    public void refreshView(SubjectInfo data) {
        tvTitle.setText(data.des);
        mBitmapUtils.display(ivPic, HttpHelper.URL+"image?name="+data.url);
    }
}
