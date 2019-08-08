package com.dankai.latte.ui.camera;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.camera
 *  文件名:    RequestCodes
 *  创建者:    WK
 *  时间：     2019/8/6 18:08
 *  描述：     请求码存储
 */

import com.yalantis.ucrop.UCrop;

public class RequestCodes {

    public static final int TAKE_PHOTO = 4;
    public static final int PICK_PHOTO = 5;
    public static final int CROP_PHOTO = UCrop.REQUEST_CROP;
    public static final int CROP_ERROR = UCrop.RESULT_ERROR;
    public static final int SCAN = 7;

}
