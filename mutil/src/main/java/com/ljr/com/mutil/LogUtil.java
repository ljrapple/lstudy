package com.ljr.com.mutil;

import android.util.Log;

public class LogUtil {
    private static String sTag = "LOG_L_";
    private static StringBuilder mSb = new StringBuilder();

    public static void d(String message) {
        Log.d(sTag, covertMsg(message));
    }

    public static void e(String message) {
        Log.e(sTag, covertMsg(message));
    }

    private static String covertMsg(String message) {
        mSb.replace(0, mSb.length(), "");
        return mSb.append(sTag).append("---------").append(message).toString();
    }

    public static void setTag(String tag) {
        sTag = tag;
    }
}
