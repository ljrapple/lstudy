package com.ljr.study.main;

import android.content.Context;
import android.content.Intent;

import com.ljr.study.adapter.BaseItem;
import com.ljr.study.adapter.ItemIdGenerator;

public class FirstPageItem extends BaseItem {

    public static final int FIRST_PAGE_ITEM_TYPE = ItemIdGenerator.getUniqueId();

    public final String name;
    public final String activityName;

    public FirstPageItem(String name, String activityName) {
        this.name = name;
        this.activityName = activityName;
    }

    @Override
    public int getId() {
        return FIRST_PAGE_ITEM_TYPE;
    }

    public void onClick(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), activityName);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
