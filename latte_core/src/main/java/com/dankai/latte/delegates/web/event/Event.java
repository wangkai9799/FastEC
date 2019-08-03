package com.dankai.latte.delegates.web.event;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web.event
 *  文件名:    Event
 *  创建者:    WK
 *  时间：     2019/8/3 9:19
 *  描述：     TODO
 */

import android.content.Context;
import android.webkit.WebView;

import com.dankai.latte.delegates.web.WebDelegate;

public abstract class Event implements IEvent {

    private Context mContext = null;
    private String mAction = null;
    private WebDelegate mDelegate = null;
    private String mUrl = null;
    private WebView mWebView = null;

    public Context getContext() {
        return mContext;
    }

    public WebView getWebView() {
        return mDelegate.getWebView();
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        mAction = action;
    }

    public WebDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(WebDelegate delegate) {
        mDelegate = delegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
