package com.ljr.study.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentStatePagerAdapterImpl extends FragmentStatePagerAdapter {
    List<Fragment> mFragments;

    public FragmentStatePagerAdapterImpl(FragmentManager fm) {
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
