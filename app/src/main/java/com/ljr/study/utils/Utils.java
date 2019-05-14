package com.ljr.study.utils;

import android.os.Looper;

public class Utils {
    public static boolean isUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
