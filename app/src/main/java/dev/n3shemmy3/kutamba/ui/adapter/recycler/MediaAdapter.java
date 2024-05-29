package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.MediaItemHolder;
import dev.n3shemmy3.kutamba.ui.adapter.pager.DiscoverAdapter;

public class MediaAdapter extends ListAdapter<MediaItem, RecyclerView.ViewHolder> {
    public MediaAdapter() {
        super(DiscoverAdapter.itemCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MediaItemHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MediaItemHolder)holder).onBindViewHolder(getItem(position),null);
    }
}
