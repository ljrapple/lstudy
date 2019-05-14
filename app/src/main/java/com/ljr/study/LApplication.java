package com.ljr.study;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.ljr.study.ui.LanguageActivity;
import com.ljr.study.utils.Logger;

public class LApplication extends Application {

    private static Application sApplication;
    private Resources mResources;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Logger.e("LApplication attachBaseContext");
        sApplication = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.e("LApplication onCreate");
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
