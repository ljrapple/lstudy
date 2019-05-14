package com.ljr.study.main;

import android.content.Context;
import android.content.Intent;

import com.ljr.study.adapter.BaseItem;
import com.ljr.study.adapter.ItemIdGenerator;
import com.ljr.study.utils.Check;

public class FirstPageItem extends BaseItem {

    public static final int FIRST_PAGE_ITEM_TYPE = ItemIdGenerator.getUniqueId();

    public final String name;
    public final String activityName;
    public int layoutId;

    public FirstPageItem(Object... objects) {
        Check.isTrue(objects.length >= 2);
        this.name = (String) objects[0];
        this.activityName = (String) objects[1];
        if (objects.length > 2) {
            layoutId = (int) objects[2];
        }
    }

    @Override
    public int getId() {
        return FIRST_PAGE_ITEM_TYPE;
    }

    public void onClick(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), activityName);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (layoutId != 0) {
            intent.putExtra("layoutId", layoutId);
        }
        context.startActivity(intent);
    }
}
