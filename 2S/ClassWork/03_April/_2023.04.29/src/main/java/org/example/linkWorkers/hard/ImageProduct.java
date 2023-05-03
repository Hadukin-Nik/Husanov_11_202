package org.example.linkWorkers.hard;

public class ImageProduct {
    private String url;
    private String imageReadyPlace;

    public ImageProduct(String url, String imageReadyPlace) {
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
