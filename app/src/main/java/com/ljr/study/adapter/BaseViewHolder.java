package com.ljr.study.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void onBound(BaseItem item) {
    }
}
