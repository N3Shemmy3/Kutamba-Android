package dev.n3shemmy3.kutamba.ui.main;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import dev.n3shemmy3.kutamba.ui.base.BaseFragment;
import dev.n3shemmy3.kutamba.ui.history.HistoryFragment;
import dev.n3shemmy3.kutamba.ui.library.LibraryFragment;
import dev.n3shemmy3.kutamba.ui.more.MoreFragment;
import dev.n3shemmy3.kutamba.ui.search.SearchFragment;

public class MainPagerAdapter extends FragmentStateAdapter {

    public MainPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public MainPagerAdapter(@NonNull FragmentManager manager, @NonNull Lifecycle lifecycle) {
        super(manager, lifecycle);
    }

    final LibraryFragment libraryFragment = new LibraryFragment();
    final HistoryFragment historyFragment = new HistoryFragment();
    final SearchFragment browseFragment = new SearchFragment();
    final MoreFragment moreFragment = new MoreFragment();

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        BaseFragment fragment = null;
        switch (position) {
            case 0:
                fragment = libraryFragment;
                break;
            case 1:
                fragment = historyFragment;
                break;
            case 2:
                fragment = browseFragment;
                break;
            case 3:
                fragment = moreFragment;
                break;
        }
        assert fragment != null;
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}