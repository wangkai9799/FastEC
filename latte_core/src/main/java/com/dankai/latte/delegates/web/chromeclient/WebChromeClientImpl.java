package com.dankai.latte.delegates.web.chromeclient;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web.chromeclient
 *  文件名:    WebChromeClientImpl
 *  创建者:    WK
 *  时间：     2019/8/2 18:16
 *  描述：     TODO
 */

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebChromeClientImpl extends WebChromeClient {

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
    }
}
