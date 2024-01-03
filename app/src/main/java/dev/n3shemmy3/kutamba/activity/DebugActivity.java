package dev.n3shemmy3.kutamba.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.util.AppUtils;

public class DebugActivity extends AppCompatActivity {

  private AppBarLayout appbar;
  private MaterialToolbar toolbar;
  private CodeView codeView;

  @Override
  protected void onCreate(Bundle state) {
    super.onCreate(state);
    WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    setContentView(R.layout.activity_debug);
    onCreateLayout(state);
    onCodeInit(state);
  }

  private void onCreateLayout(Bundle state) {
    appbar = findViewById(R.id.appbar);
    toolbar = findViewById(R.id.toolbar);
    codeView = findViewById(R.id.codeView);
    setSupportActionBar(toolbar);
    AppUtils.setViewInets(appbar, true, true, true, false);
  }

  private void onCodeInit(Bundle state) {
    Intent intent = getIntent();
    boolean isNightMode = false;
    int nightModeFlags =
        getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
    switch (nightModeFlags) {
      case Configuration.UI_MODE_NIGHT_YES:
        isNightMode = true;
        break;

      case Configuration.UI_MODE_NIGHT_NO:
        isNightMode = false;
        break;

      case Configuration.UI_MODE_NIGHT_UNDEFINED:
        isNightMode = false;
        break;
    }
    codeView
        .setTheme(isNightMode ? Theme.DARK : Theme.GITHUB_GIST)
        .setCode(intent.getStringExtra("logs"))
        .setLanguage(Language.JAVA)
        .setWrapLine(false)
        .setFontSize(15)
        .setZoomEnabled(true)
        .setShowLineNumber(true)
        .setStartLineNumber(0)
        .apply();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
        if (codeView.getCode().toString().length() > 0) {
            finish();
        } else {
            finishAffinity();
        }
  }
}
