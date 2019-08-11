package com.dankai.latte.ec.main.index.search;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.index.search
 *  文件名:    SearchAdapter
 *  创建者:    WK
 *  时间：     2019/8/11 10:06
 *  描述：     TODO
 */

import androidx.annotation.NonNull;

import com.dankai.latte.ec.R;
import com.dankai.latte.ui.recycler.MultipleFields;
import com.dankai.latte.ui.recycler.MultipleItemEntity;
import com.dankai.latte.ui.recycler.MultipleRecyclerAdapter;
import com.dankai.latte.ui.recycler.MultipleViewHolder;

import java.util.List;

public class SearchAdapter extends MultipleRecyclerAdapter {

    protected SearchAdapter(List<MultipleItemEntity> data) {
        super(data);
        addItemType(SearchItemType.ITEM_SEARCH, R.layout.item_search);
    }

    @Override
    protected void convert(@NonNull MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (entity.getItemType()) {
            case SearchItemType.ITEM_SEARCH:
                holder.setText(R.id.tv_search_item, entity.getField(MultipleFields.TEXT));
                break;
            default:
                break;
        }
    }
}
