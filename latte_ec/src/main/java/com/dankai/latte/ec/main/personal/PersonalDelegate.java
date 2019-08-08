package com.dankai.latte.ec.main.personal;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal
 *  文件名:    PersonalDelegate
 *  创建者:    WK
 *  时间：     2019/8/6 9:22
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dankai.latte.delegates.bottom.BottomItemDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.ec.main.personal.address.AddressDelegate;
import com.dankai.latte.ec.main.personal.list.ListAdapter;
import com.dankai.latte.ec.main.personal.list.ListBean;
import com.dankai.latte.ec.main.personal.list.ListItemType;
import com.dankai.latte.ec.main.personal.order.OrderListDelegate;
import com.dankai.latte.ec.main.personal.order.OrderRequestType;
import com.dankai.latte.ec.main.personal.profile.UserProfileDelegate;
import com.dankai.latte.ec.main.personal.settings.SettingsDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_personal_setting)
    RecyclerView mRvSettings = null;

    public static final String ORDER_TYPE = "ORDER_TYPE";
    private Bundle mArgs = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    private void startOrderListByType() {
        final OrderListDelegate delegate = new OrderListDelegate();
        delegate.setArguments(mArgs);
        getParentDelegate().start(delegate);
    }

    @OnClick(R2.id.tv_all_order)
    void onClickAllOrder() {
        mArgs.putString(ORDER_TYPE, OrderRequestType.ALL.toString());
        startOrderListByType();
    }

    @OnClick(R2.id.ll_pay)
    void onClickPay() {
        mArgs.putString(ORDER_TYPE, OrderRequestType.PAY.name());
        startOrderListByType();
    }

    @OnClick(R2.id.ll_receive)
    void onClickReceive() {
        mArgs.putString(ORDER_TYPE, OrderRequestType.RECEIVE.name());
        startOrderListByType();
    }

    @OnClick(R2.id.ll_evaluate)
    void onClickEvaluate() {
        mArgs.putString(ORDER_TYPE, OrderRequestType.EVALUATE.name());
        startOrderListByType();
    }

    @OnClick(R2.id.ll_after_market)
    void onClickAfterMarket() {
        mArgs.putString(ORDER_TYPE, OrderRequestType.AFTER_MARKET.name());
        startOrderListByType();
    }

    @OnClick(R2.id.img_user_avatar)
    void onClickAvatar() {
        getParentDelegate().start(new UserProfileDelegate());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArgs = new Bundle();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        final ListBean address = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
                .setDelegate(new AddressDelegate())
                .setText("收货地址")
                .build();

        final ListBean system = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setDelegate(new SettingsDelegate())
                .setText("系统设置")
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(address);
        data.add(system);

        //设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvSettings.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        mRvSettings.setAdapter(adapter);
        mRvSettings.addOnItemTouchListener(new PersonalClickListener(this));
    }
}
