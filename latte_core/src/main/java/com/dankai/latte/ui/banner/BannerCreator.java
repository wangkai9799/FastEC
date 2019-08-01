package com.dankai.latte.ui.banner;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.banner
 *  文件名:    BannerCreator
 *  创建者:    WK
 *  时间：     2019/8/1 10:12
 *  描述：     TODO
 */

import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.listener.OnBannerClickListener;
import com.ms.banner.transformer.DefaultTransformer;

import java.util.ArrayList;

public class BannerCreator {

    public static void setDefault(Banner banner, ArrayList<String> banners, OnBannerClickListener clickListener) {
        banner.setPages(banners, new ImageHolder())
                .setIndicatorGravity(BannerConfig.CENTER)
                .setOnBannerClickListener(clickListener)
                .setPageTransformer(true, new DefaultTransformer())
                .setDelayTime(3000)
                .setLoop(true)
                .start();
    }
}
