package com.dankai.latte.ec.main.personal.settings;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.settings
 *  文件名:    NameDelegate
 *  创建者:    WK
 *  时间：     2019/8/6 17:41
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;

public class NameDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_name;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
