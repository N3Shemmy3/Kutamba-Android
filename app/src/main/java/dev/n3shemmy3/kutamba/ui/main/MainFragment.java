package dev.n3shemmy3.kutamba.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.imageview.ShapeableImageView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.AppFragment;

public class MainFragment extends AppFragment implements Toolbar.OnMenuItemClickListener {


    private ShapeableImageView avatar;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar.setOnMenuItemClickListener(this);
        avatar = toolbar.getMenu().findItem(R.id.actionMenu).getActionView().findViewById(R.id.avatar);
        avatar.setOnClickListener(v -> navigate(R.id.openDetails));
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionSearch -> navigate(R.id.openSearch);
            case R.id.actionMenu -> navigate(R.id.openDetails);
        }
        return true;
    }
}
