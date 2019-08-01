package com.dankai.latte.delegates.bottom;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.bottom
 *  文件名:    ItemBuilder
 *  创建者:    WK
 *  时间：     2019/7/18 15:31
 *  描述：     TODO
 */

import java.util.LinkedHashMap;

public final class ItemBuilder {
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bean, BottomItemDelegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean, BottomItemDelegate> build() {
        return ITEMS;
    }


}
