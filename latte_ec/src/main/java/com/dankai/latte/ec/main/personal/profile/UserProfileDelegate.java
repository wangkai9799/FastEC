package com.dankai.latte.ec.main.personal.profile;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.profile
 *  文件名:    UserProfileDelegate
 *  创建者:    WK
 *  时间：     2019/8/6 17:04
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.ec.main.personal.list.ListAdapter;
import com.dankai.latte.ec.main.personal.list.ListBean;
import com.dankai.latte.ec.main.personal.list.ListItemType;
import com.dankai.latte.ec.main.personal.settings.NameDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UserProfileDelegate extends LatteDelegate {

    @BindView(R2.id.rv_user_profile)
    RecyclerView mRecyclerView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_user_profile;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        final ListBean avatar = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_AVATAR)
                .setId(1)
                .setImageUrl("http://10.0.2.2/Test/Img/test_image (1).jpg")
                .build();

        final ListBean name = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setText("姓名")
                .setDelegate(new NameDelegate())
                .setValue("未设置姓名")
                .build();

        final ListBean gender = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(3)
                .setText("性别")
                .setValue("未设置性别")
                .build();

        final ListBean birth = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(4)
                .setText("生日")
                .setValue("未设置生日")
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(avatar);
        data.add(name);
        data.add(gender);
        data.add(birth);

        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new UserProfileClickListener(this));
    }


}
