package com.istarshine.zhxg.viewpagerasstartpage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.istarshine.zhxg.viewpagerasstartpage.R;

/**
 * Created by 王笔锋 on 2017/7/27.
 * Description: 该类是用来测试Fragment + ViewPager的显示效果
 */

public class ViewPagerFragment extends Fragment {
    private TextView textView;
    private Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, null);
        textView = (TextView)view.findViewById(R.id.fragmentText);
        String pageNum = bundle.getString("pageNum");
        textView.setText("这是第" + pageNum + "个Fragment页面的内容");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }
    
    public static ViewPagerFragment newInstance(Bundle bundle) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        viewPagerFragment.setArguments(bundle);
        return viewPagerFragment;
    }
}
