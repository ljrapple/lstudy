package com.ljr.com.lapplication.utils;

import android.content.Context;

import com.ljr.com.lapplication.LApplication;

public class App {
    public static Context getContext() {
        return LApplication.getInstance();
    }
}
