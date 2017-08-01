package com.istarshine.zhxg.viewpagerasstartpage.activity;

import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.istarshine.zhxg.viewpagerasstartpage.R;
import com.istarshine.zhxg.viewpagerasstartpage.adapter.StartPagePagerAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by 王笔锋 on 2017/7/27.
 * Description: 该类是用来测试简单的view添加到viewpager当中的效果
 */

public class SimpleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        LayoutInflater layoutInflater = LayoutInflater.from(SimpleViewActivity.this);
        View tab1 = layoutInflater.inflate(R.layout.tab1, null);
        View tab2 = layoutInflater.inflate(R.layout.tab2, null);
        View tab3 = layoutInflater.inflate(R.layout.tab3, null);
        View tab4 = layoutInflater.inflate(R.layout.tab4, null);
        PagerTabStrip pagerTabStrip = (PagerTabStrip)findViewById(R.id.pagerTabStrip);
        //取消tab下面的长横线
        pagerTabStrip.setDrawFullUnderline(false);
        //设置tab的背景色
        pagerTabStrip.setBackgroundResource(R.color.white);
        //设置当前tab页签的下划线颜色
        pagerTabStrip.setTabIndicatorColorResource(R.color.darkBlue);
//        pagerTabStrip.setTextSpacing(400);
        List<View> viewList = new ArrayList<>();
        viewList.add(tab1);
        viewList.add(tab2);
        viewList.add(tab3);
        viewList.add(tab4);
        List<String> titileList = new ArrayList<>();
        titileList.add("惆怅客");
        titileList.add("泪纵横");
        titileList.add("立残阳");
        titileList.add("是寻常");
        StartPagePagerAdapter startPagePagerAdapter = new StartPagePagerAdapter(viewList, titileList);
        viewPager.setAdapter(startPagePagerAdapter);
    }
}
