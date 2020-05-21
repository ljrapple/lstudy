package com.ljr.study.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;

import com.ljr.study.utils.Check;

public class ItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final ItemsViewHolderFactory mItemsViewHolderFactory;
    private final Section mSection;

    public ItemAdapter(ItemsViewHolderFactory factory, Section section) {
        Check.isNotNull(factory);
        mItemsViewHolderFactory = factory;
        mSection = section;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mItemsViewHolderFactory.createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBound(mSection.getItemsList().get(position));
    }


    @Override
    public int getItemCount() {
        return mSection.getItemsList().size();
    }

    @Override
    public int getItemViewType(int position) {
        return mSection.getItemsList().get(position).getViewType();
    }
}
