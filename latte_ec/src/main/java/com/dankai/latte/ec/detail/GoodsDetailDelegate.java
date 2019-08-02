package com.dankai.latte.ec.detail;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.detail
 *  文件名:    GoodsDetailDelegate
 *  创建者:    WK
 *  时间：     2019/8/1 21:51
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class GoodsDetailDelegate extends LatteDelegate {

    public static GoodsDetailDelegate create() {
        return new GoodsDetailDelegate();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}
