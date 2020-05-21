package com.ljr.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class BTestLiftActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
        Log.e("identityHashCode  ","identityHashCode  btest i = " + System.identityHashCode(getIntent()));

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        log("onRestoreInstanceState");
        if(savedInstanceState != null){
        log("onRestoreInstanceState-------");
            log(savedInstanceState.getString("key"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(outState != null){
        log("onSaveInstanceState------");
            outState.putString("key","Resume again !");
        }
        log("onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent();
        intent.setAction("com.ljr.study.mReceive");
        sendBroadcast(intent);
        log("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop() {
        log("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        log("onDestroy");
        super.onDestroy();
    }

    private void log(String method){
        Log.d("TestLiftActivityB","TestLiftActivityB  method  :  " + method);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        log("onNewIntent");
    }
}
