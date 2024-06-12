package dev.n3shemmy3.kutamba.ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;

public class DebugActivity extends AppCompatActivity {

    private String errors;
    private MaterialToolbar toolbar;
    private TextView logs;
    private ExtendedFloatingActionButton fab;

    @Override
    protected void onCreate(Bundle state) {
        EdgeToEdge.enable(this);
        super.onCreate(state);
        setContentView(R.layout.activity_debug);
        findViews();
        logic(state);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(1, () -> {
                navigateUp();
            });
        } else {
            getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {
                    navigateUp();
                }
            });
        }
    }

    private void navigateUp() {
        if (logs.toString().isEmpty()) {
            finish();
        } else {
            finishAffinity();
        }
    }

    private void findViews() {
        toolbar = findViewById(R.id.toolBar);
        logs = findViewById(R.id.logs);
        fab = findViewById(R.id.fab);

        toolbar.setNavigationOnClickListener(v -> finishAffinity());
        InsetsUtil.addSystemBarsInsets(findViewById(R.id.appBar));
        InsetsUtil.addSystemBarsInsets(findViewById(R.id.fabParent), true, false, true, true);
    }

    private void logic(Bundle state) {
        Intent intent = getIntent();
        String exceptionMessage = intent.getStringExtra("exception_message");
        String threadName = intent.getStringExtra("thread");
        Log.e("Kutamba>App", "Error on thread $threadName:\n $exceptionMessage");
        String deviceBrand = Build.BRAND;
        String deviceModel = Build.MODEL;
        int sdkLevel = Build.VERSION.SDK_INT;
        Date currentDateTime = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String formattedDateTime = formatter.format(currentDateTime);
        String versionName = "";
        try {
            versionName = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //android studio removed the StringBuilder :D
        String stringBuilder = "Version" + ':' + ' ' + versionName + '\n' + "Phone Brand" + ':' + "     " + deviceBrand + '\n' + "Phone Model" + ':' + "     " + deviceModel + '\n' + "Phone SDK Level" + ':' + ' ' + sdkLevel + '\n' + "Crash Thread" + ':' + "    " + threadName + '\n' + "Time" + ':' + ' ' + formattedDateTime + '\n' + '\n' + '\n' + exceptionMessage;
        logs.setTypeface(Typeface.MONOSPACE);
        logs.setText(stringBuilder);
        fab.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TITLE, "Kutamba logs");
            sendIntent.putExtra(Intent.EXTRA_TEXT, logs.getText());
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });
    }

}
