package com.ljr.study;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.ljr.study.adapter.ItemAdapter;
import com.ljr.study.main.FirstPageSection;
import com.ljr.study.main.FistPageItemFactory;
import com.ljr.study.main.ItemArguments;

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
}
