package dev.n3shemmy3.kutamba.activity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.MainThread;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.Navigation;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.util.AppUtils;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    
    private AppBarConfiguration appBarConfig;

    private DrawerLayout drawer;
    private NavigationView navView;
    private CoordinatorLayout coordinator;
    private MaterialToolbar toolbar;
    private AppBarLayout appbar;
    private FloatingActionButton fab;
    private NavHostFragment navHost;
    private NavController navController;
    private Set<Integer> topLevelDestinations;
    
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);
		onCreateLayout(state);
        onCodeInit(state);
    }
    
    private void onCreateLayout(Bundle state) {
        drawer = findViewById(R.id.drawer);
        coordinator = findViewById(R.id.coordinator);
        navView = findViewById(R.id.navView);
        appbar = findViewById(R.id.appbar);
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);
        
        
        navHost = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navHost);
      //  if (navHost != null) 
        navController = navHost.getNavController();
        appBarConfig =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.menu_home);
        topLevelDestinations.add(R.id.two);
        appBarConfig = new AppBarConfiguration.Builder(topLevelDestinations)
            .setOpenableLayout(drawer)
            .build();
        setSupportActionBar(toolbar);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        NavigationUI.setupWithNavController(navView,navController);
        AppUtils.setViewInets(appbar, true, true, true, false);
        AppUtils.setViewInets(fab, false, false, false, false);
    }
        

    private void onCodeInit(Bundle state) {
       
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean retValue = super.onCreateOptionsMenu(menu);
        return retValue;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(this, R.id.navHost))
                || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.navHost), appBarConfig);
    }

    @Override
    @MainThread
    public void onBackPressed() {
        if (drawer.isOpen()) {
            drawer.close(); 
        }else {
            super.onBackPressed();
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}