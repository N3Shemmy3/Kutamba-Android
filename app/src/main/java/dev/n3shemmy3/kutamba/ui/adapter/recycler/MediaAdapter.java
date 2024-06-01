package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.BaseViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.LoaderItemHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.MediaItemHolder;
import dev.n3shemmy3.kutamba.ui.adapter.pager.DiscoverAdapter;

public class MediaAdapter extends ListAdapter<MediaItem, RecyclerView.ViewHolder> {
    public MediaAdapter() {
        super(DiscoverAdapter.itemCallback);
    }

    enum ItemType {
        Media,
        Loader
    }

    @Override
    public int getItemViewType(int position) {
        MediaItem item = getItem(position);
        if (item.getTitle() != null)
            return ItemType.Media.ordinal();
        else
            return ItemType.Loader.ordinal();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemType value = ItemType.values()[viewType];
        BaseViewHolder viewHolder;
        switch (value) {
            case Media -> viewHolder = MediaItemHolder.create(parent);
            default -> viewHolder = LoaderItemHolder.create(parent);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MediaItemHolder)
            ((MediaItemHolder) holder).onBindViewHolder(getItem(position), null);
    }
}
