package dev.n3shemmy3.kutamba.ui.adapter.holder;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.google.android.material.imageview.ShapeableImageView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.BaseModel;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

/**
 * A simple single line list item.
 */
public class SingleLineItemViewHolder extends BaseViewHolder<ListItem> {

    public final ShapeableImageView itemIcon;
    public final TextView itemText;
    public final ShapeableImageView itemAction;

    public SingleLineItemViewHolder(@NonNull View view) {
        super(view);
        this.itemIcon = view.findViewById(R.id.itemIcon);
        this.itemText = view.findViewById(R.id.itemText);
        this.itemAction = view.findViewById(R.id.itemAction);
    }

    @NonNull
    public static SingleLineItemViewHolder create(@NonNull ViewGroup parent) {
        return new SingleLineItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_single_line, parent, false));
    }

    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull ListItem item, @Nullable OnItemClickListener<ListItem> listener) {
        itemIcon.setImageResource(item.getIcon());
        itemText.setText(item.getTitle());
        itemAction.setImageResource(item.getActionIcon());
        if (listener == null) return;
        itemView.setOnClickListener(v -> listener.onItemClick(item));
        itemView.setOnLongClickListener(v -> {
            listener.onItemLongClick(item);
            return false;
        });
    }

}
