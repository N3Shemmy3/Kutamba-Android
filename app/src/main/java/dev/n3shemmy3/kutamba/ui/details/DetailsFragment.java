package dev.n3shemmy3.kutamba.ui.details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.ListItemAdapter;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

public class DetailsFragment extends AppFragment implements OnItemClickListener<ListItem> {

  private RecyclerView recycler;

  @Override
  public int getLayoutId() {
    return R.layout.fragment_details;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle state) {
    recycler = view.findViewById(R.id.recyclerView);

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
              MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
              builder.setView(dialog);
              AlertDialog alertDialog = builder.create();
              dialog.findViewById(R.id.actionClose).setOnClickListener(v1 -> alertDialog.cancel());
              alertDialog.show();
            });
  }

  @Override
  public void onItemClick(ListItem item) {
      
  }

  @Override
  public void onItemLongClick(ListItem item) {
      
  }
}
