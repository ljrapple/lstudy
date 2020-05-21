package com.ljr.study.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.ljr.study.utils.Logger;

public class ValidLayout extends LinearLayout {
    public ValidLayout(Context context) {
        super(context);
        Logger.e("ValidLayout  1");
    }

    public ValidLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Logger.e("ValidLayout  2");
    }

    public ValidLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Logger.e("ValidLayout  3");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int modeW = MeasureSpec.getMode(widthMeasureSpec);
        int sizeW = MeasureSpec.getSize(widthMeasureSpec);
        int modeY = MeasureSpec.getMode(heightMeasureSpec);
        int sH = MeasureSpec.getSize(heightMeasureSpec);
        Logger.e("ValidLayout  onMeasure  mw =  " + modeW + "  ;  sw = " + sizeW
        + "  ;  my =  " + modeY  + "  ; sh =  " + sH);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Logger.e("ValidLayout  onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Logger.e("ValidLayout  onDraw");
    }

    @Override
    public void draw(Canvas canvas) {
        Logger.e("ValidLayout  draw");
        super.draw(canvas);
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Logger.e("ValidLayout  drawChild");
        return super.drawChild(canvas, child, drawingTime);
    }
}
