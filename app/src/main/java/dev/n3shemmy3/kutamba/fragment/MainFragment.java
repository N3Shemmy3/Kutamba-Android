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
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.activity.SearchActivity;

public class MainFragment extends BaseFragment implements MenuProvider {
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle state) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
        onCreateLayout(view);
        onCodeInit(state);
    }
    
    private void onCreateLayout(View view) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
    }
    
    private void onCodeInit(Bundle state) {
       
    }
    @Override
    @MainThread
    @CallSuper
    public void onResume() {
        super.onResume();
        setAppBarExpanded(true);
    }
    
    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.toolbar_menu_home, menu);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if  (R.id.menu_search == itemId ) {
            startActivity(new Intent(getActivity(), SearchActivity.class));
            return false;
        }
        
        NavController navController = Navigation.findNavController(requireActivity(), R.id.navHost);
        return NavigationUI.onNavDestinationSelected(menuItem, navController)
            || false;
    }
       
    
}
 