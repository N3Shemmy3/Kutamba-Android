package dev.n3shemmy3.material.preference;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.MultiSelectListPreference;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MaterialMultiSelectListPreferenceDialog extends MaterialPreferenceDialog {
    private static final String SAVE_STATE_VALUES =
            "M3MultiSelectListPreferenceDialogFragmentCompat.values";
    private static final String SAVE_STATE_CHANGED =
            "M3MultiSelectListPreferenceDialogFragmentCompat.changed";
    private static final String SAVE_STATE_ENTRIES =
            "M3MultiSelectListPreferenceDialogFragmentCompat.entries";
    private static final String SAVE_STATE_ENTRY_VALUES =
            "M3MultiSelectListPreferenceDialogFragmentCompat.entryValues";
    
    @SuppressWarnings("WeakerAccess") /* synthetic access */
    Set<String> mNewValues = new HashSet<>();
    @SuppressWarnings("WeakerAccess") /* synthetic access */
    boolean mPreferenceChanged;
    @SuppressWarnings("WeakerAccess") /* synthetic access */
    CharSequence[] mEntries;
    @SuppressWarnings("WeakerAccess") /* synthetic access */
    CharSequence[] mEntryValues;
    
    @NonNull
    public static MaterialMultiSelectListPreferenceDialog newInstance(@NonNull String key) {
        final MaterialMultiSelectListPreferenceDialog fragment =
                new MaterialMultiSelectListPreferenceDialog();
        final Bundle b = new Bundle(1);
        b.putString(ARG_KEY, key);
        fragment.setArguments(b);
        return fragment;
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            final MultiSelectListPreference preference = getListPreference();

            if (preference.getEntries() == null || preference.getEntryValues() == null) {
                throw new IllegalStateException(
                        "MultiSelectListPreference requires an entries array and " +
                                "an entryValues array.");
            }

            mNewValues.clear();
            mNewValues.addAll(preference.getValues());
            mPreferenceChanged = false;
            mEntries = preference.getEntries();
            mEntryValues = preference.getEntryValues();
        } else {
            mNewValues.clear();
            mNewValues.addAll(savedInstanceState.getStringArrayList(SAVE_STATE_VALUES));
            mPreferenceChanged = savedInstanceState.getBoolean(SAVE_STATE_CHANGED, false);
            mEntries = savedInstanceState.getCharSequenceArray(SAVE_STATE_ENTRIES);
            mEntryValues = savedInstanceState.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
        }
    }
    
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(SAVE_STATE_VALUES, new ArrayList<>(mNewValues));
        outState.putBoolean(SAVE_STATE_CHANGED, mPreferenceChanged);
        outState.putCharSequenceArray(SAVE_STATE_ENTRIES, mEntries);
        outState.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, mEntryValues);
    }
    
    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }
    
    protected void onPrepareDialogBuilder(@NonNull MaterialAlertDialogBuilder builder) {
        super.onPrepareDialogBuilder(builder);

        final int entryCount = mEntryValues.length;
        final boolean[] checkedItems = new boolean[entryCount];
        for (int i = 0; i < entryCount; i++) {
            checkedItems[i] = mNewValues.contains(mEntryValues[i].toString());
        }
        builder.setMultiChoiceItems(mEntries, checkedItems,
                (dialog, which, isChecked) -> {
                    if (isChecked) {
                        mPreferenceChanged |= mNewValues.add(
                                mEntryValues[which].toString());
                    } else {
                        mPreferenceChanged |= mNewValues.remove(
                                mEntryValues[which].toString());
                    }
                });
    }
    
    @Override
    public void onDialogClosed(boolean positiveResult) {
        if (positiveResult && mPreferenceChanged) {
            final MultiSelectListPreference preference = getListPreference();
            if (preference.callChangeListener(mNewValues)) {
                preference.setValues(mNewValues);
            }
        }
        mPreferenceChanged = false;
    }
}