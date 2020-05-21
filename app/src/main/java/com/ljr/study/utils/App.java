package com.ljr.study.utils;

import android.content.Context;

import com.ljr.study.LApplication;


public class App {
    public static Context getContext() {
        return LApplication.getInstance();
    }

    void print(int[][] arr){
        int[][] t = new int[3][5];
    }
}

enum Singleton {
    INSTANCE;
    public App sApp;

    Singleton() {
        sApp = new App();
    }
}
