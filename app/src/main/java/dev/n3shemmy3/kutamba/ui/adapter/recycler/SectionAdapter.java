package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.SectionItemHolder;

public class SectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<SectionItem> sectionItems = new ArrayList<>();

    public SectionAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SectionItemHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SectionItemHolder) holder).onBindViewHolder(getItem(position), null);
    }

    @Override
    public int getItemCount() {
        return sectionItems.size();
    }

    public SectionItem getItem(int position) {
        return sectionItems.get(position);
    }

    public void setItem(SectionItem item) {
        sectionItems.add(item);
    }
}
