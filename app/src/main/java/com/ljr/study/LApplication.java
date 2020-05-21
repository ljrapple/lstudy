package com.ljr.study;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;

import com.ljr.study.service.TestService;
import com.ljr.study.ui.LanguageActivity;
import com.ljr.study.utils.Logger;

public class LApplication extends Application {

    private static Application sApplication;
    private Resources mResources;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.e("LApplication","LApplication attachBaseContext" + this);
        sApplication = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(this, TestService.class);
        Logger.e("LApplication onCreate  " + System.identityHashCode(intent));
        startService(intent);
    }

    public static Application getInstance() {
        return sApplication;
    }

    @Override
    public Resources getResources() {
        if (mResources == null) {
            synchronized (LApplication.class) {
                if (mResources == null) mResources = LanguageActivity.getResource(getBaseContext());
            }
        }
        return mResources;
    }
}
