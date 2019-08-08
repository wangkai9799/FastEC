package com.dankai.latte.ec.main.personal.address;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.address
 *  文件名:    AddressDataConverter
 *  创建者:    WK
 *  时间：     2019/8/7 17:10
 *  描述：     TODO
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dankai.latte.ui.recycler.DataConverter;
import com.dankai.latte.ui.recycler.MultipleFields;
import com.dankai.latte.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

public class AddressDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {

        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);

            final int id = data.getInteger("id");
            final String name = data.getString("name");
            final String phone = data.getString("phone");
            final String address = data.getString("address");
            boolean isDefault = data.getBoolean("default");

            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setItemType(AddressItemType.ITEM_ADDRESS)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.NAME, name)
                    .setField(MultipleFields.TAG, isDefault)
                    .setField(AddressFields.PHONE, phone)
                    .setField(AddressFields.ADDRESS, address)
                    .build();
            ENTITIES.add(entity);
        }
        return ENTITIES;
    }
}
