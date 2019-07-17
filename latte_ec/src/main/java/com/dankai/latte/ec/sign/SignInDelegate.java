package com.dankai.latte.ec.sign;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.sign
 *  文件名:    SignInDelegate
 *  创建者:    WK
 *  时间：     2019/7/16 14:45
 *  描述：     TODO
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ec.R;
import com.dankai.latte.ec.R2;
import com.dankai.latte.net.RestClient;
import com.dankai.latte.net.callback.ISuccess;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.et_sign_in_email)
    TextInputEditText mEmail = null;

    @BindView(R2.id.et_sign_in_pwd)
    TextInputEditText mPwd = null;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            if (checkForm()) {
                RestClient.builder()
                        .url("Test/user_profile.json")
                        .params("email", mEmail.getText().toString())
                        .params("pwd", mPwd.getText().toString())
                        .success(new ISuccess() {
                            @Override
                            public void onSuccess(String response) {
                                SignHandler.onSignIn(response, mISignListener);
                            }
                        })
                        .build()
                        .post();
                Toast.makeText(getContext(), "验证通过", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat() {

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        start(new SignUpDelegate());
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String pwd = mPwd.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (pwd.isEmpty() || pwd.length() < 6) {
            mPwd.setError("请填写至少6位密码");
            isPass = false;
        } else {
            mPwd.setError(null);
        }

        return isPass;

    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }


}
