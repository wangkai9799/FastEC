package com.dankai.latte.ui.banner;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.banner
 *  文件名:    ImageHolder
 *  创建者:    WK
 *  时间：     2019/8/1 10:12
 *  描述：     TODO
 */

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ms.banner.holder.BannerViewHolder;

public class ImageHolder implements BannerViewHolder<String> {

    private AppCompatImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void onBind(Context context, int position, String data) {
        Glide.with(context)
                .load(data)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .centerCrop()
                .into(mImageView);
    }
}
