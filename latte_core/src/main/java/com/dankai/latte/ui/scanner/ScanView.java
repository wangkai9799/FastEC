package com.dankai.latte.ui.scanner;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.scanner
 *  文件名:    ScanView
 *  创建者:    WK
 *  时间：     2019/8/11 9:09
 *  描述：     TODO
 */

import android.content.Context;
import android.util.AttributeSet;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class ScanView extends ZBarScannerView {

    public ScanView(Context context) {
        this(context, null);
    }

    public ScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected IViewFinder createViewFinderView(Context context) {
        return new LatteViewFinderView(context);
    }
}
