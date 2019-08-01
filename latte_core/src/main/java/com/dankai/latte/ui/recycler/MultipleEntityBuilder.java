package com.dankai.latte.ui.recycler;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.recycler
 *  文件名:    MultipleEntityBuilder
 *  创建者:    WK
 *  时间：     2019/7/31 17:27
 *  描述：     TODO
 */

import java.util.LinkedHashMap;

public class MultipleEntityBuilder {

    private static final LinkedHashMap<Object, Object> FIELDS = new LinkedHashMap<>();

    public MultipleEntityBuilder() {
        //先清除之前的数据
        FIELDS.clear();
    }

    public final MultipleEntityBuilder setItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE, itemType);
        return this;
    }

    public final MultipleEntityBuilder setField(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }

    public final MultipleEntityBuilder setFields(LinkedHashMap<?, ?> map) {
        FIELDS.putAll(map);
        return this;
    }

    public final MultipleItemEntity build() {
        return new MultipleItemEntity(FIELDS);
    }
}
