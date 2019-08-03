package com.dankai.latte.delegates.web;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web
 *  文件名:    LatteWebInterface
 *  创建者:    WK
 *  时间：     2019/8/2 16:49
 *  描述：     TODO
 */

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.dankai.latte.delegates.web.event.Event;
import com.dankai.latte.delegates.web.event.EventManager;

public final class LatteWebInterface {

    private final WebDelegate DELEGATE;

    private LatteWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static LatteWebInterface create(WebDelegate delegate) {
        return new LatteWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }

}
