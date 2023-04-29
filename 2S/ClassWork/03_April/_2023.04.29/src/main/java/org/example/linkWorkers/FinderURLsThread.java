package org.example.linkWorkers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderURLsThread extends Thread{
    LinksForThreadQueue product;
    String data, pattern, downloadTo, typeOfPhoto;
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

        int i = 0;

        while(matcherPhoto.find()) {
            synchronized (product) {
                while(!product.isEmpty()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                product.add(new ImageProduct(data.substring(matcherPhoto.start(), matcherPhoto.end()), downloadTo + "photo" + (i < 10 ? "0" + i : i) + typeOfPhoto));

                i++;

                product.notify();
            }
        }

        product.deleteOne();
    }
}
