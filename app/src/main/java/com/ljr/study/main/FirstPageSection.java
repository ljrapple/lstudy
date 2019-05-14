package com.ljr.study.main;

import com.ljr.study.adapter.BaseItem;
import com.ljr.study.adapter.Section;

import java.util.ArrayList;
import java.util.List;

public class FirstPageSection implements Section {

    public static final String HEAD_NAME = "HEAD";

    private final ItemArguments<?, ?, ?>[] mPairs;

    public FirstPageSection(ItemArguments<?, ?, ?>[] pair) {
        mPairs = pair;
    }

    @Override
    public List<BaseItem> getItemsList() {
        return toItemsList();
    }

    protected List<BaseItem> toItemsList() {
        List<BaseItem> itemList = new ArrayList<>();
        int size = mPairs.length;
        for (int i = 0; i < size; i++) {
            ItemArguments<?, ?, ?> pair = mPairs[i];
            if (pair.first.equals(HEAD_NAME)) {
                itemList.add(new LeadingItem((String) pair.second));
            } else {
                if (pair.third != null) {
                    itemList.add(new FirstPageItem(pair.first, pair.second, pair.third));
                } else {
                    itemList.add(new FirstPageItem(pair.first, pair.second));
                }
            }
        }
        return itemList;
    }
}
