package dev.n3shemmy3.kutamba.ui.base;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceFragmentCompat;

import com.google.android.material.color.MaterialColors;

import java.util.Objects;

import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;
import dev.n3shemmy3.material.preference.MaterialPreferenceFragment;

public  abstract class BasePreferenceFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(MaterialColors.getColor(view, android.R.attr.colorBackground));
        InsetsUtil.addSystemBarsInsets(view.findViewById(androidx.preference.R.id.recycler_view), false, false, false, true);
    }
    @Override
    public void setDivider(@Nullable Drawable divider) {
        super.setDivider(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void setDividerHeight(int height) {
        super.setDividerHeight(0);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {

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
    @Override
    public void onStart() {
        super.onStart();
        Objects.requireNonNull(getPreferenceScreen().getSharedPreferences()).registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        Objects.requireNonNull(getPreferenceScreen().getSharedPreferences()).unregisterOnSharedPreferenceChangeListener(this);
        super.onStop();
    }
}
