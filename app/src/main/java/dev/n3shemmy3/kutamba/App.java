package dev.n3shemmy3.kutamba;

import android.app.Application;
import android.content.ContextWrapper;

import dev.n3shemmy3.kutamba.ui.util.Prefs;

public class App extends Application {
    @Override
    public void onCreate() {
        //getCrashLogs();
        super.onCreate();
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
}
