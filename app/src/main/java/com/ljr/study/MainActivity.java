package com.ljr.study;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ljr.study.adapter.ItemAdapter;
import com.ljr.study.main.DrawViewGroup;
import com.ljr.study.main.FirstPageSection;
import com.ljr.study.main.FistPageItemFactory;
import com.ljr.study.main.ItemArguments;
import com.ljr.study.utils.Logger;

public class MainActivity extends Activity {
    private ItemArguments<String, String, ?>[] mPairs = new ItemArguments[]{
            new ItemArguments(FirstPageSection.HEAD_NAME, "UI"),
            new ItemArguments("Layout Tag : merge and include", "com.ljr.study.ui.MIActivity")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ItemAdapter itemAdapter =
                new ItemAdapter(new FistPageItemFactory(), new FirstPageSection(mPairs));
        recyclerView.setAdapter(itemAdapter);
        final View view = findViewById(R.id.rotation);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(true) {
                    finish();
                    return;
                }
                ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(
                        view, View.ROTATION_X, -90, 90);
                rotationAnimator.setDuration(500);
                rotationAnimator.setInterpolator(new LinearInterpolator());
                ObjectAnimator startAlphaAnimator = ObjectAnimator.ofFloat(
                        view, View.ALPHA, 1.0f, 0.0f);
                startAlphaAnimator.setDuration(0);
                startAlphaAnimator.setStartDelay(0);
                ObjectAnimator enAlphaAnimator = ObjectAnimator.ofFloat(
                        view, View.ALPHA, .0f, 1.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                enAlphaAnimator.setDuration(0);
                enAlphaAnimator.setStartDelay(0);
                animatorSet.playSequentially(rotationAnimator, enAlphaAnimator);
                animatorSet.start();
            }
        });
        DrawViewGroup view1 = findViewById(R.id.draw_view);
        view1.setTag("view1");
        view1.setColor(Color.BLUE);
        view1.getParent().requestDisallowInterceptTouchEvent(true);
        findViewById(R.id.draw_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.e("DrawView:  onClick");
            }
        });
        findViewById(R.id.draw_view).setClickable(false);

        DrawViewGroup view2 = findViewById(R.id.draw_view1);
        view2.setTag("view2");
        view2.setColor(Color.RED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DrawViewGroup v = findViewById(R.id.draw_view);
        Logger.e("DrawView :  " + v.isChildrenDrawingOrderEnabledH());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LRJ","LRJ ---- onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("LRJ","LRJ  ----  onSaveInstanceState");
    }
    public void sayHello(){

    }
}
