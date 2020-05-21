package com.ljr.study.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.ljr.study.BTestLiftActivity;
import com.ljr.study.R;

import java.util.ArrayList;
import java.util.List;

public class TestFragmentActivity extends FragmentActivity {
    class MReceive extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("FragmentAct1",
                    "FragmentAct  --- onReceive  " + (Looper.getMainLooper() == Looper.myLooper()));
            recreate();
        }
    }

    FragmentManager fm;
    MReceive mMReceive;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("FragmentAct1", "FragmentAct  --- onCreate" + getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_fragment);
        test1("test1");
        test1("test2");
        test1("test3");
        test1("test5");
        test1("test4");
//        Thread.dumpStack();
        Intent intent = new Intent(this, BTestLiftActivity.class);
        Log.e("identityHashCode  ",
                "identityHashCode  test i = " + System.identityHashCode(intent));
        startActivity(intent);
        mMReceive= new MReceive();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.ljr.study.mReceive");
        registerReceiver(mMReceive, filter);
    }

    private void test1(String name) {
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f1 = TestFragment.newInstance(name);
        ft.replace(R.id.fragment_container, f1, name);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void testR1(String name, String tag) {
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f1 = TestFragment.newInstance(name);
        ft.replace(R.id.fragment_container, f1);
        ft.addToBackStack(name);
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
        unregisterReceiver(mMReceive);
        super.onDestroy();
        Log.d("FragmentAct1", "FragmentAct   --- onDestroy");
    }
}
