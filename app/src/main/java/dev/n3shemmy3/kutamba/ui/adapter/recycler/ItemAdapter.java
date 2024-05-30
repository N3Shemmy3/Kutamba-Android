package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.n3shemmy3.kutamba.data.model.BaseModel;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.MediaItemHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.SectionItemHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.SingleLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.ThreeLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.TwoLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<BaseModel> list = new ArrayList<>();

    public ItemAdapter() {
    }

    enum ItemType {
        SingleLine,
        TwoLine,
        ThreeLine,
        Media,
        Section

    }

    private OnItemClickListener<BaseModel> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<BaseModel> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemClickListener<BaseModel> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = ItemType.SingleLine.ordinal();
        BaseModel item = getItem(position);
        if (item instanceof MediaItem) {
            viewType = ItemType.Media.ordinal();
        } else if (item instanceof SectionItem) {
            viewType = ItemType.Section.ordinal();
        } else if (item instanceof ListItem) {
            ListItem listItem = (ListItem) item;
            if (listItem.getTertiary() != null)
                viewType = ItemType.ThreeLine.ordinal();
            else if (listItem.getSecondary() != null && listItem.getTertiary() == null)
                viewType = ItemType.TwoLine.ordinal();
        }
        return viewType;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public BaseModel getItem(int position) {
        return list.get(position);
    }

    public void addItem(BaseModel model) {
        list.add(model);
    }

    public void addItems(ArrayList<BaseModel> list) {
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemType value = ItemType.values()[viewType];
        RecyclerView.ViewHolder viewHolder;
        switch (value) {
            case TwoLine -> viewHolder = TwoLineItemViewHolder.create(parent);
            case ThreeLine -> viewHolder = ThreeLineItemViewHolder.create(parent);
            case Media -> viewHolder = MediaItemHolder.create(parent);
            case Section -> viewHolder = SectionItemHolder.create(parent);
            default -> viewHolder = SingleLineItemViewHolder.create(parent);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //keep index as position changes
        int index = position;

        if (holder instanceof MediaItemHolder) {
            MediaItem mediaItem = (MediaItem) getItem(index);
            ((MediaItemHolder) holder).onBindViewHolder(mediaItem, null);
        } else if (holder instanceof SectionItemHolder) {
            SectionItem item = (SectionItem) getItem(index);
            ((SectionItemHolder) holder).onBindViewHolder(item, (OnItemClickListener<SectionItem>) null);
        } else {
            ListItem item = (ListItem) getItem(index);
            if (holder instanceof ThreeLineItemViewHolder) {
                ((ThreeLineItemViewHolder) holder).onBindViewHolder(item, (OnItemClickListener<ListItem>) null);
            } else if (holder instanceof TwoLineItemViewHolder) {
                ((TwoLineItemViewHolder) holder).onBindViewHolder(item, (OnItemClickListener<ListItem>) null);
            } else ((SingleLineItemViewHolder) holder).onBindViewHolder(item, null);
        }
    }

}
