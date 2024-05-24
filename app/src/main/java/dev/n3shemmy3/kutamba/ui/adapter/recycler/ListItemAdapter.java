package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.SingleLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.ThreeLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.TwoLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class ListItemAdapter extends ListAdapter<ListItem, RecyclerView.ViewHolder> {


    public ListItemAdapter() {
        super(itemCallback);
    }

    enum ListItemType {
        SingleLine,
        TwoLine,
        ThreeLine

    }

    private OnItemClickListener<ListItem> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<ListItem> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemClickListener<ListItem> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        ListItem item = getItem(position);
        if (item.getTertiary() != null)
            return ListItemType.ThreeLine.ordinal();
        else if (item.getSecondary() != null && item.getTertiary() == null)
            return ListItemType.TwoLine.ordinal();
        else return ListItemType.SingleLine.ordinal();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemType value = ListItemType.values()[viewType];
        RecyclerView.ViewHolder viewHolder;
        switch (value) {
            case TwoLine -> viewHolder = TwoLineItemViewHolder.create(parent);
            case ThreeLine -> viewHolder = ThreeLineItemViewHolder.create(parent);
            default -> viewHolder = SingleLineItemViewHolder.create(parent);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListItem item = getItem(position);
        if (holder instanceof ThreeLineItemViewHolder) {
            ((ThreeLineItemViewHolder) holder).onBindViewHolder(item, onItemClickListener);
        } else if (holder instanceof TwoLineItemViewHolder) {
            ((TwoLineItemViewHolder) holder).onBindViewHolder(item, onItemClickListener);
        } else ((SingleLineItemViewHolder) holder).onBindViewHolder(item, onItemClickListener);
    }


    static DiffUtil.ItemCallback<ListItem> itemCallback = new DiffUtil.ItemCallback<>() {

        @Override
        public boolean areItemsTheSame(@NonNull ListItem oldItem, @NonNull ListItem newItem) {
            return oldItem.getId().equalsIgnoreCase(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull ListItem oldItem, @NonNull ListItem newItem) {
            String oItem = oldItem.getIcon() + oldItem.getTitle() + oldItem.getSecondary() + oldItem.getTertiary();
            String nItem = oldItem.getIcon() + oldItem.getTitle() + oldItem.getSecondary() + oldItem.getTertiary();
            return oItem.equalsIgnoreCase(nItem);
        }
    };
}
