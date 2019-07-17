package com.dankai.latte.ec.sign;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.sign
 *  文件名:    SignUpDelegate
 *  创建者:    WK
 *  时间：     2019/7/15 17:36
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
import com.dankai.latte.util.log.LatteLogger;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.et_sign_up_name)
    TextInputEditText mName = null;

    @BindView(R2.id.et_sign_up_email)
    TextInputEditText mEmail = null;

    @BindView(R2.id.et_sign_up_phone)
    TextInputEditText mPhone = null;

    @BindView(R2.id.et_sign_up_pwd)
    TextInputEditText mPwd = null;

    @BindView(R2.id.et_sign_up_re_pwd)
    TextInputEditText mRePwd = null;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        if (checkForm()) {
            RestClient.builder()
                    .url("Test/user_profile.json")
                    .params("name", mName.getText().toString())
                    .params("email", mEmail.getText().toString())
                    .params("phone", mPhone.getText().toString())
                    .params("pwd", mPwd.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            SignHandler.onSignUp(response, mISignListener);
                        }
                    })
                    .build()
                    .post();
            Toast.makeText(getContext(), "验证通过", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLink() {
        start(new SignInDelegate());
    }

    private boolean checkForm() {
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String pwd = mPwd.getText().toString();
        final String rePwd = mRePwd.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }


        if (name.isEmpty() || phone.length() != 11) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }

        if (pwd.isEmpty() || pwd.length() < 6) {
            mPwd.setError("请填写至少6位密码");
            isPass = false;
        } else {
            mPwd.setError(null);
        }

        if (rePwd.isEmpty() || rePwd.length() < 6 || !(rePwd.equals(pwd))) {
            mRePwd.setError("密码验证错误");
            isPass = false;
        } else {
            mRePwd.setError(null);
        }

        return isPass;

    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
