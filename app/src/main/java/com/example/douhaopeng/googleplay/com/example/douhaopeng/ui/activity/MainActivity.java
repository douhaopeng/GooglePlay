package com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.douhaopeng.googleplay.R;
import com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.PagerTab;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.example.douhaopeng.googleplay.com.example.douhaopeng.ui.view.PagerTab mPagerTab = (PagerTab) findViewById(R.id.pager_tab);

    }
}
