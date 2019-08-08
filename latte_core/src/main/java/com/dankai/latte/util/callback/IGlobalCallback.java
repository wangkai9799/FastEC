package com.dankai.latte.util.callback;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.util.callback
 *  文件名:    IGlobalCallback
 *  创建者:    WK
 *  时间：     2019/8/7 15:15
 *  描述：     TODO
 */

import androidx.annotation.Nullable;

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);

}
