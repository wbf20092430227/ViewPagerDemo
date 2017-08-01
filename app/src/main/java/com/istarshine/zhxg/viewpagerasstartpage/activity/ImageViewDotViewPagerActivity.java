package com.istarshine.zhxg.viewpagerasstartpage.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.istarshine.zhxg.viewpagerasstartpage.R;
import com.istarshine.zhxg.viewpagerasstartpage.adapter.ImageViewPagerAdapter;
import com.istarshine.zhxg.viewpagerasstartpage.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王笔锋 on 2017/7/28.
 * Description: 该Activity用ViewPager来展示ImageView 
 */

public class ImageViewDotViewPagerActivity extends AppCompatActivity{
    private ViewPager viewPager;
    private TextView textView;
    private LinearLayout linearLayout;
    private int startPosition = 0;
    //定义不同ViewPager页面要展示的图片
    private final int[] imageIds = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e            
    };

    //定义不同ViewPager页面的描述
    private final String[] imageDescriptions = {
            "一向年光有限身",
            "等闲离别易销魂",
            "酒筵歌席莫辞频",
            "满目山河空念远",
            "落花风雨更伤春"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_dot_viewpager);
        //初始化View
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        textView = (TextView)findViewById(R.id.tv_title);
        textView.setText(imageDescriptions[startPosition]);
        linearLayout = (LinearLayout)findViewById(R.id.ll_points);
        List<ImageView> imageViewList = new ArrayList<>();
        //循环设置ImageView的信息
        for (int i = 0; i < imageIds.length; i++) {
            //添加ViewPager中要展示的图片
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageViewList.add(imageView);
            //添加点
            ImageView pointImageView = new ImageView(this);
            //设置点的背景，有选中和未选中两种变化
            pointImageView.setBackgroundResource(R.drawable.point_background);
            //设置每一个圆点ImageView的大小,设置为8dp
            int dpValue = DensityUtil.dip2px(ImageViewDotViewPagerActivity.this, 8);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dpValue, dpValue);
            if (i == 0) {
                //设置第一个圆点选中
                pointImageView.setEnabled(true);
            } else {
                //一开始的时候如果不是第一个就显示为灰色
                pointImageView.setEnabled(false);
                //设置每一个圆点距离左边为8dp，其中第一个不设置
                params.leftMargin = dpValue;
            } 
            pointImageView.setLayoutParams(params);
            //添加圆点到LinearLayout中
            linearLayout.addView(pointImageView);
        }
        ImageViewPagerAdapter imageViewPagerAdapter = new ImageViewPagerAdapter(imageViewList);
        viewPager.setAdapter(imageViewPagerAdapter);
        //设置Viewpager的监听，用来动态改变当ViewPager页面滑动的时候动态改变圆点
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 该方法当页面滑动的时候调用
             * @param position 位置
             * @param positionOffset 滑动百分比
             * @param positionOffsetPixels 滑动像素
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            /**
             * 滑动到某个具体的页面静止的时候调用
             * @param position
             */
            @Override
            public void onPageSelected(int position) {
                textView.setText(imageDescriptions[position]);
                linearLayout.getChildAt(startPosition).setEnabled(false);
                linearLayout.getChildAt(position).setEnabled(true);
                startPosition = position;

            }

            /**
             * 页面从静止到拖拽，拖拽到滑动，滑动到静止的时候调用
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
