package dev.n3shemmy3.kutamba.viewholder;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.materialswitch.MaterialSwitch;
import dev.n3shemmy3.kutamba.R;

public class SwitchPreferenceViewHolder extends PreferenceViewHolder {
    
    public MaterialSwitch itemSwitch;
    
    public SwitchPreferenceViewHolder(@NonNull View view) {
        super(view);
        itemSwitch = view.findViewById(R.id.itemSwitch);
    }
}
