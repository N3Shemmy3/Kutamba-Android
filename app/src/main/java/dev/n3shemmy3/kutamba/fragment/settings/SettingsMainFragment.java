package dev.n3shemmy3.kutamba.fragment.settings;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import dev.n3shemmy3.kutamba.R;

public class SettingsMainFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Load the preferences from an XML resource
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
    /*
   @Override
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        super.setPreferenceScreen(preferenceScreen);
        if (preferenceScreen != null) {
            int count = preferenceScreen.getPreferenceCount();
            for (int i = 0; i < count; i++)
                preferenceScreen.getPreference(i).setIconSpaceReserved(false);
        }
    }
    */
}
