package com.hui.tally.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ChartVPAdapter extends FragmentPagerAdapter {
    List<Fragment>fragmentList;
    public ChartVPAdapter(@NonNull FragmentManager fm, List<Fragment>fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
//它是一个轻量级的Fragment页面适配器，专注于实现ViewPager的多Fragment滑动切换功能