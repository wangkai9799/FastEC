package com.dankai.latte.ec.main.sort;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.sort
 *  文件名:    SortDelegate
 *  创建者:    WK
 *  时间：     2019/7/18 18:19
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.dankai.latte.delegates.bottom.BottomItemDelegate;
import com.dankai.latte.ec.R;

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
