package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.view.View;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.CategoryInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol.CategoryProtocol;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.adapter.MyBaseAdapter;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.BaseHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.MyListView;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.util.ArrayList;

/**
 * 分类
 * Created by Administrator on 2017\10\6 0006.
 */

public class CategoryFragment extends BaseFragment {

    private ArrayList<CategoryInfo> data;
    @Override
    public View onCreateSuccessView() {
        MyListView view = new MyListView(UIUtils.getContext());
        view.setAdapter(new CategotyAdapter(data));
        return view;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        CategoryProtocol protocol = new CategoryProtocol();
        data = protocol.getData(0);
        return check(data);
    }

    class CategotyAdapter extends MyBaseAdapter<CategoryInfo>{

        public CategotyAdapter(ArrayList<CategoryInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<CategoryInfo> getHolder() {
            return null;
        }

        @Override
        public boolean hasMore() {
            return false;//没有更多数据,隐藏加载更多的布局
        }

        @Override
        public ArrayList<CategoryInfo> onLoadMore() {
            return null;
        }
    }
}
