package com.ljr.study.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.ljr.study.utils.Logger;

@SuppressLint("AppCompatCustomView")
public class ValidView extends ImageView {
    public ValidView(Context context) {
        super(context);
        Logger.e("ValidView  1");
    }

    public ValidView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Logger.e("ValidView  2");
    }

    public ValidView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Logger.e("ValidView  3");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int modeW = MeasureSpec.getMode(widthMeasureSpec);
        int sizeW = MeasureSpec.getSize(widthMeasureSpec);
        int modeY = MeasureSpec.getMode(heightMeasureSpec);
        int sH = MeasureSpec.getSize(heightMeasureSpec);
        Logger.e("ValidView  onMeasure  mw =  " + modeW + "  ;  sw = " + sizeW
                + "  ;  my =  " + modeY  + "  ; sh =  " + sH);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void draw(Canvas canvas) {
        Logger.e("ValidView  draw  " + this);
        super.draw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Logger.e("ValidView  onDraw  " + this);
        super.onDraw(canvas);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        Logger.e("ValidView  layout  " + this);
        super.layout(l, t, r, b);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logger.e("ValidView  onLayout");
    }
}
