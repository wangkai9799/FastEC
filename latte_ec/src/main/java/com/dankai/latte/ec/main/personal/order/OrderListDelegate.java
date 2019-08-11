package com.dankai.latte.ec.main.personal.order;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.order
 *  文件名:    OrderListDelegate
 *  创建者:    WK
 *  时间：     2019/8/6 15:55
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.ec.main.personal.PersonalDelegate;
import com.dankai.latte.net.RestClient;
import com.dankai.latte.net.callback.ISuccess;
import com.dankai.latte.ui.recycler.MultipleItemEntity;

import java.util.List;

import butterknife.BindView;

public class OrderListDelegate extends LatteDelegate {

    private String mType = null;

    @BindView(R2.id.rv_order_list)
    RecyclerView mRecyclerView = null;

    private String mUrl = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_order_list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        mType = args.getString(PersonalDelegate.ORDER_TYPE);
        if (mType.equals(OrderRequestType.ALL.name())) {
            mUrl = "order_list_all.php";
        } else if (mType.equals(OrderRequestType.PAY.name())) {
            mUrl = "order_list_pay.php";
        } else if (mType.equals(OrderRequestType.RECEIVE.name())) {
            mUrl = "order_list_receive.php";
        } else if (mType.equals(OrderRequestType.EVALUATE.name())) {
            mUrl = "order_list_evaluate.php";
        } else {
            mUrl = "order_list_after_market.php";
        }
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .loader(getContext())
                .url(mUrl)
                .params("type", mType)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        mRecyclerView.setLayoutManager(manager);
                        final List<MultipleItemEntity> data =
                                new OrderListDataConverter()
                                        .setJsonData(response)
                                        .convert();
                        final OrderListAdapter adapter = new OrderListAdapter(data);
                        mRecyclerView.setAdapter(adapter);
                        mRecyclerView.addOnItemTouchListener(new OrderListClickListener(OrderListDelegate.this));
                    }
                })
                .build()
                .get();
    }
}
