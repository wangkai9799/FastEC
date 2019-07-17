package com.dankai.latte.app;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.app
 *  文件名:    AccountManager
 *  创建者:    WK
 *  时间：     2019/7/17 9:44
 *  描述：     管理用户信息
 */

import com.dankai.latte.util.storage.LattePreference;
import com.dankai.latte.util.storage.SharedUtils;

public class AccountManager {

    private enum SignTag {
        SIGN_TAG
    }

    //保存用户登录状态，登录后调用
    public static void setSignState(boolean state) {
        SharedUtils.putBoolean(Latte.getApplicationContext(), SignTag.SIGN_TAG.name(), state);
    }

    private static boolean isSignIn() {
        return SharedUtils.getBoolean(Latte.getApplicationContext(), SignTag.SIGN_TAG.name(), false);
    }

    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }


}
