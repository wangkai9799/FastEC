package com.dankai.latte.ec.main.personal;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal
 *  文件名:    PersonalClickListener
 *  创建者:    WK
 *  时间：     2019/8/7 17:40
 *  描述：     TODO
 */

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.main.personal.list.ListBean;

public class PersonalClickListener extends SimpleClickListener {

    private final LatteDelegate DELEGATE;

    public PersonalClickListener(LatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final ListBean bean = (ListBean) baseQuickAdapter.getData().get(position);
        int id = bean.getId();
        switch (id) {
            case 1:
                DELEGATE.getParentDelegate().start(bean.getDelegate());
                break;
            case 2:
                DELEGATE.getParentDelegate().start(bean.getDelegate());
                break;
            default:
                DELEGATE.getParentDelegate().start(bean.getDelegate());
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
