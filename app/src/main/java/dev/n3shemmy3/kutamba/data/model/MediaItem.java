package dev.n3shemmy3.kutamba.data.model;

public class MediaItem extends BaseModel {
    /*
    {
        "id": "string",
            "title": "string",
            "image": "string",
            "url": "string",
            "genres": [ "string" ]
    }
    */
    private String id;
    private String title;
    private String image;
    private String url;
    private String[] genres;

    public MediaItem() {
    }

    public MediaItem(String title) {
        this.title = title;
    }

    public MediaItem(String id, String title, String image, String url, String[] genres) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.url = url;
        this.genres = genres;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }
}
