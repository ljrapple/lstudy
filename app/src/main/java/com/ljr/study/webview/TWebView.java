package com.ljr.study.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import com.ljr.study.utils.Logger;

public class TWebView extends WebView {

    public TWebView(Context context) {
        this(context, null);
    }

    public TWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Logger.setTag("TWebView");
    }
}
