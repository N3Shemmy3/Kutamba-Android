package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View view) {
        super(view);
    }

    public abstract void onBindViewHolder(@NonNull T item, @Nullable OnItemClickListener<T> listener);



}
