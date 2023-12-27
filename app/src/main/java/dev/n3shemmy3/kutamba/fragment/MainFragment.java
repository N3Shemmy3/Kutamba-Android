package dev.n3shemmy3.kutamba.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.n3shemmy3.kutamba.R;

public class MainFragment extends Fragment {
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle state) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
    }
}
