package dev.n3shemmy3.material.preference;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("deprecation")
public abstract class MaterialPreferenceFragment extends PreferenceFragmentCompat {
    private RecyclerView mRecyclerView;
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(androidx.preference.R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        if (mRecyclerView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mRecyclerView,
                (v, insets) -> {
                    Insets systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(0, 0, 0, systemInsets.bottom);
                    return WindowInsetsCompat.CONSUMED;
                }
            );
        }
    }
    
    @Override
    public void onDisplayPreferenceDialog(@NonNull Preference preference) {
        if (preference instanceof EditTextPreference) {
            showEditTextPreferenceDialog((MaterialEditTextPreference) preference);
        } else if (preference instanceof ListPreference) {
            showListPreferenceDialog((ListPreference) preference);
        } else if (preference instanceof MultiSelectListPreference) {
            showMultiSelectListPreferenceDialog((MultiSelectListPreference) preference);
        } else {
            super.onDisplayPreferenceDialog(preference);
        }
    }
    
    private void showEditTextPreferenceDialog(MaterialEditTextPreference preference) {
        MaterialEditTextPreferenceDialog dialogFragment = new MaterialEditTextPreferenceDialog();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", preference.getKey());
        dialogFragment.setArguments(bundle);
        dialogFragment.setTargetFragment(this, 0);
        dialogFragment.show(getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }
    
    private void showListPreferenceDialog(ListPreference preference) {
        MaterialPreferenceDialog dialogFragment = new MaterialMultiSelectListPreferenceDialog();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", preference.getKey());
        dialogFragment.setArguments(bundle);
        dialogFragment.setTargetFragment(this, 0);
        dialogFragment.show(getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }
    
    private void showMultiSelectListPreferenceDialog(MultiSelectListPreference preference) {
        MaterialPreferenceDialog dialogFragment = new MaterialMultiSelectListPreferenceDialog();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", preference.getKey());
        dialogFragment.setArguments(bundle);
        dialogFragment.setTargetFragment(this, 0);
        dialogFragment.show(getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }
    
}