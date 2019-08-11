package com.dankai.latte.ec.main.personal.order;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.order
 *  文件名:    OrderListClickListener
 *  创建者:    WK
 *  时间：     2019/8/8 14:21
 *  描述：     TODO
 */

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;

public class OrderListClickListener extends SimpleClickListener {

    private final OrderListDelegate DELEGATE;

    public OrderListClickListener(OrderListDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        DELEGATE.start(new OrderCommentDelegate());
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
