package com.ljr.study.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class PathMeasureView extends View {
    private final Paint mPaint;
    private Path mPath;
    private PathMeasure mPathMeasure;
    private final float mCurrentPosition[] = new float[2];
    private final RectF mRectF = new RectF();
    private float mStartAngle;
    private float mSwepAngle;

    public PathMeasureView(Context context) {
        this(context, null);
    }

    public PathMeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (mPath == null) {
            int center = Math.min(width, height) / 2;
            mPath = new Path();
            mPath.addCircle(center, center, center - 10, Path.Direction.CW);
            mPathMeasure = new PathMeasure(mPath, true);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    startPathAnim(500);
                }
            }, 200);
        }

        mPaint.setColor(Color.GRAY);
        canvas.drawPath(mPath, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCurrentPosition[0], mCurrentPosition[1], 10, mPaint);
//        canvas.drawArc(mRectF, mStartAngle, mSwepAngle, true, mPaint);
    }

    // 开启路径动画
    public void startPathAnim(long duration) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        Log.i("PathMeasureT", "PathMeasureT measure length = " + mPathMeasure.getLength());
        valueAnimator.setDuration(duration);
        valueAnimator.setRepeatCount(200);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                Log.i("PathMeasureT", "PathMeasureT measure value = " + value);
                mPathMeasure.getPosTan(value, mCurrentPosition, null);
                postInvalidate();
            }
        });
        valueAnimator.start();

    }
}
