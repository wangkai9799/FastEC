package com.dankai.latte.delegates.web.client;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web.client
 *  文件名:    WebViewClientImpl
 *  创建者:    WK
 *  时间：     2019/8/2 17:24
 *  描述：     TODO
 */

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dankai.latte.app.ConfigKeys;
import com.dankai.latte.app.Latte;
import com.dankai.latte.delegates.IPageLoadListener;
import com.dankai.latte.delegates.web.WebDelegate;
import com.dankai.latte.delegates.web.route.Router;
import com.dankai.latte.ui.loader.LatteLoader;
import com.dankai.latte.util.log.LatteLogger;
import com.dankai.latte.util.storage.LattePreference;

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener = null;
    private static final Handler HANDLER = Latte.getHandler();

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

    public WebViewClientImpl(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    //获取浏览器中的cookie
    private void syncCookie() {
        final CookieManager manager = CookieManager.getInstance();
        /**
         * 注意：这里的Cookie和API请求的Cookie是不一样的，这个在网页不可见
         */
        final String webHost = Latte.getConfigurations(ConfigKeys.WEB_HOST);
        if (webHost != null) {
            if (manager.hasCookies()) {
                final String cookieStr = manager.getCookie(webHost);
                if (cookieStr != null && !cookieStr.equals("")) {
                    LattePreference.addCustomAppProfile("cookie", cookieStr);
                }
            }
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        syncCookie();
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatteLoader.stopLoading();
            }
        }, 1000);
    }
}
