package com.dankai.latte.ui.camera;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.camera
 *  文件名:    LatteCamera
 *  创建者:    WK
 *  时间：     2019/8/6 18:07
 *  描述：     相机调用类
 */

import android.net.Uri;

import com.dankai.latte.delegates.PermissionCheckerDelegate;
import com.dankai.latte.util.file.FileUtil;

public class LatteCamera {

    public static Uri createCropFile() {
        return Uri.parse(FileUtil.createFile("crop_image",
                FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }

}
