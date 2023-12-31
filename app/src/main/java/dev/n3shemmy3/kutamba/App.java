package dev.n3shemmy3.kutamba;


import android.app.Application;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.utilities.DynamicColor;
import dev.n3shemmy3.kutamba.util.CrashHandler;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
        CrashHandler.INSTANCE.init(getApplicationContext());
    }
}
