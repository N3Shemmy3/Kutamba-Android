package dev.n3shemmy3.kutamba.ui.widget;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.color.MaterialColors;

public class ThemedSwipeRefreshLayout extends SwipeRefreshLayout {
    public ThemedSwipeRefreshLayout(@NonNull Context context) {
        super(context);
        onInit(context);
    }

    public ThemedSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit(context);
    }

    @SuppressLint("ResourceType")
    void onInit(Context context) {
        setProgressBackgroundColorSchemeColor(getColor(com.google.android.material.R.attr.colorPrimary));
        // This updates the progress arrow color
        setColorSchemeColors(getColor(com.google.android.material.R.attr.colorOnPrimary));
    }

    @ColorInt
    public int getColor(int attr) {
        return MaterialColors.getColor(
                this,
                attr
        );
    }
}
