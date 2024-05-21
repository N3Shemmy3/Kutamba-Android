package dev.n3shemmy3.kutamba.ui.util;

import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InsetsUtil {

    public static void addSystemBarsInsets(View view) {
        addSystemBarsInsets(view, false, true, false, false);
    }

    public static void addSystemBarsInsets(View view, boolean left, boolean top, boolean right, boolean bottom) {
        ViewCompat.setOnApplyWindowInsetsListener(view, (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(left ? insets.left : 0, top ? insets.top : 0, right ? insets.right : 0, bottom ? insets.bottom : 0);
            return WindowInsetsCompat.CONSUMED;
        });
    }
}
