package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

/**
 * Created by Administrator on 2017\10\7 0007.
 */

public class MoreHolder extends BaseHolder<Integer> {
    private   LinearLayout llLoadMore;
    private TextView tvLoadError;
    //加载更多的几种状态
    //1.可以加载更多
    //2.加载更多失败
    //3.没有更多数据
    public static final int STATE_MORE_MORE=1;
    public static final int STATE_MORE_ERROE=2;
    public static final int STATE_MORE_NONE=3;

    public MoreHolder(boolean hasMore) {
        //如果有更多数据状态为STATE_MORE_MORE,将此状态传递给父类，父类同时刷新界面
        setData(hasMore?STATE_MORE_MORE:STATE_MORE_NONE);
    }

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.list_item_more);
         llLoadMore = view.findViewById(R.id.ll_load_more);
         tvLoadError = view.findViewById(R.id.tv_load_error);
        return view;
    }

    @Override
    public void refreshView(Integer data) {
        switch (data){
            case STATE_MORE_MORE:
                //显示加载更多
                llLoadMore.setVisibility(View.VISIBLE);
                tvLoadError.setVisibility(View.GONE);
                break;
            case STATE_MORE_NONE:
                //隐藏加载更多
                llLoadMore.setVisibility(View.GONE);
                tvLoadError.setVisibility(View.GONE);
                break;
            case STATE_MORE_ERROE:
                //加载失败
                llLoadMore.setVisibility(View.GONE);
                tvLoadError.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

}
