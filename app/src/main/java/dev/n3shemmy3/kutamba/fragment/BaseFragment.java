package dev.n3shemmy3.kutamba.fragment;

import android.content.Context;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.google.android.material.appbar.AppBarLayout;
import dev.n3shemmy3.kutamba.R;

public class BaseFragment extends Fragment {
    
    
    public FragmentManager getSupportFragmentManager(){
      return requireActivity().getSupportFragmentManager();
    }
    public ActionBar getSupportActionBar(Toolbar toolbar){
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }
    public void setSupportActionBar(Toolbar toolbar){
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }
    public NavController getNavController() {
        return Navigation.findNavController(getView());
    }
    
}
