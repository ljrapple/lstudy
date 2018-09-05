package com.ljr.study.main;

import android.support.v4.widget.Space;
import android.view.View;
import android.widget.TextView;

import com.ljr.study.R;
import com.ljr.study.adapter.BaseItem;
import com.ljr.study.adapter.BaseViewHolder;
import com.ljr.study.utils.Check;
import com.ljr.study.utils.ViewUtils;

public class FirstPageLeadingViewHolder extends BaseViewHolder {

    private TextView mTextView;
    private Space mSpace;

    public FirstPageLeadingViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.main_item_name);
        mSpace = itemView.findViewById(R.id.main_item_space);
    }

    @Override
    public void onBound(BaseItem item) {
        Check.isTrue(item instanceof LeadingItem);
        LeadingItem firstPageItem = (LeadingItem) item;
        mTextView.setText(firstPageItem.name);
        ViewUtils.showView(mSpace);
    }
}
