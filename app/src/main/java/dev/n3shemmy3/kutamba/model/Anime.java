package dev.n3shemmy3.kutamba.model;

import java.util.ArrayList;

public class Anime {
  
  private String id;
  private String image;
  private String title;
  private String otherName;
  private String description;
  private String releaseDate;
  private String url;
  private String subOrDub;
  private String type;
  private String status;
  private int totalEpisodes;
  private ArrayList<String> genres;
  private ArrayList<Episode> episodes;

  public Anime(
      String id,
      String image,
      String title,
      String otherName,
      String description,
      String releaseDate,
      String url,
      String subOrDub,
      String type) {
    this.id = id;
    this.image = image;
    this.title = title;
    this.otherName = otherName;
    this.description = description;
    this.releaseDate = releaseDate;
    this.url = url;
    this.subOrDub = subOrDub;
    this.type = type;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getOtherName() {
    return this.otherName;
  }

  public void setOtherName(String otherName) {
    this.otherName = otherName;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getReleaseDate() {
    return this.releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getSubOrDub() {
    return this.subOrDub;
  }

  public void setSubOrDub(String subOrDub) {
    this.subOrDub = subOrDub;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getTotalEpisodes() {
    return this.totalEpisodes;
  }

  public void setTotalEpisodes(int totalEpisodes) {
    this.totalEpisodes = totalEpisodes;
  }

  public ArrayList<String> getGenres() {
    return this.genres;
  }

  public void setGenres(ArrayList<String> genres) {
    this.genres = genres;
  }

  public ArrayList<Episode> getEpisodes() {
    return this.episodes;
  }

  public void setEpisodes(ArrayList<Episode> episodes) {
    this.episodes = episodes;
  }
}
