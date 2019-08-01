package com.dankai.latte.ui.recycler;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.recycler
 *  文件名:    DataConverter
 *  创建者:    WK
 *  时间：     2019/7/31 17:09
 *  描述：     数据转换的一个约束
 */

import java.util.ArrayList;

public abstract class DataConverter {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS NULL");
        }
        return mJsonData;
    }

    public void clearData() {
        ENTITIES.clear();
    }

}
