package dev.n3shemmy3.material.preference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MaterialEditTextPreferenceDialog extends MaterialPreferenceDialog {

    private static final String SAVE_STATE_TEXT = "M3EditTextPreferenceDialogFragment.text";

    private EditText mEditText;

    private CharSequence mText;

    private final Runnable mShowSoftInputRunnable = this::scheduleShowSoftInputInner;
    private long mShowRequestTime = -1;
    private static final int SHOW_REQUEST_TIMEOUT = 1000;

    @NonNull
    public static MaterialEditTextPreferenceDialog newInstance(@NonNull String key) {
        final MaterialEditTextPreferenceDialog
                fragment = new MaterialEditTextPreferenceDialog();
        final Bundle b = new Bundle(1);
        b.putString(ARG_KEY, key);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mText = getEditTextPreference().getText();
        } else {
            mText = savedInstanceState.getCharSequence(SAVE_STATE_TEXT);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(SAVE_STATE_TEXT, mText);
    }

    @Override
    protected void onBindDialogView(@NonNull View view) {
        super.onBindDialogView(view);

        mEditText = view.findViewById(android.R.id.edit);

        if (mEditText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id" +
                    " @android:id/edit");
        }

        mEditText.requestFocus();
        mEditText.setText(mText);
        // Place cursor at the end
        mEditText.setSelection(mEditText.getText().length());
        if (getEditTextPreference().getOnBindEditTextListener() != null) {
            getEditTextPreference().getOnBindEditTextListener().onBindEditText(mEditText);
        }
    }

    private MaterialEditTextPreference getEditTextPreference() {
        return (MaterialEditTextPreference) getPreference();
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected boolean needInputMethod() {
        // We want the input method to show, if possible, when dialog is displayed
        return true;
    }

    private boolean hasPendingShowSoftInputRequest() {
        return (mShowRequestTime != -1 && ((mShowRequestTime + SHOW_REQUEST_TIMEOUT)
                > SystemClock.currentThreadTimeMillis()));
    }

    private void setPendingShowSoftInputRequest(boolean pendingShowSoftInputRequest) {
        mShowRequestTime = pendingShowSoftInputRequest ? SystemClock.currentThreadTimeMillis() : -1;
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void scheduleShowSoftInput() {
        setPendingShowSoftInputRequest(true);
        scheduleShowSoftInputInner();
    }

    void scheduleShowSoftInputInner() {
        if (hasPendingShowSoftInputRequest()) {
            if (mEditText == null || !mEditText.isFocused()) {
                setPendingShowSoftInputRequest(false);
                return;
            }
            final InputMethodManager imm = (InputMethodManager)
                    mEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            // Schedule showSoftInput once the input connection of the editor established.
            if (imm.showSoftInput(mEditText, 0)) {
                setPendingShowSoftInputRequest(false);
            } else {
                mEditText.removeCallbacks(mShowSoftInputRunnable);
                mEditText.postDelayed(mShowSoftInputRunnable, 50);
            }
        }
    }

    @Override
    public void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            String value = mEditText.getText().toString();
            final MaterialEditTextPreference preference = getEditTextPreference();
            if (preference.callChangeListener(value)) {
                preference.setText(value);
            }
        }
    }
}