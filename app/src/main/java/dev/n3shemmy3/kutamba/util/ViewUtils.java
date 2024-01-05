package dev.n3shemmy3.kutamba.util;

import android.app.Activity;
import android.graphics.Insets;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.Shader;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import android.graphics.LinearGradient;
import androidx.core.content.ContextCompat;

import com.google.android.material.color.MaterialColors;
import dev.n3shemmy3.kutamba.R;

public class ViewUtils {
    public static int getScreenWidth(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowMetrics windowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
            Insets insets =
                    windowMetrics
                            .getWindowInsets()
                            .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            return windowMetrics.getBounds().width() - insets.left - insets.right;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
    }

    public static void setHeaderForeground(ImageView img) {
        ShapeDrawable gradientDrawable = new ShapeDrawable(new RectShape());
        gradientDrawable
                .getPaint()
                .setShader(
                        new LinearGradient(
                                0f,
                                0f,
                                0f,
                                img.getHeight(),
                                ContextCompat.getColor(
                                        img.getContext(),
                                        R.color.md_theme_background), // Start color
                                adjustAlpha(
                                        ContextCompat.getColor(
                                                img.getContext(), R.color.md_theme_background),
                                        0.5f), // End color with adjusted alpha
                                Shader.TileMode.CLAMP));
        img.setForeground(gradientDrawable);
    }

    // Function to adjust alpha of a color
    public static int adjustAlpha(int color, float factor) {
        int alpha = (int) (255 * factor);
        return android.graphics.Color.argb(
                alpha,
                android.graphics.Color.red(color),
                android.graphics.Color.green(color),
                android.graphics.Color.blue(color));
    }
}
