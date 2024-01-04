package dev.n3shemmy3.kutamba.fragment.settings;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.fragment.BaseFragment;
import dev.n3shemmy3.kutamba.util.AppUtils;

public class SettingsFragment extends BaseFragment {
    
    private AppBarLayout appbar;
    private CollapsingToolbarLayout collToolbar;
    private MaterialToolbar toolbar;
    
    private AppBarConfiguration appBarConfig;
    
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle state) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
        onCreateLayout(view);
        onCodeInit(state);
    }
    
    private void onCreateLayout(View view) {
        appbar = view.findViewById(R.id.appbar);
        collToolbar = view.findViewById(R.id.collToolbar);
        toolbar = view.findViewById(R.id.toolbar);
        appBarConfig =
                new AppBarConfiguration.Builder(getNavController().getGraph())
            .build();
        setSupportActionBar(toolbar);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.settingsNavHost);
        NavigationUI.setupWithNavController(collToolbar,toolbar, getNavController(), appBarConfig);
        AppUtils.setViewInets(appbar, true, true, true, false);
        //AppUtils.setViewInets()
    }
    
    private void onCodeInit(Bundle state) {
       
    }
}
