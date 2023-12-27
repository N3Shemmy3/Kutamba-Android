package dev.n3shemmy3.kutamba.fragment;

import android.app.Activity;
import android.content.Context;
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
import com.google.android.material.appbar.AppBarLayout;
import dev.n3shemmy3.kutamba.R;

public class SettingsFragment extends BaseFragment implements MenuProvider {

    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setAppBarExpanded(false);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle state) {
        return inflater.inflate(R.layout.fragment_list, container, false);
        
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
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        //menuInflater.inflate(R.menu.toolbar_menu_home, menu);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        return false;
    }
}
