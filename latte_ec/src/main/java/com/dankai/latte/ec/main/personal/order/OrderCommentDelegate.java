package com.dankai.latte.ec.main.personal.order;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.main.personal.order
 *  文件名:    OrderCommentDelegate
 *  创建者:    WK
 *  时间：     2019/8/8 14:18
 *  描述：     TODO
 */

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.ui.widget.AutoPhotoLayout;
import com.dankai.latte.ui.widget.StarLayout;
import com.dankai.latte.util.callback.CallBackManager;
import com.dankai.latte.util.callback.CallBackType;
import com.dankai.latte.util.callback.IGlobalCallback;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderCommentDelegate extends LatteDelegate {

    @BindView(R2.id.custom_star_layout)
    StarLayout mStarLayout = null;
    @BindView(R2.id.custom_auto_photo_layout)
    AutoPhotoLayout mAutoPhotoLayout = null;

    @OnClick(R2.id.top_tv_comment_commit)
    void onClickCommit() {
        Toast.makeText(getContext(), "评分：" + mStarLayout.getStarCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_order_comment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mAutoPhotoLayout.setDelegate(this);
        CallBackManager.getInstance()
                .addCallback(CallBackType.ON_CROP, new IGlobalCallback<Uri>() {
                    @Override
                    public void executeCallback(@Nullable Uri args) {
                        mAutoPhotoLayout.onCropTarget(args);
                    }
                });
    }
}
