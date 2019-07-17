package com.dankai.latte.ui.launcher;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.launcher
 *  文件名:    LauncherHolder
 *  创建者:    WK
 *  时间：     2019/7/15 16:56
 *  描述：     TODO
 */

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import com.ms.banner.holder.BannerViewHolder;

public class LauncherHolder implements BannerViewHolder<Integer> {

    private AppCompatImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void onBind(Context context, int position, Integer data) {
        mImageView.setBackgroundResource(data);
    }
}
