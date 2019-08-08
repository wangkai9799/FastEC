package com.dankai.latte.ec.main.personal.address;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.address
 *  文件名:    AddressAdapter
 *  创建者:    WK
 *  时间：     2019/8/7 17:22
 *  描述：     TODO
 */

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import com.dankai.latte.ec.R;
import com.dankai.latte.net.RestClient;
import com.dankai.latte.net.callback.ISuccess;
import com.dankai.latte.ui.recycler.MultipleFields;
import com.dankai.latte.ui.recycler.MultipleItemEntity;
import com.dankai.latte.ui.recycler.MultipleRecyclerAdapter;
import com.dankai.latte.ui.recycler.MultipleViewHolder;

import java.util.List;

public class AddressAdapter extends MultipleRecyclerAdapter {

    protected AddressAdapter(List<MultipleItemEntity> data) {
        super(data);
        addItemType(AddressItemType.ITEM_ADDRESS, R.layout.item_address);
    }

    @Override
    protected void convert(@NonNull MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case AddressItemType.ITEM_ADDRESS:
                final String name = entity.getField(MultipleFields.NAME);
                final String phone = entity.getField(AddressFields.PHONE);
                final String address = entity.getField(AddressFields.ADDRESS);
                final boolean isDefault = entity.getField(MultipleFields.TAG);
                final int id = entity.getField(MultipleFields.ID);

                final AppCompatTextView nameText = holder.getView(R.id.tv_address_name);
                final AppCompatTextView phoneText = holder.getView(R.id.tv_address_phone);
                final AppCompatTextView addressText = holder.getView(R.id.tv_address_address);
                final AppCompatTextView deleteTextView = holder.getView(R.id.tv_address_delete);
                nameText.setText(name);
                phoneText.setText(phone);
                addressText.setText(address);

                deleteTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RestClient.builder()
                                .url("address.php")
                                .params("id", id)
                                .success(new ISuccess() {
                                    @Override
                                    public void onSuccess(String response) {
                                        remove(holder.getAdapterPosition());
                                    }
                                })
                                .build()
                                .post();
                    }
                });
                break;
            default:
                break;
        }
    }
}
