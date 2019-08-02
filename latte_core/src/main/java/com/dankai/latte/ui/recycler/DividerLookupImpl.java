package com.dankai.latte.ui.recycler;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.recycler
 *  文件名:    DividerLookupImpl
 *  创建者:    WK
 *  时间：     2019/8/1 21:01
 *  描述：     TODO
 */

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

public class DividerLookupImpl implements DividerItemDecoration.DividerLookup {

    private final int COLOR;
    private final int SIZE;

    public DividerLookupImpl(int color, int size) {
        this.COLOR = color;
        this.SIZE = size;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider.Builder()
                .size(SIZE)
                .color(COLOR)
                .build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return new Divider.Builder()
                .size(SIZE)
                .color(COLOR)
                .build();
    }
}
