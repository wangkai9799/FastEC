package com.dankai.latte.ui.scanner;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.scanner
 *  文件名:    ScannerDelegate
 *  创建者:    WK
 *  时间：     2019/8/11 9:07
 *  描述：     TODO
 */

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.dankai.latte.delegates.LatteDelegate;
import com.dankai.latte.ui.camera.RequestCodes;
import com.dankai.latte.util.callback.CallBackManager;
import com.dankai.latte.util.callback.CallBackType;
import com.dankai.latte.util.callback.IGlobalCallback;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class ScannerDelegate extends LatteDelegate implements ZBarScannerView.ResultHandler {

    private ScanView mScanView = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mScanView == null) {
            mScanView = new ScanView(getContext());
        }
        mScanView.setAutoFocus(true);
        mScanView.setResultHandler(this);
    }

    @Override
    public Object setLayout() {
        return mScanView;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mScanView != null) {
            mScanView.startCamera();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mScanView != null) {
            mScanView.stopCameraPreview();
            mScanView.stopCamera();
        }
    }

    @Override
    public void handleResult(Result rawResult) {
        @SuppressWarnings("unchecked") final IGlobalCallback<String> callback = CallBackManager
                .getInstance()
                .getCallback(CallBackType.ON_SCAN);
        if (callback != null) {
            callback.executeCallback(rawResult.getContents());
        }
        getSupportDelegate().pop();
    }
}
