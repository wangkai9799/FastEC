package com.dankai.latte.ec.main.personal.settings;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.settings
 *  文件名:    InfoDelegate
 *  创建者:    WK
 *  时间：     2019/8/8 10:08
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

import com.alibaba.fastjson.JSON;
import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.net.RestClient;
import com.dankai.latte.net.callback.ISuccess;

import butterknife.BindView;

public class InfoDelegate extends LatteDelegate {

    @BindView(R2.id.tv_info)
    AppCompatTextView tvInfo = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_info;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        RestClient.builder()
                .url("about.php")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final String info = JSON.parseObject(response).getString("data");
                        tvInfo.setText(info);
                    }
                })
                .build()
                .get();
    }
}
