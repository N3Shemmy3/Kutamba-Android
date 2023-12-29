package dev.n3shemmy3.kutamba.model;

public class Episode {

  private String id;
  private String url;
  private int number;

  public Episode(String id, String url, int number) {
    this.id = id;
    this.url = url;
    this.number = number;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getNumber() {
    return this.number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
