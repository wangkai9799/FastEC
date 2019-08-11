package com.dankai.latte.ui.widget;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.ui.widget
 *  文件名:    CircleTextView
 *  创建者:    WK
 *  时间：     2019/8/11 14:37
 *  描述：     TODO
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;

public class CircleTextView extends AppCompatTextView {

    private final Paint PAINT;
    private final PaintFlagsDrawFilter FILTER;

    public CircleTextView(Context context) {
        this(context, null);
    }

    public CircleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        PAINT = new Paint();
        FILTER = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        PAINT.setColor(Color.WHITE);
        PAINT.setAntiAlias(true);
    }

    public final void setCircleBackground(@ColorInt int color) {
        PAINT.setColor(color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int width = getMeasuredWidth();
        final int height = getMeasuredHeight();
        final int max = Math.max(width, height);
        setMeasuredDimension(max, max);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(FILTER);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, PAINT);
        super.draw(canvas);
    }
}
