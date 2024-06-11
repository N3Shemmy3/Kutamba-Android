package dev.n3shemmy3.kutamba.ui.details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.ListItemAdapter;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

public class DetailsFragment extends AppFragment implements OnItemClickListener<ListItem>, AppBarLayout.LiftOnScrollListener {

    private RecyclerView recycler;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle state) {
        recycler = view.findViewById(R.id.recyclerView);

        appbar.addLiftOnScrollListener(this);
        ListItemAdapter itemAdapter = new ListItemAdapter();
        for (int i = 0; i < 30; ++i) {
            itemAdapter.addItem(
                    new ListItem(
                            "" + i, R.drawable.outline_play_arrow_24, "Episode " + i, "Synopsis here", "", 0));
        }
        recycler.setAdapter(itemAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        recycler.setHasFixedSize(true);
        itemAdapter.setOnItemClickListener(this);
        InsetsUtil.addSystemBarsInsets(view.findViewById(R.id.bottomBar), false, false, false, true);

        view.findViewById(R.id.headerCover)
                .setOnClickListener(
                        v -> {
                            View dialog = View.inflate(requireContext(), R.layout.dialog_cover_viewer, null);
                            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), R.style.Theme_FullScreen_Dialog);
                            builder.setView(dialog);
                            builder.setBackgroundInsetStart(0);
                            builder.setBackgroundInsetTop(0);
                            builder.setBackgroundInsetEnd(0);
                            builder.setBackgroundInsetBottom(0);
                            AlertDialog alertDialog = builder.create();
                            ((MaterialToolbar) dialog.findViewById(R.id.toolBar)).setNavigationOnClickListener(back -> alertDialog.cancel());
                            alertDialog.show();
                        });
    }

    @Override
    public void onItemClick(ListItem item) {

    }

    @Override
    public void onItemLongClick(ListItem item) {

    }

    @Override
    public void onUpdate(float elevation, int backgroundColor) {
        toolbar.setTitle(appbar.isLifted() ? "Odd Taxi" : "");
    }
}
