package dev.n3shemmy3.kutamba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.model.Preference;
import dev.n3shemmy3.kutamba.viewholder.CategoryPreferenceViewHolder;
import dev.n3shemmy3.kutamba.viewholder.PreferenceViewHolder;
import dev.n3shemmy3.kutamba.viewholder.SwitchPreferenceViewHolder;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PreferenceAdapter extends RecyclerView.Adapter<ViewHolder> {

  private ArrayList<Preference> preferences = new ArrayList<>();

  public PreferenceAdapter() {}

  public PreferenceAdapter(ArrayList<Preference> preferences) {
    this.preferences = preferences;
  }

  @Override
  public int getItemViewType(int position) {
    return preferences.get(position).getType();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    switch (viewType) {
      case Preference.CATEGORY:
        return new CategoryPreferenceViewHolder(
            inflater.inflate(R.layout.list_item_single_line, parent, false));

      case Preference.NORMAL:
        return new PreferenceViewHolder(
            inflater.inflate(R.layout.list_item_two_line, parent, false));

      case Preference.SWITCH:
        return new SwitchPreferenceViewHolder(
            inflater.inflate(R.layout.list_item_two_line_switch, parent, false));
    }
    return new CategoryPreferenceViewHolder(
        inflater.inflate(R.layout.list_item_single_line, parent, false));
  }

  /*
  this part isnt that beatutifull but hey this is java
  the home of boilerplate and i love it :D
  */
  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Preference pref = preferences.get(position);
    switch (holder.getItemViewType()) {
      case Preference.CATEGORY:
        CategoryPreferenceViewHolder cHolder = (CategoryPreferenceViewHolder) holder;
        cHolder.itemIcon.setImageResource(pref.getIcon());
        cHolder.itemText.setText(pref.getTitle());
        cHolder.item.setOnClickListener(view -> pref.performClick(position));

        break;
      case Preference.NORMAL:
        PreferenceViewHolder pHolder = (PreferenceViewHolder) holder;
        pHolder.itemIcon.setImageResource(pref.getIcon());
        pHolder.itemText.setText(pref.getTitle());
        pHolder.itemTextSecondary.setText(pref.getSecondaryText());
        pHolder.item.setOnClickListener(view -> pref.performClick(position));

        break;
      case Preference.SWITCH:
        SwitchPreferenceViewHolder sHolder = (SwitchPreferenceViewHolder) holder;
        sHolder.itemIcon.setImageResource(pref.getIcon());
        sHolder.itemText.setText(pref.getTitle());
        sHolder.itemTextSecondary.setText(pref.getSecondaryText());
        sHolder.item.setOnClickListener(view -> pref.performClick(position));

        break;
    }
  }

  @Override
  public int getItemCount() {
    return preferences.size();
  }

  public Preference get(int position) {
    return this.preferences.get(position);
  }

  public ArrayList<Preference> get() {
    return this.preferences;
  }

  public void add(Preference pref) {
    this.preferences.add(pref);
    notifyItemInserted(preferences.size() - 1);
  }

  public void add(ArrayList<Preference> preferences) {
    this.preferences = preferences;
    notifyDataSetChanged();
  }
}
