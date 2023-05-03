package org.example.linkWorkers;

import java.util.LinkedList;
import java.util.Queue;

public class LinksForThreadQueue {
    private Queue<ImageProduct> images;

    private int countOfFindersInWork;

    public LinksForThreadQueue(int countOfFindersInWork) {
        images = new LinkedList<>();

        this.countOfFindersInWork = countOfFindersInWork;
    }

    public boolean isEmpty() {
        return images.isEmpty();
    }

    public void add(ImageProduct imageURL) {
        images.add(imageURL);
    }

    public void deleteOne() {
        countOfFindersInWork--;
    }

    public ImageProduct get() {
        return images.poll();
    }

    public int getCountOfFindersInWork() {
        return countOfFindersInWork;
    }
}
