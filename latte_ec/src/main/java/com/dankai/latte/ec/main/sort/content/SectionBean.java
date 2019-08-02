package com.dankai.latte.ec.main.sort.content;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.sort.content
 *  文件名:    SectionBean
 *  创建者:    WK
 *  时间：     2019/8/2 13:04
 *  描述：     TODO
 */

import com.chad.library.adapter.base.entity.SectionEntity;

public class SectionBean extends SectionEntity<SectionContentItemEntity> {

    private boolean mIsMore = false;
    private int mId = -1;

    public SectionBean(SectionContentItemEntity sectionContentItemEntity) {
        super(sectionContentItemEntity);
    }

    public SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public boolean isMore() {
        return mIsMore;
    }

    public void setIsMore(boolean more) {
        mIsMore = more;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
