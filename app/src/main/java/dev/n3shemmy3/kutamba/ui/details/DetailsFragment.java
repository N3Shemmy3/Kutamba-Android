package dev.n3shemmy3.kutamba.ui.details;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.jsibbold.zoomage.ZoomageView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.ListItem;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;
import dev.n3shemmy3.kutamba.ui.main.MainViewModel;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

public class DetailsFragment extends AppFragment implements OnItemClickListener<ListItem>, AppBarLayout.LiftOnScrollListener {


    private LinearProgressIndicator progressIndicator;
    private ShapeableImageView headerCover;
    private TextView headerTitle;
    private TextView headerSubTitle;
    private TextView headerStatus;
    private TextView headerDate;
    private TextView headerBio;
    private RecyclerView recycler;

    private MainViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle state) {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getMediaItem(getArguments().getParcelable("item"));

        progressIndicator = view.findViewById(R.id.progressIndicator);
        headerCover = view.findViewById(R.id.headerCover);
        headerTitle = view.findViewById(R.id.headerTitle);
        headerSubTitle = view.findViewById(R.id.headerSubTitle);
        headerStatus = view.findViewById(R.id.headerStatus);
        headerDate = view.findViewById(R.id.headerDate);
        headerBio = view.findViewById(R.id.headerBio);
        recycler = view.findViewById(R.id.recyclerView);
        appbar.addLiftOnScrollListener(this);
        InsetsUtil.addSystemBarsInsets(view.findViewById(R.id.bottomBar), false, false, false, true);
        view.findViewById(R.id.headerCover).setOnClickListener(v -> {
            View dialog = View.inflate(requireContext(), R.layout.dialog_cover_viewer, null);
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), R.style.Theme_FullScreen_Dialog);
            builder.setView(dialog);
            builder.setBackgroundInsetStart(0);
            builder.setBackgroundInsetTop(0);
            builder.setBackgroundInsetEnd(0);
            builder.setBackgroundInsetBottom(0);
            AlertDialog alertDialog = builder.create();
            ((MaterialToolbar) dialog.findViewById(R.id.toolBar)).setNavigationOnClickListener(back -> alertDialog.cancel());
            ZoomageView zoomageView = dialog.findViewById(R.id.cover);
            Glide.with(zoomageView).load(viewModel.getMediaItem().getValue().getImage()).into(zoomageView);
            alertDialog.show();
        });
        headerBio.setOnClickListener(v -> {
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
            builder.setTitle("Description");
            builder.setMessage(headerBio.getText());
            builder.setPositiveButton(R.string.action_copy, (dialog, which) -> {
                ClipboardManager clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                clipboard.setPrimaryClip(ClipData.newPlainText("plot", headerBio.getText()));
                dialog.dismiss();
            });
            builder.setNegativeButton(R.string.action_close, null);
            builder.show();
        });
        fetchDetails();
    }

    private void fetchDetails() {
        viewModel.getMediaItem().observe(getViewLifecycleOwner(), item -> {
            Glide.with(headerCover).load(item.getImage()).into(headerCover);
            headerCover.post(() -> progressIndicator.hide());
            headerTitle.setText(item.getTitle());
            headerSubTitle.setText(item.getProduction());
            headerDate.setText(item.getReleaseDate());
            headerStatus.setText(item.getStatus());
            headerBio.setText(item.getDescription());
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
        toolbar.setTitle(appbar.isLifted() ? headerTitle.getText() : "");
    }
}
