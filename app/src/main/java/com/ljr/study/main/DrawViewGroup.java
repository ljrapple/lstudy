package com.ljr.study.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.ViewGroup;

import com.ljr.study.utils.Logger;


public class DrawViewGroup extends ViewGroup {

    private Paint mPaint;
    public DrawViewGroup(Context context) {
        this(context, null);
    }

    public DrawViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Logger.e("DrawView: setWillNotDraw is  " + isChildrenDrawingOrderEnabledH());
        setClickable(false);
        setTouchDelegate(new TouchDelegate(new Rect(), this){
            @Override
            public boolean onTouchEvent(MotionEvent event) {
                Logger.e("DrawView: TouchDelegate is  " + isChildrenDrawingOrderEnabledH());
                return super.onTouchEvent(event);
            }
        });
        mPaint = new Paint();
        setWillNotDraw(false);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Logger.e("DrawView: onDraw is  " + isChildrenDrawingOrderEnabledH());
        mPaint.setAntiAlias(false);
        float center = Math.min(getWidth(), getHeight()) / 2;
        canvas.drawCircle(center, center, center, mPaint);
    }

    public Object isChildrenDrawingOrderEnabledH() {
        return getTag();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.e("DrawView: dispatchTouchEvent is  " + isChildrenDrawingOrderEnabledH());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.e("DrawView: onTouchEvent is  " + isChildrenDrawingOrderEnabledH()
        + "  ; action =  " + event.getAction());
        return super.onTouchEvent(event);
    }

    public void setColor(int color){
        mPaint.setColor(color);
    }
}
