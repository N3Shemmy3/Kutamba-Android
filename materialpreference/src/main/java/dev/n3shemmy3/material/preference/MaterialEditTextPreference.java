package dev.n3shemmy3.material.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.EditTextPreference;

public class MaterialEditTextPreference extends EditTextPreference {

    @Nullable
    private OnBindEditTextListener mOnBindEditTextListener;

    public MaterialEditTextPreference(@NonNull Context context, @Nullable AttributeSet attrs,
                                      int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MaterialEditTextPreference(@NonNull Context context, @Nullable AttributeSet attrs,
                                      int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MaterialEditTextPreference(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialEditTextPreference(@NonNull Context context) {
        super(context);
    }

    public void setOnBindEditTextListener(@Nullable OnBindEditTextListener onBindEditTextListener) {
        mOnBindEditTextListener = onBindEditTextListener;
    }
 
    @Nullable OnBindEditTextListener getOnBindEditTextListener() {
        return mOnBindEditTextListener;
    }

    public interface OnBindEditTextListener {
        void onBindEditText(@NonNull EditText editText);
    }
}