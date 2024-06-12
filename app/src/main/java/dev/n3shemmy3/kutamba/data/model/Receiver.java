package dev.n3shemmy3.kutamba.data.model;

import java.util.ArrayList;

public class Receiver extends BaseModel {
    private int currentPage;
    private boolean hasNextPage;
    private String message;
    private ArrayList<MediaItem> results;

    public Receiver() {
    }

    public Receiver(int currentPage, boolean hasNextPage, String message, ArrayList<MediaItem> results) {
        this.currentPage = currentPage;
        this.hasNextPage = hasNextPage;
        this.message = message;
        this.results = results;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<MediaItem> getResults() {
        return results;
    }

    public void setResults(ArrayList<MediaItem> results) {
        this.results = results;
    }
}
