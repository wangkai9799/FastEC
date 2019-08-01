package com.dankai.latte.delegates.bottom;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.bottom
 *  文件名:    BottomTabBean
 *  创建者:    WK
 *  时间：     2019/7/18 15:26
 *  描述：     TODO
 */

public final class BottomTabBean {
    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
