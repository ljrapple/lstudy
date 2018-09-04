package com.ljr.study.adapter;

public abstract class BaseItem {

    public abstract int getId();

    public int getViewType() {
        return getId();
    }
}
