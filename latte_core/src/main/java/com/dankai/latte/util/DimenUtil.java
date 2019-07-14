package com.dankai.latte.util;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.util
 *  文件名:    DimenUtil
 *  创建者:    WK
 *  时间：     2019/7/14 16:06
 *  描述：     TODO
 */

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.dankai.latte.app.Latte;

public class DimenUtil {

    //得到屏幕的宽
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    //得到屏幕的宽
    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
