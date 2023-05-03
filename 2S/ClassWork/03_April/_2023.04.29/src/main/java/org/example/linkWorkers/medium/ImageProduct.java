package org.example.linkWorkers.medium;

public class ImageProduct {
    private boolean used, ready;

    private boolean done;

    private ImageData product;
    public ImageProduct() {

    }

    public boolean isReady() {
        return ready;
    }

    public boolean isUsed() {
        return used;
    }

    public ImageData getProduct() {
        used = true;
        ready = false;
        return product;
    }

    public void setProduct(ImageData product) {
        this.product = product;
        ready = true;
        used = false;
    }

    public void setDone() {
        this.done = true;
    }

    public boolean isDone() {
        return done;
    }
}
