package com.dankai.latte.ec.main.cart;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.cart
 *  文件名:    ShopCartAdapter
 *  创建者:    WK
 *  时间：     2019/8/3 20:55
 *  描述：     TODO
 */

import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dankai.latte.app.Latte;
import com.dankai.latte.ec.R;
import com.dankai.latte.ui.recycler.MultipleFields;
import com.dankai.latte.ui.recycler.MultipleItemEntity;
import com.dankai.latte.ui.recycler.MultipleRecyclerAdapter;
import com.dankai.latte.ui.recycler.MultipleViewHolder;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.List;

public class ShopCartAdapter extends MultipleRecyclerAdapter {

    private boolean mIsSelectedAll = false;

    private static final RequestOptions OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .dontAnimate();

    protected ShopCartAdapter(List<MultipleItemEntity> data) {
        super(data);
        //添加购物车Item布局
        addItemType(ShopCartItemType.SHOP_CART_ITEM, R.layout.item_shop_cart);
    }

    public void setIsSelectedAll(boolean isSelectedAll) {
        this.mIsSelectedAll = isSelectedAll;
    }

    @Override
    protected void convert(@NonNull MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ShopCartItemType.SHOP_CART_ITEM:
                final int id = entity.getField(MultipleFields.ID);
                final String title = entity.getField(ShopCartItemFields.TITLE);
                final String desc = entity.getField(ShopCartItemFields.DESC);
                final String thumb = entity.getField(MultipleFields.IMAGE_URL);
                final int count = entity.getField(ShopCartItemFields.COUNT);
                final double price = entity.getField(ShopCartItemFields.PRICE);
                holder.setText(R.id.tv_item_shop_cart_title, title);
                holder.setText(R.id.tv_item_shop_cart_count, String.valueOf(count));
                holder.setText(R.id.tv_item_shop_cart_desc, desc);
                holder.setText(R.id.tv_item_shop_cart_price, String.valueOf(price));
                final AppCompatImageView imgThumb = holder.getView(R.id.image_item_shop_cart);
                final IconTextView iconIsSelected = holder.getView(R.id.icon_item_shop_cart);
                Glide.with(mContext)
                        .load(thumb)
                        .apply(OPTIONS)
                        .into(imgThumb);
                //在左侧勾勾渲染之前改变全选与否状态
                entity.setField(ShopCartItemFields.IS_SELECTED, mIsSelectedAll);

                final boolean isSelected = entity.getField(ShopCartItemFields.IS_SELECTED);
                //根据数据状态显示左侧勾勾
                if (isSelected) {
                    iconIsSelected.setTextColor(ContextCompat.getColor(Latte.getApplicationContext(), R.color.app_main));
                } else {
                    iconIsSelected.setTextColor(Color.GRAY);
                }
                //添加左侧勾勾点击事件
                iconIsSelected.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final boolean currentSelected = entity.getField(ShopCartItemFields.IS_SELECTED);
                        if (currentSelected) {
                            iconIsSelected.setTextColor(Color.GRAY);
                            entity.setField(ShopCartItemFields.IS_SELECTED, false);
                        } else {
                            iconIsSelected.setTextColor(ContextCompat.getColor(Latte.getApplicationContext(), R.color.app_main));
                            entity.setField(ShopCartItemFields.IS_SELECTED, true);
                        }
                    }
                });
                break;
            default:
                break;
        }
    }
}
