package dev.n3shemmy3.kutamba.data.model;

import java.util.List;

public class MediaItem extends BaseModel {

    private String title;
    private String url;
    private String image;
    private String releaseDate; // or null
    private String description; // or null
    private List<String> genres;
    private String type; // or null
    private String subOrDub;
    private String status;
    private String message;
    private String otherName; // or null
    private int totalEpisodes;
    private List<String> casts;
    private List<String> tags;
    private String production;
    private String duration;
    private List<Episode> episodes;

    public MediaItem() {
    }

    public MediaItem(String title) {
        this.title = title;
    }

    public MediaItem(String id, String title, String url, String image, String releaseDate, String description, List<String> genres, String type, String subOrDub, String status, String message, String otherName, int totalEpisodes, List<String> casts, List<String> tags, String production, String duration, List<Episode> episodes) {
        this.message = message;
        this.id = id;
        this.title = title;
        this.url = url;
        this.image = image;
        this.releaseDate = releaseDate;
        this.description = description;
        this.genres = genres;
        this.type = type;
        this.subOrDub = subOrDub;
        this.status = status;
        this.otherName = otherName;
        this.totalEpisodes = totalEpisodes;
        this.casts = casts;
        this.tags = tags;
        this.production = production;
        this.duration = duration;
        this.episodes = episodes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubOrDub() {
        return subOrDub;
    }

    public void setSubOrDub(String subOrDub) {
        this.subOrDub = subOrDub;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public List<String> getCasts() {
        return casts;
    }

    public void setCasts(List<String> casts) {
        this.casts = casts;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
