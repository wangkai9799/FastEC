package com.dankai.latte.delegates.web;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web
 *  文件名:    IWebViewInitializer
 *  创建者:    WK
 *  时间：     2019/8/2 16:26
 *  描述：     TODO
 */

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public interface IWebViewInitializer {

    WebView initWebView(WebView webView);

    WebViewClient initWebViewClient();

    WebChromeClient initWebChromeClient();

}
