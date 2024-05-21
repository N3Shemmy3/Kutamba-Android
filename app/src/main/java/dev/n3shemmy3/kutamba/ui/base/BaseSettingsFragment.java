package dev.n3shemmy3.kutamba.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.google.android.material.appbar.MaterialToolbar;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

public abstract class BaseSettingsFragment extends BaseFragment {
    public BaseSettingsFragment(@StringRes int title, @NonNull BasePreferenceFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    private final int title;
    private final BasePreferenceFragment fragment;
    private View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root != null) return root;
        root = inflater.inflate(R.layout.fragment_cappbar, container, false);
        MaterialToolbar toolbar = root.findViewById(R.id.toolBar);
        toolbar.setTitle(title);
        toolbar.setNavigationOnClickListener(v -> navigateUp());

        getChildFragmentManager()
                .beginTransaction()
                .addToBackStack(String.valueOf(System.currentTimeMillis()))
                .add(R.id.settingsContainer, fragment)
                .commit();
        InsetsUtil.addSystemBarsInsets(root.findViewById(R.id.appBar));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
        return root;
    }
}
