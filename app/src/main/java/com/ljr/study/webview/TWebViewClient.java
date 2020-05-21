package com.ljr.study.webview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ljr.study.utils.Logger;

public class TWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Logger.e("shouldOverrideUrlLoading old ---- url =  " + url);
        if(!url.startsWith("https://www.hao123.com")){
//        view.loadUrl("https://www.hao123.com");
        }
        return false;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if(!request.getUrl().getHost().contains("hao123.com")){
        Logger.e("shouldOverrideUrlLoading ---- url =  " + request.getUrl().getHost());
            view.loadUrl("https://www.hao123.com");
        }
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Logger.e("onPageStarted ---- url =  " + url);
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Logger.e("onPageFinished ---- url =  " + url);
        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        Logger.e("onLoadResource ---- url =  " + url);
        super.onLoadResource(view, url);
    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
        Logger.e("onPageCommitVisible ---- url =  " + url);
        super.onPageCommitVisible(view, url);
    }

    @SuppressLint("NewApi")
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Logger.e("shouldInterceptRequest ---- url =  " + request.getUrl());
        return super.shouldInterceptRequest(view, request);
    }

    @SuppressLint("NewApi")
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Logger.e("onReceivedError ---- url =  " + request.getUrl() + "  code  = " + error.getErrorCode());
        super.onReceivedError(view, request, error);
    }

    @SuppressLint("NewApi")
    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request,
            WebResourceResponse errorResponse) {
        Logger.e("onReceivedHttpError ---- url =  " + request.getUrl() + "  code  = " + errorResponse.getStatusCode());
        super.onReceivedHttpError(view, request, errorResponse);
    }

    @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        Logger.e("onFormResubmission ---- dontResend =  " + dontResend.toString() +  "  resend = " + resend.toString());
        super.onFormResubmission(view, dontResend, resend);
    }

    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
    }

    @Override
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        super.onReceivedClientCertRequest(view, request);
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host,
            String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        Logger.e("shouldOverrideKeyEvent   event =  " + event.getAction());
        return super.shouldOverrideKeyEvent(view, event);
    }

    @Override
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        super.onUnhandledKeyEvent(view, event);
    }

    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
    }

    @Override
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        super.onReceivedLoginRequest(view, realm, account, args);
    }

    @Override
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        return super.onRenderProcessGone(view, detail);
    }
}
