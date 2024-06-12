package dev.n3shemmy3.kutamba.data.model;

public class Scraper extends BaseModel {

    public static enum MediaType {
        Series,
        Movies,
    }

    private String media;
    private String provider;
    private String query;
    private MediaType type;
    private int page;

    public Scraper() {
    }

    public Scraper(String media, String provider, String query, MediaType type, int page) {
        this.media = media;
        this.provider = provider;
        this.query = query;
        this.type = type;
        this.page = page;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public MediaType getType() {
        return type;
    }

    public final void setType(MediaType type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
