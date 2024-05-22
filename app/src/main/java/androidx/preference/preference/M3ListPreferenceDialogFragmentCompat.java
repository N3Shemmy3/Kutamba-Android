package com.projectmaterial.preference;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.ListPreference;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.projectmaterial.videos.R;

public class M3ListPreferenceDialogFragmentCompat extends M3PreferenceDialogFragmentCompat {
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private int mClickedDialogEntryIndex;
    private static final String SAVE_STATE_INDEX = "M3ListPreferenceDialogFragment.index";
    private static final String SAVE_STATE_ENTRIES = "M3ListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "M3ListPreferenceDialogFragment.entryValues";

    @NonNull
    public static M3ListPreferenceDialogFragmentCompat newInstance(@NonNull String key) {
        M3ListPreferenceDialogFragmentCompat fragment = new M3ListPreferenceDialogFragmentCompat();
        Bundle savedInstanceState = new Bundle(1);
        savedInstanceState.putString(ARG_KEY, key);
        fragment.setArguments(savedInstanceState);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            ListPreference preference = getListPreference();
            if (preference.getEntries() == null || preference.getEntryValues() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            mClickedDialogEntryIndex = preference.findIndexOfValue(preference.getValue());
            mEntries = preference.getEntries();
            mEntryValues = preference.getEntryValues();
        } else {
            mClickedDialogEntryIndex = savedInstanceState.getInt(SAVE_STATE_INDEX, 0);
            mEntries = savedInstanceState.getCharSequenceArray(SAVE_STATE_ENTRIES);
            mEntryValues = savedInstanceState.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_STATE_INDEX, mClickedDialogEntryIndex);
        outState.putCharSequenceArray(SAVE_STATE_ENTRIES, mEntries);
        outState.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, mEntryValues);
    }

    private ListPreference getListPreference() {
        return (ListPreference) getPreference();
    }
    
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), R.style.ThemeOverlay_SettingsLib_MaterialAlertDialog_Centered);
        builder.setIcon(getPreference().getDialogIcon());
        builder.setNegativeButton(getPreference().getNegativeButtonText(), this);
        builder.setPositiveButton(getPreference().getPositiveButtonText(), this);
        builder.setTitle(getPreference().getDialogTitle());
        View contentView = onCreateDialogView(requireContext());
        if (contentView != null) {
            onBindDialogView(contentView);
            builder.setView(contentView);
        } else {
            builder.setMessage(getPreference().getDialogMessage());
        }
        onPrepareDialogBuilder(builder);
        Dialog dialog = builder.create();
        return dialog;
    }
    
    @Override
    protected void onPrepareDialogBuilder(@NonNull MaterialAlertDialogBuilder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setSingleChoiceItems(mEntries, mClickedDialogEntryIndex,
            (dialog, which) -> {
                mClickedDialogEntryIndex = which;
                onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                dialog.dismiss();
            }
        );
        builder.setPositiveButton(null, null);
    }

    @Override
    public void onDialogClosed(boolean positiveResult) {
        if (positiveResult && mClickedDialogEntryIndex >= 0) {
            String value = mEntryValues[mClickedDialogEntryIndex].toString();
            ListPreference preference = getListPreference();
            if (preference.callChangeListener(value)) {
                preference.setValue(value);
            }
        }
    }
}