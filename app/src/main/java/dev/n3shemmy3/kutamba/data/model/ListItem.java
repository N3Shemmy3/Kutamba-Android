package dev.n3shemmy3.kutamba.data.model;

import androidx.annotation.DrawableRes;

public class ListItem extends BaseModel {

    private String id;
    private int icon;
    private String title;
    private String secondary;
    private String tertiary;
    private int actionIcon;

    public ListItem() {
    }

    public ListItem(String id, @DrawableRes int icon, String title, String secondary, String tertiary, int actionIcon) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.secondary = secondary;
        this.tertiary = tertiary;
        this.actionIcon = actionIcon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DrawableRes
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }


    public String getTertiary() {
        return tertiary;
    }

    public void setTertiary(String tertiary) {
        this.tertiary = tertiary;
    }

    public int getActionIcon() {
        return actionIcon;
    }

    public void setActionIcon(int actionIcon) {
        this.actionIcon = actionIcon;
    }
}
