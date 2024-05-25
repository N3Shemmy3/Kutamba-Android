package dev.n3shemmy3.kutamba.ui.adapter.holder;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

/**
 * A simple two line list item.
 */
public class TwoLineItemViewHolder extends SingleLineItemViewHolder {

    public final TextView itemSecondary;

    public TwoLineItemViewHolder(@NonNull View view) {
        super(view);
        this.itemSecondary = view.findViewById(R.id.itemSecondary);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItem item, @NonNull OnItemClickListener<ListItem> listener) {
        super.onBindViewHolder(item, listener);
        itemSecondary.setText(item.getSecondary());
    }

    @NonNull
    public static TwoLineItemViewHolder create(@NonNull ViewGroup parent) {
        return new TwoLineItemViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_two_line, parent, false));
    }
}
