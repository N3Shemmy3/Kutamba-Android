package dev.n3shemmy3.kutamba.fragment;


import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import dev.n3shemmy3.kutamba.R;

public class SettingsFragment extends PreferenceFragmentCompat {
 @Override
    public void onCreatePreferences(Bundle state, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
    
}
