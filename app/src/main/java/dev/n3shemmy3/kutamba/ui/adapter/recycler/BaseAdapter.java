package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.n3shemmy3.kutamba.ui.adapter.holder.BaseViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.SingleLineItemViewHolder;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {
    public final ArrayList<T> items = new ArrayList<>();
    public OnItemClickListener<T> onItemClickListener;

    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return (BaseViewHolder<T>) SingleLineItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {
        holder.onBindViewHolder(getItem(position), onItemClickListener);
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void removeOnItemClickListener() {
        this.onItemClickListener = null;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public T getItem(int position) {
        return this.items.get(position);
    }

    public void addItem(T item) {
        this.items.add(item);
        notifyItemInserted(items.indexOf(item));
    }

    public void addItem(int index, T item) {
        this.items.add(index, item);
        notifyItemInserted(index);
    }

    public void setItem(int index, T item) {
        if (this.items.isEmpty() || index >= this.items.size()) {
            addItem(item);
        } else {
            this.items.set(index, item);
            notifyItemChanged(index);
        }
    }

    public void addItems(ArrayList<T> items) {
        int start = this.items.size() - 1;
        this.items.addAll(items);
        notifyItemRangeInserted(start, items.size());
    }
}
