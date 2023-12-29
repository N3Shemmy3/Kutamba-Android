package dev.n3shemmy3.kutamba.activity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavDestination;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
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
import com.google.android.material.search.SearchView;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.util.AppUtils;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements NavController.OnDestinationChangedListener {
    
    
    private DrawerLayout drawer;
    private NavigationView navView;
    private CoordinatorLayout coordinator;
    private AppBarLayout appbar;
    private CollapsingToolbarLayout collToolbar;
    private MaterialToolbar toolbar;
    private FloatingActionButton fab;
    
    private AppBarConfiguration appBarConfig;
    private NavController navController;
    private NavHostFragment navHost;
    
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);
		onCreateLayout(state);
        onCodeInit(state);
    }
    
    private void onCreateLayout(Bundle state) {
        navHost = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navHost);
        navController = navHost.getNavController();
             }
        

    private void onCodeInit(Bundle state) {
       
    }
    @Override
    public void onDestinationChanged(
        @NonNull NavController controller,
        @NonNull NavDestination destination,
        Bundle args) {
        }
    @Override
    public boolean onSupportNavigateUp() {
        navController = Navigation.findNavController(this, R.id.navHost);
        return NavigationUI.navigateUp(navController, appBarConfig)
            || super.onSupportNavigateUp();
    }
    
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}