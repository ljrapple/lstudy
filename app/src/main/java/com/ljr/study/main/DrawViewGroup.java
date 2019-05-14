package com.ljr.study.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

public class DrawViewGroup extends ViewGroup {
    public DrawViewGroup(Context context) {
        super(context);
    }

    public DrawViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(Color.BLUE);
        paint.setAntiAlias(false);
        float center = Math.min(getWidth(), getHeight()) / 2;
        canvas.drawCircle(center, center, center, paint);
    }
}
