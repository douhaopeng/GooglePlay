package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.PagerTab;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.utils.UIUtils;

public class MainActivity extends BaseActivity{
    private String[] mTabNames;
    private  ViewPager mViewPager;
    private com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.PagerTab mPagerTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mPagerTab = (PagerTab) findViewById(R.id.pager_tab);
         mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mPagerTab.setViewPager(mViewPager);//将指针和viewpager绑定一起
    }
    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
            mTabNames =  UIUtils.getStringArray(R.array.tab_names);//加载页面标题的数组
        }
//返回标题内容
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }

        //返回当前位置fragment对象
        @Override
        public Fragment getItem(int position) {

            return null;
        }
//fragemnt数量
        @Override
        public int getCount() {
            return mTabNames.length;
        }
    }
}
