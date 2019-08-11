package com.dankai.latte.ec.main.index;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.index
 *  文件名:    IndexItemClickListener
 *  创建者:    WK
 *  时间：     2019/8/1 21:42
 *  描述：     TODO
 */

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.detail.GoodsDetailDelegate;
import com.dankai.latte.ui.recycler.MultipleFields;
import com.dankai.latte.ui.recycler.MultipleItemEntity;

public class IndexItemClickListener extends SimpleClickListener {

    private final LatteDelegate DELEGATE;

    private IndexItemClickListener(LatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    public static SimpleClickListener create(LatteDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final MultipleItemEntity entity = (MultipleItemEntity) baseQuickAdapter.getData().get(position);
        final int goodsId = entity.getField(MultipleFields.ID);
        final GoodsDetailDelegate delegate = GoodsDetailDelegate.create(goodsId);
        DELEGATE.start(delegate);
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
