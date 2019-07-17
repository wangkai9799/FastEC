package com.dankai.latte.util.storage;
/*
 *  项目名:    MyAndroidCodeLib
 *  包名：     com.dankai.myandroidcodelib.utils
 *  文件名:    SharedUtils
 *  创建者:    WK
 *  时间：     2019/5/12 11:27
 *  描述：     SharedPreferences 封装
 */

import android.content.Context;

public class SharedUtils {

    private static final String NAME = "config";

    /**
     * 存放String类型的数据
     *
     * @param mContext
     * @param key      键
     * @param value    值
     */
    public static void putString(Context mContext, String key, String value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putString(key, value).apply();
    }

    /**
     * 获取String类型的数据
     *
     * @param mContext
     * @param key      键
     * @param defValue 获取失败时的默认值
     * @return 获取到的数据
     */
    public static String getString(Context mContext, String key, String defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getString(key, defValue);
    }

    /**
     * 存放int类型的数据
     *
     * @param mContext
     * @param key      键
     * @param value    值
     */
    public static void putInt(Context mContext, String key, int value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putInt(key, value).apply();
    }

    /**
     * 获取int类型的数据
     *
     * @param mContext
     * @param key      键
     * @param defValue 获取失败时的默认值
     * @return 获取到的值
     */
    public static int getInt(Context mContext, String key, int defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getInt(key, defValue);
    }

    /**
     * 存放boolean类型的数据
     *
     * @param mContext
     * @param key      键
     * @param value    值
     */
    public static void putBoolean(Context mContext, String key, boolean value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putBoolean(key, value).apply();
    }

    /**
     * 获取boolean类型的数据
     *
     * @param mContext
     * @param key      键
     * @param defValue 值
     * @return 返回的数据
     */
    public static boolean getBoolean(Context mContext, String key, boolean defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getBoolean(key, defValue);
    }

    /**
     * 删除单个数据
     *
     * @param mContext
     * @param key
     */
    public static void delShare(Context mContext, String key) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().remove(key).apply();
    }

    public static void delAll(Context mContext) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().clear().apply();
    }

}

