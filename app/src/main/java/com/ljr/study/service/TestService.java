package com.ljr.study.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ljr.study.utils.Logger;

public class TestService extends Service {

    ITestBinder.Stub mStub = new ITestBinder.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                double aDouble,
                String aString) throws RemoteException {
                try {
                    Logger.e("binder is sleep....");
                    Thread.sleep(1000);
                    Logger.e("thread  =  " + aString + "  ;  " + anInt + "  ,  " + aLong + "  ,  "
                            + aBoolean);
                    Logger.e("binder is completed....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TestServiceL","TestServiceL  onBind");
        return mStub;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TestServiceL","TestServiceL  onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TestServiceL","TestServiceL  onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("TestServiceL","TestServiceL  onDestroy");
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("TestServiceL","TestServiceL  onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        Log.d("TestServiceL","TestServiceL  onLowMemory");
        super.onLowMemory();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("TestServiceL","TestServiceL  onUnbind");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("TestServiceL","TestServiceL  onRebind");
    }
}
