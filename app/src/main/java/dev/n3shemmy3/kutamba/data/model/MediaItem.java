package dev.n3shemmy3.kutamba.data.model;

public class MediaItem extends BaseModel {
    private String title;

    public MediaItem() {
    }


    public MediaItem(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
