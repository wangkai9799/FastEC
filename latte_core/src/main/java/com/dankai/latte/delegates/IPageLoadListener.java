package com.dankai.latte.delegates;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates
 *  文件名:    IPageLoadListener
 *  创建者:    WK
 *  时间：     2019/8/3 16:24
 *  描述：     监听Web加载的事件
 */

public interface IPageLoadListener {

    void onLoadStart();

    void onLoadEnd();

}
