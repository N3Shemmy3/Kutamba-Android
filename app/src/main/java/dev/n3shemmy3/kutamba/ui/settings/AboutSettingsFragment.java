package dev.n3shemmy3.kutamba.ui.settings;

import android.os.Bundle;

import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.BasePreferenceFragment;
import dev.n3shemmy3.kutamba.ui.base.BaseSettingsFragment;

public class AboutSettingsFragment extends BaseSettingsFragment {

    public AboutSettingsFragment() {
        super(R.string.label_about, new AboutPreferenceFragment());
    }

    public static class AboutPreferenceFragment extends BasePreferenceFragment {
        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.preferences_about, rootKey);
        }
    }

}
