package com.dankai.latte.ui.scanner;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.scanner
 *  文件名:    LatteViewFinderView
 *  创建者:    WK
 *  时间：     2019/8/11 9:11
 *  描述：     TODO
 */

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import me.dm7.barcodescanner.core.ViewFinderView;

public class LatteViewFinderView extends ViewFinderView {
    public LatteViewFinderView(Context context) {
        this(context, null);
    }

    public LatteViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mSquareViewFinder = true;
        mBorderPaint.setColor(Color.YELLOW);
        mLaserPaint.setColor(Color.YELLOW);
    }
}
