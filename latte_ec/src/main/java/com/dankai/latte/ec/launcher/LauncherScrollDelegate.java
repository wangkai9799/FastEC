package com.dankai.latte.ec.launcher;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.launcher
 *  文件名:    LauncherScrollDelegate
 *  创建者:    WK
 *  时间：     2019/7/15 14:04
 *  描述：     TODO
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;


import com.dankai.latte.app.AccountManager;
import com.dankai.latte.app.IUserChecker;
import com.dankai.latte.app.Latte;
import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.ui.launcher.ILauncherListener;
import com.dankai.latte.ui.launcher.LauncherHolder;
import com.dankai.latte.ui.launcher.OnLauncherFinishTag;
import com.dankai.latte.ui.launcher.ScrollLauncherTag;
import com.dankai.latte.util.storage.SharedUtils;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.holder.BannerViewHolder;
import com.ms.banner.listener.OnBannerClickListener;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LauncherScrollDelegate extends LatteDelegate implements OnBannerClickListener {

    @BindView(R2.id.banner)
    Banner mBanner = null;

    private ILauncherListener mILauncherListener = null;

    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner() {
        INTEGERS.add(R.drawable.launcher_01);
        INTEGERS.add(R.drawable.launcher_02);
        INTEGERS.add(R.drawable.launcher_03);
        INTEGERS.add(R.drawable.launcher_04);
        INTEGERS.add(R.drawable.launcher_05);
        mBanner.setPages(INTEGERS, new LauncherHolder());
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.setOnBannerClickListener(this);
        mBanner.start();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_scroll_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onBannerClick(List datas, int position) {
        //如果点击的是最后一个
        if (position == INTEGERS.size() - 1) {
            SharedUtils.putBoolean(Latte.getApplicationContext(), ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), true);
            //检查用户是否登录了APP
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }
}
