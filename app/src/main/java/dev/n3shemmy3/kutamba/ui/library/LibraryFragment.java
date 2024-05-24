package dev.n3shemmy3.kutamba.ui.library;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.base.AppCompatFragment;

public class LibraryFragment  extends AppCompatFragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.label_library);
        toolbar.setOnClickListener(v -> navigate(R.id.openSettings));
    }
}
