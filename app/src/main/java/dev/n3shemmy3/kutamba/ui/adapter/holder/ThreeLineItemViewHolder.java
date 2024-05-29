package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.BaseModel;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

/**
 * A simple three line list item.
 */
public class ThreeLineItemViewHolder extends TwoLineItemViewHolder {

    public final TextView itemTertiary;

    public ThreeLineItemViewHolder(@NonNull View view) {
        super(view);
        this.itemTertiary = view.findViewById(R.id.itemTertiary);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItem item,@Nullable OnItemClickListener<ListItem> listener) {
        super.onBindViewHolder(item, listener);
        itemTertiary.setText(item.getTertiary());
    }

    @NonNull
    public static ThreeLineItemViewHolder create(@NonNull ViewGroup parent) {
        return new ThreeLineItemViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_three_line, parent, false));
    }
}
