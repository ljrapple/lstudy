package com.ljr.study.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.ljr.study.R;
import com.ljr.study.utils.Logger;

public class TestServiceActivity extends Activity {
    ITestBinder mBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_service);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceActivity.this, TestService.class);
                startService(intent);
            }
        });

        findViewById(R.id.bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceActivity.this, TestService.class);
                bindService(intent, mConn, Service.BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.rebind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(TestServiceActivity.this, TestService.class);
//                bindService(intent, mConn, Service.BIND_AUTO_CREATE);
                startThread("thread1", 1);
                startThread("thread2", 2);
            }
        });

        findViewById(R.id.unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mConn);
            }
        });

        findViewById(R.id.stopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceActivity.this, TestService.class);
                stopService(intent);
            }
        });
    }

    ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("TestServiceL", "TestServiceL  onServiceConnected");
            mBinder = ITestBinder.Stub.asInterface(service);
            startThread("thread1", 1);
            startThread("thread2", 2);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("TestServiceL", "TestServiceL  onServiceDisconnected");
        }

        @Override
        public void onBindingDied(ComponentName name) {
            Log.d("TestServiceL", "TestServiceL  onBindingDied");
        }
    };

    void startThread(final String name, final int num) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (mBinder == null) return;
                try {
                    Logger.e("start  basicTypes ");
                    mBinder.basicTypes(num, 1, false, 1.0f, 1, name);
                    Logger.e("complete  basicTypes ");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
