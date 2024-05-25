package dev.n3shemmy3.kutamba.ui.more;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.ListItemAdapter;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;
import dev.n3shemmy3.kutamba.ui.base.BaseRecyclerFragment;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class MoreFragment extends AppFragment {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_cappbar;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.label_more);

        if (savedInstanceState == null) {
            setContentView(new RecyclerFragment());
        }
    }

    public static class RecyclerFragment extends BaseRecyclerFragment {

        public RecyclerFragment(){}
        private ListItemAdapter itemAdapter;

        @NonNull
        @Override
        protected RecyclerView.LayoutManager onCreateLayoutManager() {
            return new LinearLayoutManager(getContext());
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            itemAdapter = new ListItemAdapter();
            recyclerView.setAdapter(itemAdapter);
            itemAdapter.setOnItemClickListener(new OnItemClickListener<>() {
                @Override
                public void onItemClick(ListItem item) {
                }

                @Override
                public void onItemLongClick(ListItem item) {
                }
            });
            ArrayList<ListItem> list = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                ListItem item = new ListItem();
                item.setIcon(i == 7 ? R.drawable.outline_menu_24 : R.drawable.outline_settings_24);
                item.setTitle(i == 7 ? getString(R.string.label_menu) : getString(R.string.label_settings));
                list.add(item);
            }
            itemAdapter.submitList(list);
            showRecycler();
        }
    }
}
