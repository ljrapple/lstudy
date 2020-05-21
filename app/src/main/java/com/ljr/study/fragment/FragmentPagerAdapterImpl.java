package com.ljr.study.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
