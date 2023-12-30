package dev.n3shemmy3.kutamba.model;

import androidx.annotation.StringRes;

public class Preference {

  public static final int CATEGORY = 0;
  public static final int NORMAL = 1;
  public static final int SWITCH = 2;

  private int id;
  private int icon;
  private int title;
  private int secondaryText;
  private int type;
  private OnClickListener onClickListener;

  public interface OnClickListener {
    void onClick(Preference preference, int position);
  }

  public Preference(
      int id, int icon, int title, int secondaryText, int type, OnClickListener onClickListener) {
    this.id = id;
    this.icon = icon;
    this.title = title;
    this.secondaryText = secondaryText;
    this.type = type;
    this.onClickListener = onClickListener;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIcon() {
    return this.icon;
  }

  public void setIcon(int icon) {
    this.icon = icon;
  }

  public int getTitle() {
    return this.title;
  }

  public void setTitle(int title) {
    this.title = title;
  }

  public int getSecondaryText() {
    return this.secondaryText;
  }

  public void setSecondaryText(int secondaryText) {
    this.secondaryText = secondaryText;
  }

  public int getType() {
    return this.type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public void performClick(int position) {
    if (onClickListener != null) {
      onClickListener.onClick(this, position);
    }
  }
}
