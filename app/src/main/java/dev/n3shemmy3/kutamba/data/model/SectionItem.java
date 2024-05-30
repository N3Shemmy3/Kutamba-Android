package dev.n3shemmy3.kutamba.data.model;

import java.util.ArrayList;
import java.util.UUID;

public class SectionItem extends BaseModel {
    private String id = UUID.randomUUID().toString();
    private String title;
    private ArrayList<MediaItem> items;


    public SectionItem(String title, ArrayList<MediaItem> items) {
        this.title = title;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<MediaItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MediaItem> items) {
        this.items = items;
    }
}
