package dev.n3shemmy3.kutamba.fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import dev.n3shemmy3.kutamba.R;

public class SettingsFragment extends PreferenceFragmentCompat {
 @Override
    public void onCreatePreferences(Bundle state, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        
    
        findPreference(getString(R.string.label_about)).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    // Handle the click event here
                    // Return true if you want to consume the click event
                    openLicensws();
                    return true;
                }
            });
    }
    @Override
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        super.setPreferenceScreen(preferenceScreen);
        if (preferenceScreen != null) {
            int count = preferenceScreen.getPreferenceCount();
            for (int i = 0; i < count; i++)
                preferenceScreen.getPreference(i).setIconSpaceReserved(false);
        }
    }
    
    private void openLicensws(){
       startActivity(new Intent(getActivity(), OssLicensesMenuActivity.class));
    }
}
