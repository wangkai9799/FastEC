package com.dankai.latte.ec.main.sort.content;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.sort.content
 *  文件名:    SectionAdapter
 *  创建者:    WK
 *  时间：     2019/8/2 13:46
 *  描述：     TODO
 */

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dankai.latte.ec.R;

import java.util.List;

public class SectionAdapter extends BaseSectionQuickAdapter<SectionBean, BaseViewHolder> {

    private static final RequestOptions OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .dontAnimate();

    public SectionAdapter(int layoutResId, int sectionHeadResId, List<SectionBean> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder holder, SectionBean item) {
        holder.setText(R.id.header, item.header);
        holder.setVisible(R.id.more, item.isMore());
        holder.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, SectionBean item) {
        //item.t返回SectionBean类型
        final String goodsThumb = item.t.getGoodsThumb();
        final String goodsName = item.t.getGoodsName();
        final int goodsId = item.t.getGoodsId();
        final SectionContentItemEntity entity = item.t;
        holder.setText(R.id.tv, goodsName);
        final AppCompatImageView goodsImageView = holder.getView(R.id.iv);
        Glide.with(mContext)
                .load(goodsThumb)
                .apply(OPTIONS)
                .into(goodsImageView);
    }
}
