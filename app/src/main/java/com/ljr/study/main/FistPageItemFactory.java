package com.ljr.study.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljr.study.R;
import com.ljr.study.adapter.BaseViewHolder;
import com.ljr.study.adapter.ItemsViewHolderFactory;

public class FistPageItemFactory extends ItemsViewHolderFactory {
    @Override
    public BaseViewHolder createViewHolder(ViewGroup viewGroup, int type) {
        if (type == FirstPageItem.FIRST_PAGE_ITEM_TYPE) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.main_page_item, viewGroup, false);
            view.setTag("first page item");
            return new FirstPageViewHolder(view);
        } else if (type == LeadingItem.LEADING_ITEM_TYPE) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.main_page_item, viewGroup, false);
            view.setTag("main page item");
            return new FirstPageLeadingViewHolder(view);
        } else {
            return createEmptyViewHolder();
        }
    }
}
