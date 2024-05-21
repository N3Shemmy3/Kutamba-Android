package dev.n3shemmy3.kutamba.ui.search;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;

public class SearchFragment extends AppFragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.label_search);
        toolbar.setNavigationIcon(R.drawable.outline_arrow_back_24);
        toolbar.setOnClickListener(v -> navigate(R.id.openSearch));
    }
}
