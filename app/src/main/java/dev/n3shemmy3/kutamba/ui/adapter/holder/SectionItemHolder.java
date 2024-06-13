package dev.n3shemmy3.kutamba.ui.adapter.holder;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.CircularProgressIndicator;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.decor.HorizontalSpaceItemDecoration;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.MediaAdapter;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class SectionItemHolder extends BaseViewHolder<SectionItem> {


    public TextView itemTitle;
    public RecyclerView itemRecycler;
    public CircularProgressIndicator progressIndicator;
    public MediaAdapter adapter;
    public LinearLayoutManager layoutManager;

    public SectionItemHolder(@NonNull View view) {
        super(view);
        itemTitle = view.findViewById(R.id.itemTitle);
        progressIndicator = view.findViewById(R.id.progressIndicator);
        itemRecycler = view.findViewById(R.id.itemRecycler);
        adapter = new MediaAdapter();
        layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);

        adapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        layoutManager.setInitialPrefetchItemCount(4);
        itemRecycler.setAdapter(adapter);
        itemRecycler.addItemDecoration(new HorizontalSpaceItemDecoration(view.getContext(), R.dimen.activity_padding_horizontal, R.dimen.zero));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionItem item, @Nullable OnItemClickListener<SectionItem> listener) {
    }


    public void onBindViewHolder(Parcelable state, RecyclerView.RecycledViewPool viewPool, @NonNull SectionItem item, @Nullable OnItemClickListener<SectionItem> listener) {
        itemTitle.setText(item.getTitle());
        itemRecycler.post(() -> {
            itemRecycler.setRecycledViewPool(viewPool);
            itemRecycler.setLayoutManager(layoutManager);
            adapter.addItems(item.getItems());
            if (!item.getItems().isEmpty()) {
                progressIndicator.hide();
                itemRecycler.animate().alpha(1).start();
                itemRecycler.setVisibility(View.VISIBLE);
            }
        });
        //restore scroll state
        if (itemRecycler.getLayoutManager() != null) {
            if (state != null) {
                itemRecycler.getLayoutManager().onRestoreInstanceState(state);
            } else {
                itemRecycler.getLayoutManager().scrollToPosition(0);
            }
        }
        if (listener == null) return;
        itemView.setOnClickListener(null);
        itemTitle.setOnClickListener(v -> listener.onItemClick(item));
        itemTitle.setOnLongClickListener(v -> {
            listener.onItemLongClick(item);
            return true;
        });

    }

    @NonNull
    public static SectionItemHolder create(@NonNull ViewGroup parent) {
        return new SectionItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section, parent, false));
    }

}
