package dev.n3shemmy3.kutamba.ui.adapter.recycler;

import android.os.Parcelable;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.holder.BaseViewHolder;
import dev.n3shemmy3.kutamba.ui.adapter.holder.SectionItemHolder;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class SectionAdapter extends BaseAdapter<SectionItem> {
    private HashMap<String, Parcelable> scrollStates = new HashMap<>();
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    @NonNull
    @Override
    public BaseViewHolder<SectionItem> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SectionItemHolder.create(parent);
    }
    @Override
    public void onViewRecycled(@NonNull BaseViewHolder<SectionItem> holder) {
        super.onViewRecycled(holder);
        //save scroll state
        if (holder instanceof SectionItemHolder) {
            String key = getSectionID(holder.getLayoutPosition());
            RecyclerView recyclerView = ((SectionItemHolder) holder).itemRecycler;
            if (recyclerView.getLayoutManager() != null)
                scrollStates.put(key, recyclerView.getLayoutManager().onSaveInstanceState());
        }
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<SectionItem> holder, int position) {
        super.onBindViewHolder(holder, position);
        SectionItem item = getItem(position);
        String key = getSectionID(holder.getLayoutPosition());
        ((SectionItemHolder) holder).onBindViewHolder(scrollStates.get(key), viewPool,item, onItemClickListener);
    }
    private String getSectionID(int position) {
        return this.items.get(position).getId();
    }
}
