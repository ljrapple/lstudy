package com.ljr.study.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ljr.study.R;

public class IncludeAndMergeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        final int layoutId = intent.getIntExtra("layoutId", R.layout.first_merge_container);
        setContentView(layoutId);

        if (layoutId == R.layout.fifth_include_container) {
            View view = findViewById(R.id.fifth_include);
            TextView textView = findViewById(R.id.text);
            if (view != null) {
                textView.setText("Fifth layout : Id is valid");
            } else {
                textView.setText("Fifth layout : Id is invalid");
            }
        } else  if (layoutId == R.layout.six_include_container) {
            View view = findViewById(R.id.include_content_id);
            TextView textView = findViewById(R.id.text);
            if (view != null) {
                textView.setText("Sixth layout : Id is valid");
            } else {
                textView.setText("Sixth layout : Id is invalid");
            }
        }
    }
}
