package com.dankai.latte.ec.main.sort.content;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.sort.content
 *  文件名:    SectionContentItemEntity
 *  创建者:    WK
 *  时间：     2019/8/2 13:28
 *  描述：     TODO
 */

public class SectionContentItemEntity {

    private int mGoodsId = 0;
    private String mGoodsName = null;
    private String mGoodsThumb = null;

    public int getGoodsId() {
        return mGoodsId;
    }

    public void setGoodsId(int goodsId) {
        this.mGoodsId = goodsId;
    }

    public String getGoodsName() {
        return mGoodsName;
    }

    public void setGoodsName(String goodsName) {
        this.mGoodsName = goodsName;
    }

    public String getGoodsThumb() {
        return mGoodsThumb;
    }

    public void setGoodsThumb(String goodsThumb) {
        this.mGoodsThumb = goodsThumb;
    }
}
