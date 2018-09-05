package com.ljr.study.utils;

import android.view.View;

public class ViewUtils {
    public static void showView(View view) {
        Check.isNotNull(view);
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void setInVisible(View view) {
        Check.isNotNull(view);
        if (view.getVisibility() != View.INVISIBLE) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    public static void hideView(View view) {
        Check.isNotNull(view);
        if (view.getVisibility() != View.GONE) {
            view.setVisibility(View.GONE);
        }
    }
}
