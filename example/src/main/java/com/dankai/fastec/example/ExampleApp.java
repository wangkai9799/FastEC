package com.dankai.fastec.example;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.fastec.example
 *  文件名:    ExampleApp
 *  创建者:    WK
 *  时间：     2019/7/13 17:18
 *  描述：     TODO
 */

import android.app.Application;

import com.dankai.latte.app.Latte;
import com.dankai.latte.ec.icon.FontEcModule;
import com.dankai.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withApiHost("http://10.0.2.2/")
                .configure();
    }
}
