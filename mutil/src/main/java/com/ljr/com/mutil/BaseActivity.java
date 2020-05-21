package com.ljr.com.mutil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        LogUtil.setTag(getClass().getSimpleName());
        super.onCreate(savedInstanceState);
        LogUtil.e("onCreate");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        LogUtil.setTag(getClass().getSimpleName());
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.e("onRestoreInstance");
    }

    @Override
    protected void onStart() {
        LogUtil.setTag(getClass().getSimpleName());
        super.onStart();
        LogUtil.e("onStart");
    }

    @Override
    protected void onRestart() {
        LogUtil.setTag(getClass().getSimpleName());
        super.onRestart();
        LogUtil.e("onRestart");
    }

    @Override
    protected void onResume() {
        LogUtil.setTag(getClass().getSimpleName());
        super.onResume();
        LogUtil.e("onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.e("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.e("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.e("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.e("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.e("onLowMemory");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.e("onTrimMemory");
        super.onTrimMemory(level);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        LogUtil.setTag(getClass().getSimpleName());
        LogUtil.e("onNewIntent");
        super.onNewIntent(intent);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
}
