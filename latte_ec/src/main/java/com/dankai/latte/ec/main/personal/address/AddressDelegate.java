package com.dankai.latte.ec.main.personal.address;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.address
 *  文件名:    AddressDelegate
 *  创建者:    WK
 *  时间：     2019/8/7 17:31
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
import com.dankai.latte.net.RestClient;
import com.dankai.latte.net.callback.ISuccess;
import com.dankai.latte.ui.recycler.MultipleItemEntity;

import java.util.List;

import butterknife.BindView;

public class AddressDelegate extends LatteDelegate implements ISuccess {

    @BindView(R2.id.rv_address)
    RecyclerView mRecyclerView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_address;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        RestClient.builder()
                .url("address.php")
                .loader(getContext())
                .success(this)
                .build()
                .post();
    }

    @Override
    public void onSuccess(String response) {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        List<MultipleItemEntity> data = new AddressDataConverter().setJsonData(response).convert();
        final AddressAdapter adapter = new AddressAdapter(data);
        mRecyclerView.setAdapter(adapter);
    }
}
