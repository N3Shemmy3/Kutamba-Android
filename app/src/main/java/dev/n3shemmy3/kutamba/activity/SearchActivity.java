package dev.n3shemmy3.kutamba.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.search.SearchView;
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
        String transitionName = "appBarTransition";
        ViewCompat.setTransitionName(appbar, transitionName);

    }
    
    private void onCreateLayout() {
        toolbar = findViewById(R.id.toolbar);
        appbar = findViewById(R.id.appbar);
        
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        AppUtils.setViewInets(appbar, true, true, true, false);
    }
    
    private void onCodeInit(Bundle state) {
        
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the Up button click
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
