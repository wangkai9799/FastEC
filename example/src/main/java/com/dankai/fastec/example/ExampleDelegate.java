package com.dankai.fastec.example;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.fastec.example
 *  文件名:    ExampleDelegate
 *  创建者:    WK
 *  时间：     2019/7/13 20:26
 *  描述：     TODO
 */

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.net.RestClient;
import com.dankai.latte.net.callback.IError;
import com.dankai.latte.net.callback.IFailure;
import com.dankai.latte.net.callback.ISuccess;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("index.php/")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(getContext(), msg + code, Toast.LENGTH_SHORT).show();
                    }
                }).build()
                .get();
    }
}
