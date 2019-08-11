package com.dankai.latte.ec.main.index.search;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.index.search
 *  文件名:    SearchDataConverter
 *  创建者:    WK
 *  时间：     2019/8/11 9:58
 *  描述：     TODO
 */

import com.alibaba.fastjson.JSONArray;
import com.dankai.latte.ui.recycler.DataConverter;
import com.dankai.latte.ui.recycler.MultipleFields;
import com.dankai.latte.ui.recycler.MultipleItemEntity;
import com.dankai.latte.util.storage.LattePreference;

import java.util.ArrayList;

public class SearchDataConverter extends DataConverter {

    public static final String TAG_SEARCH_HISTORY = "search_history";

    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final String jsonStr = LattePreference.getCustomAppProfile(TAG_SEARCH_HISTORY);
        if (!jsonStr.equals("")) {
            final JSONArray array = JSONArray.parseArray(jsonStr);
            final int size = array.size();
            for (int i = 0; i < size; i++) {
                final String historyItemText = array.getString(i);
                final MultipleItemEntity entity = MultipleItemEntity.builder()
                        .setItemType(SearchItemType.ITEM_SEARCH)
                        .setField(MultipleFields.TEXT, historyItemText)
                        .build();
                ENTITIES.add(entity);
            }
        }
        return ENTITIES;
    }
}
