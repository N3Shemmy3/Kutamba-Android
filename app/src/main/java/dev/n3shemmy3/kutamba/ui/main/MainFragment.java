package dev.n3shemmy3.kutamba.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.SectionAdapter;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

public class MainFragment extends AppFragment implements Toolbar.OnMenuItemClickListener, OnItemClickListener<SectionItem> {


    private ShapeableImageView avatar;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private SectionAdapter sectionAdapter;
    private MainViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView);

        toolbar.setOnMenuItemClickListener(this);
        avatar = toolbar.getMenu().findItem(R.id.actionMenu).getActionView().findViewById(R.id.avatar);
        avatar.setOnClickListener(v -> navigate(R.id.openMenu));

        sectionAdapter = new SectionAdapter();
        layoutManager = new LinearLayoutManager(requireContext());
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
        recyclerView.setAdapter(sectionAdapter);
        recyclerView.setLayoutManager(layoutManager);
        fetchMedia();
        if (savedInstanceState != null && recyclerView.getLayoutManager() != null)
            recyclerView.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable("recycler"));
        InsetsUtil.addSystemBarsInsets(recyclerView, false, false, false, true);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (recyclerView == null) return;
        if (recyclerView.getLayoutManager() != null) return;
        outState.putParcelable("recycler", recyclerView.getLayoutManager().onSaveInstanceState());
    }

    private void fetchMedia() {
        viewModel.getAnime().observe(getViewLifecycleOwner(), mediaItems -> {
            sectionAdapter.addItem(new SectionItem("Popular Anime", mediaItems));
        });
        viewModel.getAnimeMovies().observe(getViewLifecycleOwner(), mediaItems -> {
            sectionAdapter.addItem(new SectionItem("Popular Anime Movies", mediaItems));
        });
        viewModel.getMovies().observe(getViewLifecycleOwner(), mediaItems -> {
            sectionAdapter.addItem(new SectionItem("Popular Movies", mediaItems));
        });
        viewModel.getTvShows().observe(getViewLifecycleOwner(), mediaItems -> {
            sectionAdapter.addItem(new SectionItem("Popular Tv Shows", mediaItems));
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionSearch -> navigate(R.id.openSearch);
            case R.id.actionMenu -> navigate(R.id.openMenu);
        }
        return true;
    }

    @Override
    public void onItemClick(SectionItem item) {
        navigate(R.id.openSearch);
    }

    @Override
    public void onItemLongClick(SectionItem item) {

    }
}
