package com.dankai.latte.util.callback;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.util.callback
 *  文件名:    CallBackManager
 *  创建者:    WK
 *  时间：     2019/8/7 15:15
 *  描述：     TODO
 */

import java.util.WeakHashMap;

public class CallBackManager {

    private static final WeakHashMap<Object, IGlobalCallback> CALLBACKS = new WeakHashMap<>();

    private static class Holder {
        private static final CallBackManager INSTANCE = new CallBackManager();
    }

    public static CallBackManager getInstance() {
        return Holder.INSTANCE;
    }

    public CallBackManager addCallback(Object tag, IGlobalCallback callback) {
        CALLBACKS.put(tag, callback);
        return this;
    }

    public IGlobalCallback getCallback(Object tag) {
        return CALLBACKS.get(tag);
    }

}
