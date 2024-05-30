package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class DiscoverItemHolder extends BaseViewHolder<MediaItem> {

    private ShapeableImageView itemIcon;
    private Button itemAction;
    private TextView itemTitle;
    private TextView itemText;

    public DiscoverItemHolder(@NonNull View view) {
        super(view);
        itemIcon = view.findViewById(R.id.itemIcon);
        itemAction = view.findViewById(R.id.itemAction);
        itemTitle = view.findViewById(R.id.itemTitle);
        itemText = view.findViewById(R.id.itemText);
    }

    @NonNull
    public static DiscoverItemHolder create(@NonNull ViewGroup parent) {
        return new DiscoverItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pager_discover, parent, false));
    }

    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull MediaItem item, @Nullable OnItemClickListener<MediaItem> listener) {
    }
}
