package com.dankai.latte.app;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.fastec.latte_core.app
 *  文件名:    Latte
 *  创建者:    WK
 *  时间：     2019/7/13 16:49
 *  描述：     TODO
 */

import android.content.Context;
import android.os.Handler;

public final class Latte {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfigurations(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfigurations(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfigurations(ConfigKeys.HANDLER);
    }

    public static void test() {

    }
}
