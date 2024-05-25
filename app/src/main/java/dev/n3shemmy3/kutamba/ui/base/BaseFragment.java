package dev.n3shemmy3.kutamba.ui.base;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.transition.MaterialSharedAxis;

import dev.n3shemmy3.kutamba.R;


public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
        setReturnTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
        setExitTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
        setReenterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
    }

    public boolean onBackPressed() {
        return false;
    }


    public void setContentView(Fragment fragment) {
        setContentView(R.id.fragmentContainer, fragment, null);
    }

    public void setContentView(@IdRes int layoutId, Fragment fragment, Bundle bundle) {
        int id = requireView().findViewById(R.id.fragmentContainer) == null ?
                R.id.settingsContainer
                :
                layoutId;
        getChildFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(id, fragment.getClass(), bundle)
                .commit();
    }

    @MainThread
    public FragmentManager getSupportFragmentManager() {
        return requireActivity().getSupportFragmentManager();
    }

    @MainThread
    public NavController getNavController() {
        return Navigation.findNavController(requireView());
    }

    @MainThread
    public void navigate(@IdRes int id) {
        getNavController().navigate(id);
    }

    @MainThread
    public void navigateUp() {
        getNavController().navigateUp();
    }

    public final OnBackPressedCallback onBackPressendCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            if (onBackPressed()) return;
            if (!getNavController().navigateUp()) requireActivity().finish();
            else navigateUp();
        }
    };
}
