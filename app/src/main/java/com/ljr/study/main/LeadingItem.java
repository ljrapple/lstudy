package com.ljr.study.main;

import com.ljr.study.adapter.BaseItem;
import com.ljr.study.adapter.ItemIdGenerator;

public class LeadingItem extends BaseItem {
    public static final int LEADING_ITEM_TYPE = ItemIdGenerator.getUniqueId();

    public final String name;

    LeadingItem(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return LEADING_ITEM_TYPE;
    }
}
