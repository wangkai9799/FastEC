package com.dankai.latte.ec.main.personal.settings;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.settings
 *  文件名:    SettingsClickListener
 *  创建者:    WK
 *  时间：     2019/8/8 10:03
 *  描述：     TODO
 */

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.main.personal.list.ListBean;

public class SettingsClickListener extends SimpleClickListener {

    private final LatteDelegate DELEGATE;

    public SettingsClickListener(LatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final ListBean bean = (ListBean) baseQuickAdapter.getData().get(position);
        switch (bean.getId()) {
            case 1:
                //这是消息推送的开关
                break;
            case 2:
                DELEGATE.start(bean.getDelegate());
                break;
        }
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
