package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.fragment;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * 生产fragment工厂
 * Created by Administrator on 2017\10\6 0006.
 */

public class FragmentFactory {
    private static HashMap<Integer,BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();
    public static BaseFragment createFragment(int pos){
        //先从集合取如果没有在创建对象
        BaseFragment fragment = mFragmentMap.get(pos);
        if(fragment==null) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();

                    break;
                case 2:
                    fragment = new GameFragment();

                    break;
                case 3:
                    fragment = new SubjectFragment();

                    break;
                case 4:
                    fragment = new RecommendFragment();

                    break;
                case 5:
                    fragment = new CategoryFragment();

                    break;
                case 6:
                    fragment = new HotFragment();

                    break;
                default:
                    break;
            }
            mFragmentMap.put(pos,fragment);
        }
        return fragment;
    }
}
