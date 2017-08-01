package com.istarshine.zhxg.viewpagerasstartpage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.istarshine.zhxg.viewpagerasstartpage.R;

/**
 * Created by 王笔锋 on 2017/7/27.
 * Description: 该类是主入口，用来测试不同ViewPager的展示形式
 */

public class LauncherMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
    }

    public void onButtonClick(View view) {
        Intent intent ;
        switch (view.getId()) {
            case R.id.viewViewPagerButton:
                intent = new Intent(LauncherMenuActivity.this, SimpleViewActivity.class);
                startActivity(intent);
                break;
            case R.id.fragmentViewPagerButton:
                intent = new Intent(LauncherMenuActivity.this, FragmentViewPagerActivity.class);
                startActivity(intent);
                break;            
            case R.id.imageViewDotViewPager:
                intent = new Intent(LauncherMenuActivity.this, ImageViewDotViewPagerActivity.class);
                startActivity(intent);
                break;
            
            default:
                break;
        }
    }
}
