package com.ljr.study.webview;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;

import com.ljr.study.R;

public class WebActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_test);
        final TWebView webView = findViewById(R.id.web_view);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new TWebChromeClient());
        webView.setWebViewClient(new TWebViewClient());
        webView.loadUrl("https://www.baidu.com");
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.hao123.com");
            }
        });
    }
}
