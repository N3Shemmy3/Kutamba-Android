package dev.n3shemmy3.kutamba.ui.settings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.preference.Preference;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.BasePreferenceFragment;
import dev.n3shemmy3.kutamba.ui.base.BaseSettingsFragment;

public class SettingsFragment extends BaseSettingsFragment {
    public SettingsFragment() {
        super(R.string.label_settings, new MainPreferenceFragment());
    }

    public static class MainPreferenceFragment extends BasePreferenceFragment {

        @Override
        public void onCreatePreferences(Bundle bundle, String key) {
            setPreferencesFromResource(R.xml.preferences, key);
        }

        @Override
        public boolean onPreferenceTreeClick(@NonNull Preference preference) {
            switch (preference.getKey()) {
                case "appearance" -> navigate(R.id.openAppearanceSettings);
                case "browse" -> navigate(R.id.openBrowseSettings);
                case "about" -> navigate(R.id.openAboutSettingsFragment);

            }
            return super.onPreferenceTreeClick(preference);
        }


    }
}
