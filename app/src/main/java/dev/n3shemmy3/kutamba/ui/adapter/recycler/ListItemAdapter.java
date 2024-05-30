package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.BaseViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.SingleLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.ThreeLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.TwoLineItemViewHolder;

public class ListItemAdapter extends BaseAdapter<ListItem> {


    public ListItemAdapter() {
    }

    enum ItemType {
        SingleLine,
        TwoLine,
        ThreeLine,
    }

    @Override
    public int getItemViewType(int position) {
        ListItem item = getItem(position);
        if (item.getTertiary() != null)
            return ItemType.ThreeLine.ordinal();
        else if (item.getSecondary() != null && item.getTertiary() == null)
            return ItemType.TwoLine.ordinal();
        return ItemType.SingleLine.ordinal();
    }

    @NonNull
    @Override
    public BaseViewHolder<ListItem> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemType value = ItemType.values()[viewType];
        BaseViewHolder<ListItem> viewHolder;
        switch (value) {
            case TwoLine -> viewHolder = TwoLineItemViewHolder.create(parent);
            case ThreeLine -> viewHolder = ThreeLineItemViewHolder.create(parent);
            default -> viewHolder = SingleLineItemViewHolder.create(parent);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ListItem> holder, int position) {
        ListItem item = (ListItem) getItem(position);
        if (holder instanceof ThreeLineItemViewHolder) {
            ((ThreeLineItemViewHolder) holder).onBindViewHolder(item, onItemClickListener);
        } else if (holder instanceof TwoLineItemViewHolder) {
            ((TwoLineItemViewHolder) holder).onBindViewHolder(item, onItemClickListener);
        } else ((SingleLineItemViewHolder) holder).onBindViewHolder(item, onItemClickListener);
    }
}
