package org.example.linkWorkers.hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderURLsThread extends Thread{
    private LinksForThreadQueue product;
    private String data, pattern, downloadTo, typeOfPhoto;
    public FinderURLsThread(LinksForThreadQueue product, String data, String pattern, String downloadTo, String typeOfPhoto) {
        this.product = product;

        this.data = data;
        this.pattern = pattern;

        this.downloadTo = downloadTo;
        this.typeOfPhoto = typeOfPhoto;
    }

    public void run() {
        Pattern patternPhoto = Pattern.compile(pattern);
        Matcher matcherPhoto = patternPhoto.matcher(data);
        synchronized (product) {
            int i = 0;

            while(matcherPhoto.find()) {
                while(!product.isEmpty()) {
                    try {
                        product.wait(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                product.add(new ImageProduct(data.substring(matcherPhoto.start(), matcherPhoto.end()), downloadTo + "photo" + (i < 10 ? "0" + i : i) + typeOfPhoto));

                i++;
                product.notifyAll();
            }

            product.deleteOne();
            product.notifyAll();
        }
    }
}
