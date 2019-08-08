package com.dankai.latte.ui.camera;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.camera
 *  文件名:    CameraImageBean
 *  创建者:    WK
 *  时间：     2019/8/6 18:08
 *  描述：     存储一些中间值
 */

import android.net.Uri;

public final class CameraImageBean {

    private Uri mPath = null;

    private static final CameraImageBean INSTANCE = new CameraImageBean();

    public static CameraImageBean getInstance() {
        return INSTANCE;
    }

    public Uri getPath() {
        return mPath;
    }

    public void setPath(Uri path) {
        mPath = path;
    }
}
