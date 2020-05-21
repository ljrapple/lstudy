package com.ljr.study.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.ljr.study.R;
import com.ljr.study.utils.Logger;

public class CustomLinearLayout extends LinearLayout {
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context,
            @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedValue =
                context.obtainStyledAttributes(attrs, R.styleable.AppCustomLinearLayout, 0, 0);
        float rate = typedValue.getFloat(R.styleable.AppCustomLinearLayout_app_rate, 0);
    }

    @Override
    public void setTag(Object tag) {
        super.setTag(tag);
        init();
    }

    private void init() {
//        Logger.setTag("logger : Custom " + getTag().toString());
        Logger.e(getTag().toString());
        setClickable(false);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.e("dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.e("onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.e("onTouchEvent  clickable =  " + isClickable());
        boolean result = super.onTouchEvent(event);
        Logger.e("onTouchEvent  result =  " + result);

        return result;
    }
}
