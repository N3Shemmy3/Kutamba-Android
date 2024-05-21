package dev.n3shemmy3.kutamba.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

/*
 A Top Level Fragment that provides an appbar & FragmentContainer
 */
public abstract class AppFragment extends BaseFragment {

    public AppBarLayout appbar;
    public MaterialToolbar toolbar;

    @LayoutRes
    public int getLayoutId() {
        return R.layout.fragment_appbar;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(getLayoutId(), container, false);
        toolbar = root.findViewById(R.id.toolBar);
        appbar = root.findViewById(R.id.appBar);
        InsetsUtil.addSystemBarsInsets(appbar);
        toolbar.setNavigationOnClickListener(v -> navigateUp());
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
        return root;
    }
}
