package dev.n3shemmy3.kutamba.ui.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;

public class SearchFragment extends AppFragment implements TextWatcher, View.OnClickListener {

    private EditText searchView;
    private Button searchButton;
    private Button clearButton;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = view.findViewById(R.id.searchView);
        searchButton = view.findViewById(R.id.searchButton);
        clearButton = view.findViewById(R.id.clearButton);

        toolbar.setTitle(R.string.label_search);
        toolbar.setNavigationIcon(R.drawable.outline_arrow_back_24);
        toolbar.setNavigationOnClickListener(v -> {
            if (searchView.isEnabled())
                searchView.setEnabled(false);
            else
                navigateUp();
        });

        /*
        for some reason the EditText inflates and gets enabled
        which breaks the back navigation
         */
        searchView.setEnabled(false);
        searchView.addTextChangedListener(this);
        searchView.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchView.setEnabled(false);
                return true;
            }
            return false;
        });
        searchView.setOnFocusChangeListener((v, hasFocus) -> {
            InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            searchButton.setVisibility(hasFocus ? View.GONE : View.VISIBLE);
            clearButton.setVisibility(hasFocus ? View.VISIBLE : View.GONE);
            if (hasFocus)
                imm.showSoftInput(searchView, InputMethodManager.SHOW_FORCED);
            else
                imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
        });
        clearButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (searchView.isEnabled()) {
                    searchView.setEnabled(false);
                    return;
                }
                navigateUp();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clearButton:
                searchView.setText("".trim());
                break;
            case R.id.searchButton:
                searchView.setEnabled(!searchView.isEnabled());
                if (searchView.isEnabled()) {
                    searchView.requestFocus();
                }
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        clearButton.setVisibility(s.length() > 3 ? View.VISIBLE : View.GONE);
    }


}
