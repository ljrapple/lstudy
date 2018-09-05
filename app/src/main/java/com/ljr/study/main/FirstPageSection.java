package com.ljr.study.main;

import android.support.v4.util.Pair;

import com.ljr.study.adapter.BaseItem;
import com.ljr.study.adapter.Section;

import java.util.ArrayList;
import java.util.List;

public class FirstPageSection implements Section {

    public static final String HEAD_NAME = "HEAD";

    private final Pair<String, String>[] mPairs;

    public FirstPageSection(Pair<String, String>[] pair) {
        mPairs = pair;
    }

    @Override
    public List<BaseItem> getItemsList() {
        return toItemsList();
    }

    private List<BaseItem> toItemsList() {
        List<BaseItem> itemList = new ArrayList<>();
        int size = mPairs.length;
        for (int i = 0; i < size; i++) {
            Pair<String, String> pair = mPairs[i];
            if (pair.first.equals(HEAD_NAME)) {
                itemList.add(new LeadingItem(pair.second));
            } else {
                itemList.add(new FirstPageItem(pair.first, pair.second));
            }
        }
        return itemList;
    }
}
