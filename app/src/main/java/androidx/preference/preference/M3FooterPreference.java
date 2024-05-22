package com.projectmaterial.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.projectmaterial.videos.R;

public class M3FooterPreference extends Preference {
    private CharSequence mContentDescription;
    private static final int ORDER_FOOTER = Integer.MAX_VALUE - 1;
    private static final String KEY_FOOTER = "footer_preference";
    
    public M3FooterPreference(Context context) {
        this(context, null);
    }
    
    public M3FooterPreference(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.footerPreferenceStyle);
        setLayoutResource(R.layout.settingslib_preference_footer);
        
        
        init();
    }
    
    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        TextView title = holder.itemView.findViewById(android.R.id.title);
        if (title != null && !TextUtils.isEmpty(mContentDescription)) {
            title.setContentDescription(mContentDescription);
        }
        View icon = holder.itemView.findViewById(R.id.icon_frame);
    }
    
    @Override
    public CharSequence getSummary() {
        return getTitle();
    }
    
    @Override
    public void setSummary(CharSequence summary) {
        setTitle(summary);
    }
    
    @Override
    public void setSummary(int summaryResId) {
        setTitle(summaryResId);
    }
    
    public CharSequence getContentDescription() {
        return mContentDescription;
    }
    
    public void setContentDescription(CharSequence contentDescription) {
        if (!TextUtils.equals(mContentDescription, contentDescription)) {
            mContentDescription = contentDescription;
            notifyChanged();
        }
    }
    
    private void init() {
        
        if (getIcon() == null) {
            setIcon(R.drawable.quantum_ic_info_vd_theme_24);
        }
        setOrder(ORDER_FOOTER);
        if (TextUtils.isEmpty(getKey())) {
            setKey(KEY_FOOTER);
        }
        setSelectable(false);
    }
    
    public static class Builder {
        private Context mContext;
        private String mKey;
        private CharSequence mTitle;
        private CharSequence mContentDescription;
        private CharSequence mLearnMoreText;
        
        public Builder(@NonNull Context context) {
            mContext = context;
        }
        
        public Builder setKey(@NonNull String key) {
            mKey = key;
            return this;
        }
        
        public Builder setTitle(CharSequence title) {
            mTitle = title;
            return this;
        }
        
        public Builder setTitle(@StringRes int titleResId) {
            mTitle = mContext.getText(titleResId);
            return this;
        }
        
        public Builder setContentDescription(CharSequence contentDescription) {
            mContentDescription = contentDescription;
            return this;
        }
        
        public Builder setContentDescription(@StringRes int contentDescriptionResId) {
            mContentDescription = mContext.getText(contentDescriptionResId);
            return this;
        }
        
        public M3FooterPreference build() {
            final M3FooterPreference footerPreference = new M3FooterPreference(mContext);
            footerPreference.setSelectable(false);
            if (TextUtils.isEmpty(mTitle)) {
                throw new IllegalArgumentException("Footer title cannot be empty!");
            }
            footerPreference.setTitle(mTitle);
            if (!TextUtils.isEmpty(mKey)) {
                footerPreference.setKey(mKey);
            }
            if (!TextUtils.isEmpty(mContentDescription)) {
                footerPreference.setContentDescription(mContentDescription);
            }
            return footerPreference;
        }
    }
    
}