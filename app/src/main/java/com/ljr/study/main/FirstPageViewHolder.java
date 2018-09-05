package com.ljr.study.main;

import android.view.View;
import android.widget.TextView;

import com.ljr.study.R;
import com.ljr.study.adapter.BaseItem;
import com.ljr.study.adapter.BaseViewHolder;
import com.ljr.study.utils.Check;

public class FirstPageViewHolder extends BaseViewHolder {

    private TextView mTextView;

    public FirstPageViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.main_item_name);
    }

    @Override
    public void onBound(BaseItem item) {
        Check.isTrue(item instanceof FirstPageItem);
        final FirstPageItem firstPageItem = (FirstPageItem) item;
        mTextView.setText(firstPageItem.name);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstPageItem.onClick(mTextView.getContext());
            }
        });
    }
}
