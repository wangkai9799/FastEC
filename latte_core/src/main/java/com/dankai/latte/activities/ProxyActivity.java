package com.dankai.latte.activities;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.activities
 *  文件名:    ProxyActivity
 *  创建者:    WK
 *  时间：     2019/7/13 19:50
 *  描述：     TODO
 */

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.dankai.latte.R;
import com.dankai.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final FrameLayout container = new FrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
