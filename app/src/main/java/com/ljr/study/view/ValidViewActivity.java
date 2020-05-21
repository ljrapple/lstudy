package com.ljr.study.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ljr.study.R;

public class ValidViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valid_view_layout);
        testRequestLayout();

        findViewById(R.id.drag).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(null, shadowBuilder, ((ImageView) view).getDrawable(), 0);
                return true;
            }
        });
    }

    private void testValidate(){
        final View viewC = findViewById(R.id.view);
        final View layout = findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ViewGroup.LayoutParams params = viewC.getLayoutParams();
//                params.width = 50;
//                viewC.setLayoutParams(params);
                layout.invalidate();
            }
        });

        viewC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams params = viewC.getLayoutParams();
                params.width = 50;
                viewC.setLayoutParams(params);
                viewC.invalidate();
            }
        });

    }

    private void testRequestLayout(){
        final View viewC = findViewById(R.id.view);
        final View layout = findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewC.setBackgroundColor(Color.RED);
                layout.requestLayout();
            }
        });

        viewC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewC.setBackgroundColor(Color.RED);
                viewC.requestLayout();
            }
        });
    }
}
