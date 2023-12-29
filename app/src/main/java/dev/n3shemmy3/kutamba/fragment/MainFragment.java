package dev.n3shemmy3.kutamba.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
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
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.util.AppUtils;

public class MainFragment extends BaseFragment implements MenuProvider {
    
    private DrawerLayout drawer;
    private NavigationView navView;
    private CoordinatorLayout coordinator;
    private AppBarLayout appbar;
    private CollapsingToolbarLayout collToolbar;
    private MaterialToolbar toolbar;
    
    private AppBarConfiguration appBarConfig;
    private NavHostFragment navHost;
    private NavController navController;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle state) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        onCreateLayout(view);
        onCodeInit(state);
    }
    
    private void onCreateLayout(View view) {
        drawer = view.findViewById(R.id.drawer);
        coordinator = view.findViewById(R.id.coordinator);
        navView = view.findViewById(R.id.navView);
        appbar = view.findViewById(R.id.appbar);
        collToolbar = view.findViewById(R.id.collToolbar);
        toolbar = view.findViewById(R.id.toolbar);
        navController = getNavController();
        appBarConfig =
                new AppBarConfiguration.Builder(navController.getGraph())
            .setOpenableLayout(drawer)
            .build();
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(collToolbar, toolbar, navController, appBarConfig);
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) requireActivity(), navController, appBarConfig);
        AppUtils.setViewInets(appbar, true, true, true, false);
    }
    
    private void onCodeInit(Bundle state) {
       
    }
    @Override
    @MainThread
    @CallSuper
    public void onResume() {
        super.onResume();
       // setAppBarExpanded(true);
    }
    /*
    @Override
    @MainThread
    public void onBackPressed() {
        if (drawer.isOpen()) {
            drawer.close(); 
        }else {
            super.onBackPressed();
        }
    }
    */
    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.toolbar_menu_home, menu);
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
       
    
}
 