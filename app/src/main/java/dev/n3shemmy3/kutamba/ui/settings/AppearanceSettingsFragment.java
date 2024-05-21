package dev.n3shemmy3.kutamba.ui.settings;

import android.os.Bundle;

import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.BasePreferenceFragment;
import dev.n3shemmy3.kutamba.ui.base.BaseSettingsFragment;

public class AppearanceSettingsFragment extends BaseSettingsFragment {
    public AppearanceSettingsFragment() {
        super(R.string.label_appearance, new AppearancePreferenceFragment());
    }

    public static class AppearancePreferenceFragment extends BasePreferenceFragment {

        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.preferences_appearance, rootKey);
        }
    }
}
