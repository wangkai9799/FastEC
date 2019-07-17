package com.dankai.latte.ec.launcher;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.launcher
 *  文件名:    LauncherDelegate
 *  创建者:    WK
 *  时间：     2019/7/14 21:39
 *  描述：     TODO
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.dankai.latte.app.AccountManager;
import com.dankai.latte.app.IUserChecker;
import com.dankai.latte.app.Latte;
import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.ui.launcher.ILauncherListener;
import com.dankai.latte.ui.launcher.OnLauncherFinishTag;
import com.dankai.latte.ui.launcher.ScrollLauncherTag;
import com.dankai.latte.util.storage.SharedUtils;
import com.dankai.latte.util.timer.BaseTimerTask;
import com.dankai.latte.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private Timer mTimer = null;
    private int mCount = 5;
    private ILauncherListener mILauncherListener = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
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
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    //判断是否显示滑动启动页面
    private void checkIsShowScroll() {
        if (!SharedUtils.getBoolean(Latte.getApplicationContext(), ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), false)) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
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
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.UNSIGNED);
                    }
                }
            });
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }
}
