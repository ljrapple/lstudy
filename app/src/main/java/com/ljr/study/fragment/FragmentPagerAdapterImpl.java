package com.ljr.study.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentPagerAdapterImpl extends FragmentPagerAdapter {
    List<Fragment> mFragments;
    public FragmentPagerAdapterImpl(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void setFragments(List<Fragment> fragments) {
        mFragments = fragments;
    }
}
