package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class MediaItemHolder extends BaseViewHolder<MediaItem> {

    private MaterialCardView itemView;
    private ShapeableImageView itemIcon;
    private TextView itemTitle;

    public MediaItemHolder(@NonNull View view) {
        super(view);
        itemView = view.findViewById(R.id.itemView);
        itemIcon = view.findViewById(R.id.itemIcon);
        itemTitle = view.findViewById(R.id.itemTitle);
    }

    @NonNull
    public static MediaItemHolder create(@NonNull ViewGroup parent) {
        return new MediaItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_media, parent, false));
    }

    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull MediaItem item, @Nullable OnItemClickListener<MediaItem> listener) {
        itemTitle.setText(item.getTitle());

        itemIcon.post(() -> {
            CircularProgressDrawable drawable = new CircularProgressDrawable(itemIcon.getContext());
            drawable.setStrokeWidth(2f);
            drawable.setCenterRadius(24f);
            drawable.start();
            Glide.with(itemIcon.getContext())
                    .load(item.getImage())
                    .placeholder(drawable)
                    .into(itemIcon);
        });


        if (listener == null) return;
        itemView.setOnClickListener(v -> listener.onItemClick(item));
        itemView.setOnLongClickListener(v -> {
            listener.onItemLongClick(item);
            return true;
        });
    }
}
