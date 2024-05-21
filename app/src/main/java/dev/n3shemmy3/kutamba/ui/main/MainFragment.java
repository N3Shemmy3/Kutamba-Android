package dev.n3shemmy3.kutamba.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.BaseFragment;

public class MainFragment extends BaseFragment implements NavigationBarView.OnItemSelectedListener {


    private ViewPager2 pager;
    private BottomNavigationView nav;
    private MainPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        pager = root.findViewById(R.id.viewPager);
        nav = root.findViewById(R.id.nav);

        adapter = new MainPagerAdapter(getChildFragmentManager(), getLifecycle());
        pager.setAdapter(adapter);
        pager.setUserInputEnabled(false);
        pager.setOffscreenPageLimit(4);
        nav.setOnItemSelectedListener(this);
        return root;
    }

    @Override
    public boolean onBackPressed() {
        if (nav.getSelectedItemId() != R.id.mainFragemnt) {
            nav.setSelectedItemId(R.id.mainFragemnt);
            return true;
        }
        return super.onBackPressed();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.mainFragemnt:
                pager.setCurrentItem(0, false);
                break;
            case R.id.historyFragment:
                pager.setCurrentItem(1, false);
                break;
            case R.id.browseFragment:
                pager.setCurrentItem(2, false);
                break;
            case R.id.moreFragment:
                pager.setCurrentItem(3, false);
                break;
        }
        return true;
    }
}
