package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.BaseModel;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class LoaderItemHolder extends BaseViewHolder<BaseModel> {
    @NonNull
    public static LoaderItemHolder create(@NonNull ViewGroup parent) {
        return new LoaderItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_loader, parent, false));
    }
    public LoaderItemHolder(@NonNull View view){
        super(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BaseModel item, @Nullable OnItemClickListener<BaseModel> listener) {

    }

}
