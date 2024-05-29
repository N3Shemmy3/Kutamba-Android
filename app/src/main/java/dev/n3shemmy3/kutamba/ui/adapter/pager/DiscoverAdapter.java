package dev.n3shemmy3.kutamba.ui.adapter.pager;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.DiscoverItemHolder;

public class DiscoverAdapter extends ListAdapter<MediaItem, RecyclerView.ViewHolder> {
    public DiscoverAdapter() {
        super(itemCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return DiscoverItemHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((DiscoverItemHolder) holder).onBindViewHolder(getItem(position), null);
    }


    public static DiffUtil.ItemCallback<MediaItem> itemCallback = new DiffUtil.ItemCallback<>() {

        @Override
        public boolean areItemsTheSame(@NonNull MediaItem oldItem, @NonNull MediaItem newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MediaItem oldItem, @NonNull MediaItem newItem) {
           return false;
        }
    };
}
