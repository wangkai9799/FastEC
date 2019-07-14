package com.dankai.latte.ec.icon;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.icon
 *  文件名:    EcIcons
 *  创建者:    WK
 *  时间：     2019/7/13 19:09
 *  描述：     TODO
 */

import com.joanzapata.iconify.Icon;

public enum EcIcons implements Icon {
    icon_scan('\ue65c'),
    icon_ali_pay('\ue717');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace("_", "-");
    }

    @Override
    public char character() {
        return character;
    }
}
