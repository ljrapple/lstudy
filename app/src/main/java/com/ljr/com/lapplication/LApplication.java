package com.ljr.com.lapplication;

import android.app.Application;
import android.content.Context;

public class LApplication extends Application {

    private static Application sApplication;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sApplication = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Application getInstance() {
        return sApplication;
    }
}
