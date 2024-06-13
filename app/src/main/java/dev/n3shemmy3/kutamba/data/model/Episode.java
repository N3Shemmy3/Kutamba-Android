package dev.n3shemmy3.kutamba.data.model;

public class Episode extends BaseModel {
    private String url;
    private String title;
    private int number;
    private int season;

    public Episode(String id, String url, String title, int number, int season) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.number = number;
        this.season = season;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
