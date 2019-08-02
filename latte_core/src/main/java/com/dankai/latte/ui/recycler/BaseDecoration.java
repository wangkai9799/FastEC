package com.dankai.latte.ui.recycler;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.recycler
 *  文件名:    BaseDecoration
 *  创建者:    WK
 *  时间：     2019/8/1 20:58
 *  描述：     TODO
 */

import androidx.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

public class BaseDecoration extends DividerItemDecoration {

    private BaseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(color, size));
    }

    public static BaseDecoration create(@ColorInt int color, int size) {
        return new BaseDecoration(color, size);
    }

}
