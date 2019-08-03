package com.dankai.latte.net.rx;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.net.rx
 *  文件名:    AddCookieInterceptor
 *  创建者:    WK
 *  时间：     2019/8/3 16:44
 *  描述：     TODO
 */

import com.dankai.latte.util.storage.LattePreference;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class AddCookieInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        Observable
                .just(LattePreference.getCustomAppProfile("cookie"))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String cookie) throws Exception {
                        //给原生API请求附带上WebView拦截下来的Cookie
                        builder.addHeader("Cookie", cookie);
                    }
                });

        return chain.proceed(builder.build());
    }
}
