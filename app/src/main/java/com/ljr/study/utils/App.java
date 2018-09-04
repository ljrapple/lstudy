package com.ljr.study.utils;

import android.content.Context;

import com.ljr.study.LApplication;


public class App {
    public static Context getContext() {
        return LApplication.getInstance();
    }
}
