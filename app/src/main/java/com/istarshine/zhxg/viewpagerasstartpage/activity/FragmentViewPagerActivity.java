package com.istarshine.zhxg.viewpagerasstartpage.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.istarshine.zhxg.viewpagerasstartpage.R;
import com.istarshine.zhxg.viewpagerasstartpage.adapter.FragmentViewPagerAdapter;
import com.istarshine.zhxg.viewpagerasstartpage.fragment.ViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王笔锋 on 2017/7/27.
 * Description: 该Activity用来测试Fragment+Viewpager效果
 */

public class FragmentViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_viewpager);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager); 
        
        //添加Fragment
        Bundle bundleOne = new Bundle();
        bundleOne.putString("pageNum", "1");
        ViewPagerFragment fragmentOne = ViewPagerFragment.newInstance(bundleOne);        
        Bundle bundleTwo = new Bundle();
        bundleTwo.putString("pageNum", "2");
        ViewPagerFragment fragmentTwo = ViewPagerFragment.newInstance(bundleTwo);        
        Bundle bundleThree = new Bundle();
        bundleThree.putString("pageNum", "3");
        ViewPagerFragment fragmenThree = ViewPagerFragment.newInstance(bundleThree);
        //创建List盛放Fragments
        List<Fragment> list = new ArrayList<>();
        list.add(fragmentOne);
        list.add(fragmentTwo);
        list.add(fragmenThree);
        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(fragmentViewPagerAdapter);
    }
}
