package com.ljr.study.utils;

import android.util.Log;

public class Logger {
    private static String tag = "Logger";

    public static void setTag(String tag) {
        Logger.tag = tag;
    }

    public static void e(String msg) {
        Log.e(tag, tag + "  ----  " + msg);
    }
}
