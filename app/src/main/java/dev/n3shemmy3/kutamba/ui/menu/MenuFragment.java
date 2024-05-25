package dev.n3shemmy3.kutamba.ui.menu;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;

public class MenuFragment extends AppFragment {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_collappbar;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.label_menu);
        toolbar.setNavigationIcon(R.drawable.outline_arrow_back_24);

        if (savedInstanceState == null) {
         //   setContentView(new RecyclerFragment());
        }
    }


}
