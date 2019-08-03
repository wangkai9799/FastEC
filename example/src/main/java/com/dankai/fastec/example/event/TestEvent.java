package com.dankai.fastec.example.event;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web.event
 *  文件名:    TestEvent
 *  创建者:    WK
 *  时间：     2019/8/3 9:34
 *  描述：     TODO
 */

import android.webkit.WebView;
import android.widget.Toast;

import com.dankai.latte.delegates.web.event.Event;

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(), getAction(), Toast.LENGTH_LONG).show();
        if (getAction().equals("test")) {
            final WebView webView = getWebView();
            getWebView().post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall();", null);
                }
            });
        }
        return null;
    }
}
