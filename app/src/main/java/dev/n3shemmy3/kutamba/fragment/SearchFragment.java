package dev.n3shemmy3.kutamba.fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.util.AppUtils;

public class SearchFragment extends BaseFragment implements MenuProvider {
    
    private AppBarLayout appbar;
    private MaterialToolbar toolbar;
    private AppBarConfiguration appBarConfig;
    
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle state) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
        onCreateLayout(view);
        onCodeInit(state);
    }
    
    private void onCreateLayout(View view) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        appbar = view.findViewById(R.id.appbar);
        toolbar = view.findViewById(R.id.toolbar);
        appBarConfig =
                new AppBarConfiguration.Builder(getNavController().getGraph())
            .build();
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(toolbar, getNavController(), appBarConfig);
        AppUtils.setViewInets(appbar, true, true, true, false);
    }
    
    private void onCodeInit(Bundle state) {
       
    }
    
    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        //menuInflater.inflate(R.menu.toolbar_menu_home, menu);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        return false;
    }

}
