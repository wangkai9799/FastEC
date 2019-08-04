package com.dankai.latte.ec.main.cart;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.cart
 *  文件名:    ShopCartDataConverter
 *  创建者:    WK
 *  时间：     2019/8/3 20:35
 *  描述：     TODO
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dankai.latte.ui.recycler.DataConverter;
import com.dankai.latte.ui.recycler.MultipleFields;
import com.dankai.latte.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

public class ShopCartDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final ArrayList<MultipleItemEntity> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final String title = data.getString("title");
            final String desc = data.getString("desc");
            final int id = data.getInteger("id");
            final double price = data.getDouble("price");
            final int count = data.getInteger("count");
            final String thumb = data.getString("thumb");
            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ShopCartItemType.SHOP_CART_ITEM)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.IMAGE_URL, thumb)
                    .setField(ShopCartItemFields.TITLE, title)
                    .setField(ShopCartItemFields.DESC, desc)
                    .setField(ShopCartItemFields.COUNT, count)
                    .setField(ShopCartItemFields.PRICE, price)
                    .setField(ShopCartItemFields.IS_SELECTED, false)
                    .setField(ShopCartItemFields.POSITION, i)
                    .build();

            dataList.add(entity);
        }
        return dataList;
    }
}
