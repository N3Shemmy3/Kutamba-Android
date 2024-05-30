package dev.n3shemmy3.kutamba.ui.adapter.decor;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int startSpace;
    private final int spacing;
    private int endSpaceCache = 0;

    public HorizontalSpaceItemDecoration(Context context, @DimenRes int spaceStartResId, @DimenRes int spaceBetweenResId) {
        this.startSpace = context.getResources().getDimensionPixelOffset(spaceStartResId);
        this.spacing = context.getResources().getDimensionPixelOffset(spaceBetweenResId);
    }

    private boolean isLastItem(View view, RecyclerView parent) {
        final int adapter_size = Objects.requireNonNull(parent.getAdapter()).getItemCount();
        final int pos = parent.getChildAdapterPosition(view);
        return (pos == adapter_size -1);
    }

    private boolean isFirstItem(View view, RecyclerView parent) {
        final int pos = parent.getChildAdapterPosition(view);
        return (pos == 0);
    }

    private int endSpacing(View view, RecyclerView parent) {
        if (endSpaceCache == 0) {
            final int aw = parent.getMeasuredWidth();
            final int vw = view.getMeasuredWidth();
            if (vw != 0) {  // yes, happens
                endSpaceCache = (aw - vw + spacing)/2;
            }
        }
        return endSpaceCache;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (isFirstItem(view, parent)) {
            outRect.left = startSpace;
        }
        if (isLastItem(view, parent)) {
            outRect.right = endSpacing(view, parent);
        } else {
            outRect.right = spacing;
        }
    }
}