package com.ljr.com.lapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;

import com.ljr.com.lapplication.R;
import com.ljr.com.lapplication.utils.App;

public class EmptyViewHolder extends BaseViewHolder {
    private EmptyViewHolder(View itemView) {
        super(itemView);
    }

    public static EmptyViewHolder createVerEmptyViewHolder() {
        final View view =
                LayoutInflater.from(App.getContext()).inflate(R.layout.empty_item_ver, null);
        return new EmptyViewHolder(view);
    }

    public static EmptyViewHolder createHorEmptyViewHolder() {
        final View view =
                LayoutInflater.from(App.getContext()).inflate(R.layout.empty_item_hor, null);
        return new EmptyViewHolder(view);
    }
}
