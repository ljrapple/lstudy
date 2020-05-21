package com.ljr.study.ui;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context,
            @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
