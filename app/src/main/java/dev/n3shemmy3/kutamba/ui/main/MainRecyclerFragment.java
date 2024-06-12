package dev.n3shemmy3.kutamba.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.SectionAdapter;
import dev.n3shemmy3.kutamba.ui.base.BaseRecyclerFragment;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class MainRecyclerFragment extends BaseRecyclerFragment implements OnItemClickListener<SectionItem> {

    private SectionAdapter sectionAdapter;

    @NonNull
    @Override
    protected RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        sectionAdapter = new SectionAdapter();
        sectionAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        sectionAdapter.setOnItemClickListener(this);
        sectionAdapter.setOnMediaItemListener(new OnItemClickListener<>() {
            @Override
            public void onItemClick(MediaItem item) {
                navigate(R.id.openDetails);
            }

            @Override
            public void onItemLongClick(MediaItem item) {

            }
        });
    }

    @Override
    public void onItemClick(SectionItem item) {

    }

    @Override
    public void onItemLongClick(SectionItem item) {

    }
}
