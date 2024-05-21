package dev.n3shemmy3.kutamba.ui.settings;


import android.os.Bundle;

import androidx.preference.Preference;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.BasePreferenceFragment;
import dev.n3shemmy3.kutamba.ui.base.BaseSettingsFragment;


public class BrowseSettingsFragment extends BaseSettingsFragment {

    public BrowseSettingsFragment() {
        super(R.string.label_browse, new BrowsePreferenceFragment());
    }

    public static class BrowsePreferenceFragment extends BasePreferenceFragment {
        @Override
        public void onCreatePreferences(Bundle bundle, String key) {
            setPreferencesFromResource(R.xml.preferences_browse, key);


            Preference repository = findPreference("repository");
            assert repository != null;
           /*
            repository.setSummary(Prefs.getString("repository", "https://consumet-api-oh8t.onrender.com"));
            repository.setOnPreferenceClickListener(preference -> {
                OnboardingFragment onboardingFragment = new OnboardingFragment();
                Bundle args = new Bundle();
                args.putBoolean("isFirstTime", false);
                onboardingFragment.setArguments(bundle);
                //     pushChildPreference(onboardingFragment);
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_input, null);
                TextInputEditText inputEditText = view.findViewById(R.id.inputText);
                ((TextInputLayout) view.findViewById(R.id.inputLayout)).setHint("Base url");
                inputEditText.setText(Prefs.getString(repository.getKey(), "".trim()));
                new MaterialAlertDialogBuilder(requireContext())
                        .setTitle("A Repository Url")
                        .setMessage("A base url that the app uses to fetch content from")
                        .setView(view)
                        .setPositiveButton(R.string.action_save, (dialog, which) -> {
                            Prefs.putString(repository.getKey(), inputEditText.getText().toString().trim());
                            repository.setSummary(inputEditText.getText());

                        })
                        .setNegativeButton(R.string.action_cancel, null)
                        .show();

            return false;
        });
                 */
        }
    }
}

