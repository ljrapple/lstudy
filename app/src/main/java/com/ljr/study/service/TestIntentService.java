package com.ljr.study.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Looper;
import androidx.annotation.Nullable;
import android.util.Log;

public class TestIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService() {
        super("TestIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TestIntentService", "TestIntentService onCreate-------------------");
    }

    @Override
    public void onDestroy() {
        Log.d("TestIntentService", "TestIntentService onDestroy-------------------");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("TestIntentService", "TestIntentService onStartCommand-------------------"
        + (Looper.myLooper() == Looper.getMainLooper()));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        synchronized (this) {
            int t = intent.getIntExtra("t", 0);
            Log.d("TestIntentService", "TestIntentService start-------------------"
                    + (Looper.myLooper() == Looper.getMainLooper()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("TestIntentService", "TestIntentService end-------------------");
        }
    }
}
