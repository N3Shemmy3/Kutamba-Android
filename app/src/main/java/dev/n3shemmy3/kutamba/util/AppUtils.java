package dev.n3shemmy3.kutamba.util;


import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AppUtils {
    
    
    public static void setViewInets(View view) {
        setViewInets(view,true, true, true, true);
    }
    
    public static void setViewInets(View view, boolean left, boolean top, boolean right, boolean bottom) {
       ViewCompat.setOnApplyWindowInsetsListener(view, (v, windowInsets) -> {
                Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
                MarginLayoutParams mlp = (MarginLayoutParams) v.getLayoutParams();
                
                if (left) mlp.leftMargin = insets.left;
                if (top) mlp.topMargin = insets.top;
                if (right) mlp.rightMargin = insets.right;
                if (bottom) mlp.bottomMargin = insets.bottom;
                v.setLayoutParams(mlp);
                return WindowInsetsCompat.CONSUMED;
        }); 
    }
   public static void setViewInetsPadding(View view, boolean left, boolean top, boolean right, boolean bottom) {
       ViewCompat.setOnApplyWindowInsetsListener(view, (v, windowInsets) -> {
                Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
                //MarginLayoutParams mlp = (MarginLayoutParams) v.getLayoutParams();
                int topP=0, leftP=0, rightP=0, bottomP=0;
                if (left) leftP = insets.left;
                if (top) topP = insets.top;
                if (right) rightP = insets.right;
                if (bottom) bottomP = insets.bottom;
                //v.setLayoutParams(mlp);
                v.setPadding(leftP,topP,rightP,bottomP);
                return WindowInsetsCompat.CONSUMED;
        }); 
    }
}
