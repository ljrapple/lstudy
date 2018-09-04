package com.ljr.com.lapplication.adapter;

import android.view.ViewGroup;

public abstract class ItemsViewHolderFactory {

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int mOrientation = VERTICAL;

    public abstract BaseViewHolder createViewHolder(ViewGroup viewGroup, int type);

    protected BaseViewHolder createEmptyViewHolder() {
        return mOrientation == VERTICAL ? EmptyViewHolder.createVerEmptyViewHolder()
                : EmptyViewHolder.createHorEmptyViewHolder();
    }

    public int getOrientation() {
        return mOrientation;
    }

    public void setOrientation(int orientation) {
        mOrientation = orientation;
    }
}
