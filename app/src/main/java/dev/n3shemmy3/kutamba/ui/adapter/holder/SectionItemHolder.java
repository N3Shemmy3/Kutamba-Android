package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.MediaAdapter;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class SectionItemHolder extends RecyclerView.ViewHolder {
    public TextView itemTitle;
    public RecyclerView itemRecycler;
    public MediaAdapter adapter;

    public SectionItemHolder(@NonNull View view) {
        super(view);
        itemTitle = view.findViewById(R.id.itemTitle);
        itemRecycler = view.findViewById(R.id.itemRecycler);
        adapter = new MediaAdapter();
    }

    public void onBindViewHolder(@NonNull SectionItem item, @Nullable OnItemClickListener<SectionItem> listener) {
        itemTitle.setText(item.getTitle());
        itemRecycler.setAdapter(adapter);

    }

    @NonNull
    public static SectionItemHolder create(@NonNull ViewGroup parent) {
        return new SectionItemHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_three_line, parent, false));
    }
}
