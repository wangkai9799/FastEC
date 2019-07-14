package com.dankai.latte.ec.icon;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.icon
 *  文件名:    FontEcModule
 *  创建者:    WK
 *  时间：     2019/7/13 19:07
 *  描述：     TODO
 */

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
