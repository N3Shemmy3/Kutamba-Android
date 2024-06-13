package dev.n3shemmy3.kutamba.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.data.model.MediaItem;
import dev.n3shemmy3.kutamba.data.model.SectionItem;
import dev.n3shemmy3.kutamba.ui.adapter.recycler.SectionAdapter;
import dev.n3shemmy3.kutamba.ui.base.BaseRecyclerFragment;
import dev.n3shemmy3.kutamba.ui.interfaces.OnItemClickListener;

public class MainRecyclerFragment extends BaseRecyclerFragment
        implements OnItemClickListener<SectionItem> {

    private MainViewModel viewModel;
    private SectionAdapter sectionAdapter;

    @NonNull
    @Override
    protected RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        sectionAdapter = new SectionAdapter();
        sectionAdapter.setStateRestorationPolicy(
                RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        sectionAdapter.setOnItemClickListener(this);
        sectionAdapter.setOnMediaItemListener(
                new OnItemClickListener<>() {
                    @Override
                    public void onItemClick(MediaItem item) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("item", item);
                        getNavController().navigate(R.id.openDetails, bundle);
                    }

                    @Override
                    public void onItemLongClick(MediaItem item) {
                    }
                });

        recyclerView.setAdapter(sectionAdapter);
        fetchMedia();
    }

    private void fetchMedia() {
        viewModel
                .getAnime()
                .observe(
                        getViewLifecycleOwner(),
                        mediaItems -> {
                            sectionAdapter.addItem(
                                    new SectionItem("Continue watching", mediaItems));
                            sectionAdapter.addItem(new SectionItem("Popular Anime", mediaItems));
                        });
        viewModel
                .getAnimeMovies()
                .observe(
                        getViewLifecycleOwner(),
                        mediaItems -> {
                            sectionAdapter.addItem(
                                    new SectionItem("Popular Anime Movies", mediaItems));
                            showRecycler();
                        });
        viewModel
                .getMovies()
                .observe(
                        getViewLifecycleOwner(),
                        mediaItems -> {
                            sectionAdapter.addItem(new SectionItem("Popular Movies", mediaItems));
                        });
        viewModel
                .getTvShows()
                .observe(
                        getViewLifecycleOwner(),
                        mediaItems -> {
                            sectionAdapter.addItem(new SectionItem("Popular Tv Shows", mediaItems));
                        });
    }

    @Override
    public void onItemClick(SectionItem item) {
    }

    @Override
    public void onItemLongClick(SectionItem item) {
    }
}
