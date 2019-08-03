package com.dankai.latte.delegates.web.event;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web.event
 *  文件名:    UndefinedEvent
 *  创建者:    WK
 *  时间：     2019/8/3 9:26
 *  描述：     TODO
 */

import com.dankai.latte.util.log.LatteLogger;

public class UndefinedEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefinedEvent", params);
        return null;
    }
}
