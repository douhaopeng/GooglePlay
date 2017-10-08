package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.view.View;

import com.example.douhaopeng.googleplay.com.example.douhaopeng.domain.SubjectInfo;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.http.protocol.SubjectProtocol;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.adapter.MyBaseAdapter;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.BaseHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.holder.SubjectHolder;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.LoadingPage;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.MyListView;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

import java.util.ArrayList;

/**专题
 * Created by Administrator on 2017\10\6 0006.
 */

public class SubjectFragment extends BaseFragment {
    private ArrayList<SubjectInfo> data;
    @Override
    public View onCreateSuccessView() {

        MyListView view =new MyListView(UIUtils.getContext());
        view.setAdapter(new SubjectAdapter(data));
        return view;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        SubjectProtocol protocol = new SubjectProtocol();
       ArrayList<SubjectInfo> data = protocol.getData(0);
        return check(data);
    }

    class SubjectAdapter extends MyBaseAdapter<SubjectInfo>{
        public SubjectAdapter(ArrayList<SubjectInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<SubjectInfo> getHolder() {
            return new SubjectHolder() ;
        }

        @Override
        public ArrayList<SubjectInfo> onLoadMore() {
            SubjectProtocol protocol = new SubjectProtocol();
           ArrayList<SubjectInfo> moreData = protocol.getData(getListSize());
            return moreData;
        }
    }
}
