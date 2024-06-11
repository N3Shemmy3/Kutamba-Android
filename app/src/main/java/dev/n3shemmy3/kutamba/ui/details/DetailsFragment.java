package dev.n3shemmy3.kutamba.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;

public class DetailsFragment extends AppFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_details;
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationIcon(R.drawable.outline_arrow_back_24);
    }
}
