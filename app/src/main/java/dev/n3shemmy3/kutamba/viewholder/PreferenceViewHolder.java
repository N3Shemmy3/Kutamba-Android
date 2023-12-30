package dev.n3shemmy3.kutamba.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dev.n3shemmy3.kutamba.R;

public class PreferenceViewHolder extends CategoryPreferenceViewHolder {

  public TextView itemTextSecondary;

  public PreferenceViewHolder(@NonNull View view) {
    super(view);
    itemTextSecondary = view.findViewById(R.id.itemSecondaryText);
  }
}
