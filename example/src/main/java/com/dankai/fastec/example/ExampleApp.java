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

import androidx.annotation.Nullable;

import com.dankai.latte.app.Latte;
import com.dankai.fastec.example.event.TestEvent;
import com.dankai.latte.ec.database.DatabaseManager;
import com.dankai.latte.ec.icon.FontEcModule;
import com.dankai.latte.net.interceptors.DebugInterceptor;
import com.dankai.latte.net.rx.AddCookieInterceptor;
import com.dankai.latte.util.callback.CallBackManager;
import com.dankai.latte.util.callback.CallBackType;
import com.dankai.latte.util.callback.IGlobalCallback;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.jpush.android.api.JPushInterface;

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("aaaaaaaaa", R.raw.test))
                .withApiHost("http://10.0.2.2/Test/")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                //添加Cookie同步拦截器
                .withWebHost("https://www.baidu.com/")
                .withInterceptor(new AddCookieInterceptor())
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);
        //开启极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        CallBackManager.getInstance()
                .addCallback(CallBackType.TAG_OPEN_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            //开启极光推送
                            JPushInterface.setDebugMode(true);
                            JPushInterface.init(Latte.getApplicationContext());
                        }
                    }
                })
                .addCallback(CallBackType.TAG_OPEN_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (!JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            JPushInterface.stopPush(Latte.getApplicationContext());
                        }
                    }
                });

    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this).enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }

}
