package dev.n3shemmy3.kutamba.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.MenuProvider;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.adapter.AnimeAdapter;
import dev.n3shemmy3.kutamba.model.Anime;
import dev.n3shemmy3.kutamba.util.AppUtils;
import java.util.ArrayList;

public class MainFragment extends BaseFragment
        implements MenuProvider, NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration appBarConfig;
    private NavHostFragment navHost;
    private NavController navController;

    private DrawerLayout drawer;
    private NavigationView navView;
    private CoordinatorLayout coordinator;
    private AppBarLayout appbar;
    private CollapsingToolbarLayout collToolbar;
    private MaterialToolbar toolbar;

    private RecyclerView recycler1, recycler2, recycler3;
    private AnimeAdapter adapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle state) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        onCreateLayout(view);
        onCodeInit(state);
        requireActivity()
                .getOnBackPressedDispatcher()
                .addCallback(
                        getViewLifecycleOwner(),
                        new OnBackPressedCallback(true) {
                            @Override
                            public void handleOnBackPressed() {
                                if (drawer.isOpen()) {
                                    drawer.closeDrawers();
                                    return;
                                }
                                getActivity().finishAffinity();
                            }
                        });
    }

    private void onCreateLayout(View view) {
        drawer = view.findViewById(R.id.drawer);
        coordinator = view.findViewById(R.id.coordinator);
        navView = view.findViewById(R.id.navView);
        appbar = view.findViewById(R.id.appbar);
        collToolbar = view.findViewById(R.id.collToolbar);
        toolbar = view.findViewById(R.id.toolbar);
        recycler1 = view.findViewById(R.id.recycler1);
        recycler2 = view.findViewById(R.id.recycler2);
        recycler3 = view.findViewById(R.id.recycler3);

        navController = getNavController();
        appBarConfig =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setOpenableLayout(drawer)
                        .build();

        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(collToolbar, toolbar, navController, appBarConfig);
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupActionBarWithNavController(
                (AppCompatActivity) requireActivity(), navController, appBarConfig);
        AppUtils.setViewInets(appbar, true, true, true, false);
        navView.setNavigationItemSelectedListener(this);
    }

    private void onCodeInit(Bundle state) {
        ArrayList<Anime> animes = new ArrayList<>();
        for (int i = 0; i < 30; ++i) {
            animes.add(
                    new Anime(
                            "id",
                            "https://unsplash.com/photos/aerial-view-photography-of-road-between-highrise-building-CAFq0pv9HjY",
                            "Anime title" + i,
                            "",
                            "",
                            "",
                            "",
                            "",
                            ""));
        }
        adapter = new AnimeAdapter(getContext(), animes);
        recycler1.setAdapter(adapter);
        recycler2.setAdapter(adapter);
        recycler3.setAdapter(adapter);
        recycler1.setLayoutManager(
                new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recycler2.setLayoutManager(
                new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recycler3.setLayoutManager(
                new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
    }

    @Override
    @MainThread
    @CallSuper
    public void onResume() {
        super.onResume();
        drawer.closeDrawers();
    }

    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.toolbar_main, menu);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.searchFragment) {
            getNavController().navigate(R.id.open_searchFragment);
            return true;
        }
        if (itemId == R.id.profileFragment) {
            getNavController().navigate(R.id.open_profileFragment);
            return true;
        }
        if (itemId == R.id.settingsFragment) {
            getNavController().navigate(R.id.open_settingsFragment);
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        @IdRes int itemId = menuItem.getItemId();
        NavOptions.Builder optionsBuilder = new NavOptions.Builder();
        if (itemId == R.id.mainFragment) {
            optionsBuilder
                    .setEnterAnim(android.R.anim.fade_in)
                    .setExitAnim(android.R.anim.fade_in)
                    .setPopEnterAnim(android.R.anim.fade_in)
                    .setPopExitAnim(android.R.anim.fade_out);
        } else {
            optionsBuilder
                    .setEnterAnim(R.anim.enter_from_left)
                    .setExitAnim(R.anim.exit_to_left)
                    .setPopEnterAnim(R.anim.enter_from_left)
                    .setPopExitAnim(R.anim.exit_to_right);
        }
        drawer.closeDrawers();
        navController.navigate(itemId, null, optionsBuilder.build());
        return true;
    }
}
