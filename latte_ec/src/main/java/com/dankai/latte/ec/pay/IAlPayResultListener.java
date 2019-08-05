package com.dankai.latte.ec.pay;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ec.pay
 *  文件名:    IAlPayResultListener
 *  创建者:    WK
 *  时间：     2019/8/5 15:07
 *  描述：     TODO
 */

public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();

}
