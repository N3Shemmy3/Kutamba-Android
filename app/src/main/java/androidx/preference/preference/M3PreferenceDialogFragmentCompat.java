package com.projectmaterial.preference;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceDialogFragmentCompat;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public abstract class M3PreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private int mWhichButtonClicked;
    
    @Override
    public @NonNull
    Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mWhichButtonClicked = DialogInterface.BUTTON_NEGATIVE;
        
        final MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), com.google.android.material.R.style.ThemeOverlay_Material3_MaterialAlertDialog_Centered)
                .setTitle(getPreference().getDialogTitle())
                .setIcon(getPreference().getDialogIcon())
                .setPositiveButton(getPreference().getPositiveButtonText(), this)
                .setNegativeButton(getPreference().getNegativeButtonText(), this);
        
        View contentView = onCreateDialogView(requireContext());
        if (contentView != null) {
            onBindDialogView(contentView);
            builder.setView(contentView);
        } else {
            builder.setMessage(getPreference().getDialogMessage());
        }
        
        onPrepareDialogBuilder(builder);
        
        // Create the dialog
        final Dialog dialog = builder.create();
        
        return dialog;
    }
    
    protected void onPrepareDialogBuilder(@NonNull MaterialAlertDialogBuilder builder) {}

    @Override
    public void onClick(@NonNull DialogInterface dialog, int which) {
        mWhichButtonClicked = which;
    }
    
    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        onDialogClosed(mWhichButtonClicked == DialogInterface.BUTTON_POSITIVE);
    }
}