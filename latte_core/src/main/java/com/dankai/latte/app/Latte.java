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

import java.util.HashMap;

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }

}
