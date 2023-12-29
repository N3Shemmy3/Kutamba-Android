package dev.n3shemmy3.kutamba.viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import dev.n3shemmy3.kutamba.R;

public class AnimeViewHolder extends RecyclerView.ViewHolder {

  public RelativeLayout item;
  public ShapeableImageView itemImg;
  public TextView itemTitle;

  public AnimeViewHolder(@NonNull View view) {
    super(view);
    item = view.findViewById(R.id.item);
    itemImg = view.findViewById(R.id.itemImg);
    itemTitle = view.findViewById(R.id.itemTitle);
  }
}
