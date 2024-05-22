package com.projectmaterial.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.projectmaterial.videos.R;

public class M3TopIntroPreference extends Preference {
    
    public M3TopIntroPreference(Context context) {
        super(context);
        setLayoutResource(R.layout.settingslib_top_intro_preference);
        setSelectable(false);
    }
    
    public M3TopIntroPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.settingslib_top_intro_preference);
        setSelectable(false);
    }
    
    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        holder.setDividerAllowedAbove(false);
        holder.setDividerAllowedBelow(false);
    }
}
