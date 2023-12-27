package dev.n3shemmy3.kutamba.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.WindowCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.util.AppUtils;

public class SearchActivity extends AppCompatActivity {
    
    private MaterialToolbar toolbar;
    private AppBarLayout appbar;
    private ActionBar actionBar;
    
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_search);
        onCreateLayout();
        onCodeInit(state);
    }
    
    private void onCreateLayout() {
        toolbar = findViewById(R.id.toolbar);
        appbar = findViewById(R.id.appbar);
        
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        
        AppUtils.setViewInets(appbar, true, true, true, false);
    }
    
    private void onCodeInit(Bundle state) {
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the query submission
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle the query text change
                return true;
            }
        });

        return true;
    }
}
