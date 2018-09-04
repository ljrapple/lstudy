package com.ljr.com.lapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void onBound(BaseItem item) {
    }
}
