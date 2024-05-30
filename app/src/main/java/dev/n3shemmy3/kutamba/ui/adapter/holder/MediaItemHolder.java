package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class MediaItemHolder extends BaseViewHolder<MediaItem> {
    private ShapeableImageView itemIcon;
    private TextView itemTitle;

    public MediaItemHolder(@NonNull View view) {
        super(view);
        itemIcon = view.findViewById(R.id.itemIcon);
        itemTitle = view.findViewById(R.id.itemText);
    }

    @NonNull
    public static MediaItemHolder create(@NonNull ViewGroup parent) {
        return new MediaItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_media, parent, false));
    }

    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull MediaItem item, @Nullable OnItemClickListener<MediaItem> listener) {

    }
}
