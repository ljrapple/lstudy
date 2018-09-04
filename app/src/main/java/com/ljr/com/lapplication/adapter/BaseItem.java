package com.ljr.com.lapplication.adapter;

public abstract class BaseItem {

    public abstract int getId();

    public int getViewType() {
        return getId();
    }
}
