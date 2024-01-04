package dev.n3shemmy3.kutamba.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dev.n3shemmy3.kutamba.R;

public class CategoryPreferenceViewHolder extends RecyclerView.ViewHolder {

  public RelativeLayout item;
  public ImageView itemIcon;
  public TextView itemText;

  public CategoryPreferenceViewHolder(@NonNull View view) {
    super(view);
    item = view.findViewById(R.id.item);
    itemIcon = view.findViewById(R.id.itemIcon);
    itemText = view.findViewById(R.id.itemText);
  }
}
