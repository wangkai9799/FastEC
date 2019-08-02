package com.dankai.latte.ui.recycler;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.recycler
 *  文件名:    RgbValue
 *  创建者:    WK
 *  时间：     2019/8/1 21:25
 *  描述：     存储 红色、绿色、蓝色 色值
 */

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RgbValue {

    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }
}
