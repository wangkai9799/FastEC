package com.dankai.latte.ec.main.personal.settings;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.settings
 *  文件名:    SettingsDelegate
 *  创建者:    WK
 *  时间：     2019/8/8 9:31
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.ec.main.personal.address.AddressDelegate;
import com.dankai.latte.ec.main.personal.list.ListAdapter;
import com.dankai.latte.ec.main.personal.list.ListBean;
import com.dankai.latte.ec.main.personal.list.ListItemType;
import com.dankai.latte.util.callback.CallBackManager;
import com.dankai.latte.util.callback.CallBackType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SettingsDelegate extends LatteDelegate {

    @BindView(R2.id.rv_settings)
    RecyclerView mRecyclerView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_settings;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        final ListBean push = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_SWITCH)
                .setId(1)
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            Toast.makeText(getContext(), "打开推送", Toast.LENGTH_SHORT).show();
                            CallBackManager.getInstance().getCallback(CallBackType.TAG_OPEN_PUSH).executeCallback(null);
                        } else {
                            Toast.makeText(getContext(), "关闭推送", Toast.LENGTH_SHORT).show();
                            CallBackManager.getInstance().getCallback(CallBackType.TAG_STOP_PUSH).executeCallback(null);
                        }
                    }
                })
                .setText("消息推送")
                .build();

        final ListBean about = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setText("关于")
                .setDelegate(new InfoDelegate())
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(push);
        data.add(about);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        ListAdapter adapter = new ListAdapter(data);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new SettingsClickListener(this));
    }
}
