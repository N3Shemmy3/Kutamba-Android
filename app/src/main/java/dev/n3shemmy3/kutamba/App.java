package dev.n3shemmy3.kutamba;

import android.app.Application;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.Log;

import dev.n3shemmy3.kutamba.ui.activity.DebugActivity;
import dev.n3shemmy3.kutamba.ui.util.Prefs;

public class App extends Application {
    @Override
    public void onCreate() {
        getCrashLogs();
        super.onCreate();
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
    void getCrashLogs() {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            String exceptionMessage = Log.getStackTraceString(e);
            String threadName = Thread.currentThread().getName();
            Intent intent = new Intent(this, DebugActivity.class);
            intent.putExtra("exception_message", exceptionMessage);
            intent.putExtra("thread", threadName);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            System.exit(10);
        });
    }
}
