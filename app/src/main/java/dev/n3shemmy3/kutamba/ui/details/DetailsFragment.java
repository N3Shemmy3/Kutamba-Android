package dev.n3shemmy3.kutamba.ui.details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

public class DetailsFragment extends AppFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle state) {
        InsetsUtil.addSystemBarsInsets(view.findViewById(R.id.bottomBar), false, false, false, true);
    }
}
