package com.ljr.study.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.ljr.study.R;

import java.util.ArrayList;
import java.util.List;

public class TestFragmentActivity extends FragmentActivity {

    FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("FragmentAct1", "FragmentAct  --- onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_fragment);
        test2();
    }

    private void test1() {
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, TestFragment.newInstance("test"));
        ft.commit();
    }

    private void test2() {
        fm = getSupportFragmentManager();
        ViewPager viewPager = findViewById(R.id.view_pager);
        FragmentStatePagerAdapterImpl adapter = new FragmentStatePagerAdapterImpl(fm);
        adapter.setFragments(getList());
        viewPager.setAdapter(adapter);
    }

    private void test3() {
        fm = getSupportFragmentManager();
        ViewPager viewPager = findViewById(R.id.view_pager);
        FragmentPagerAdapterImpl adapter = new FragmentPagerAdapterImpl(fm);
        adapter.setFragments(getList());
        viewPager.setAdapter(adapter);
    }

    private List<Fragment> getList() {
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(TestFragment.newInstance("Test_" + i));
        }
        return list;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("FragmentAct1", "FragmentAct  --- onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("FragmentAct1", "FragmentAct  ---  onRestoreInstanceState ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("FragmentAct1", "FragmentAct   --- onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("FragmentAct1", "FragmentAct   --- onNewIntent");
        super.onNewIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FragmentAct1", "FragmentAct   --- onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FragmentAct1", "FragmentAct   --- onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FragmentAct1", "FragmentAct   --- onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FragmentAct1", "FragmentAct   --- onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FragmentAct1", "FragmentAct   --- onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FragmentAct1", "FragmentAct   --- onDestroy");
    }
}
