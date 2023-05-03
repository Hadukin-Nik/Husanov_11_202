package org.example.linkWorkers.medium;

public class ImageData {
    private String url;
    private String imageReadyPlace;

    public ImageData(String url, String imageReadyPlace) {
        this.url = url;
        this.imageReadyPlace = imageReadyPlace;
    }

    public String getImageReadyPlace() {
        return imageReadyPlace;
    }

    public String getUrl() {
        return url;
    }
}
