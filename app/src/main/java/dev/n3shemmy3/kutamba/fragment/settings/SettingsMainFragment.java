package dev.n3shemmy3.kutamba.fragment.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.adapter.PreferenceAdapter;
import dev.n3shemmy3.kutamba.fragment.BaseFragment;
import dev.n3shemmy3.kutamba.model.Preference;
import dev.n3shemmy3.kutamba.util.AppUtils;
import java.util.ArrayList;

public class SettingsMainFragment extends BaseFragment {

    private RecyclerView recycler;
    private LinearLayoutManager lManager;
    private PreferenceAdapter adapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle state) {
        return inflater.inflate(R.layout.list_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
        onCreateLayout(view);
        onCodeInit(state);
    }

    private void onCreateLayout(View view) {
        recycler = view.findViewById(R.id.recycler);
        lManager = new LinearLayoutManager(getContext());
        adapter = new PreferenceAdapter();
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(lManager);
        recycler.setAdapter(adapter);
        AppUtils.setViewInets(recycler, false, false, false, true);
    }

    private void onCodeInit(Bundle state) {
        Snackbar snackbar = Snackbar.make(getView(), "Your message here", Snackbar.LENGTH_SHORT);
        snackbar.setAction("Action", v -> {});

        ArrayList<Preference> list = new ArrayList<>();

        list.add(
                new Preference(
                        list.size() - 1,
                        R.drawable.outline_aod_24,
                        R.string.display_title,
                        R.string.diaplay_contents,
                        Preference.NORMAL,
                        (preference, position) -> {
                            getNavController().navigate(R.id.open_settingsDisplayFragment);
                        }));
        adapter.add(list);
    }
}
