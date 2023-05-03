package org.example.linkWorkers.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderURLsThread extends Thread{
    private ImageProduct product;
    private String data, pattern, downloadTo, typeOfPhoto;
    public FinderURLsThread(String data, String pattern, String downloadTo, String typeOfPhoto) {
        this.product = new ImageProduct();

        this.data = data;
        this.pattern = pattern;

        this.downloadTo = downloadTo;
        this.typeOfPhoto = typeOfPhoto;
    }

    public void run() {
        Pattern patternPhoto = Pattern.compile(pattern);
        Matcher matcherPhoto = patternPhoto.matcher(data);
        DownloadImageThread dw = new DownloadImageThread(product);

        synchronized (product) {
            int i = 0;

            while(matcherPhoto.find()) {
                while(!product.isUsed()) {
                    try {
                        product.wait(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                product.setProduct(new ImageData(data.substring(matcherPhoto.start(), matcherPhoto.end()), downloadTo + "photo" + (i < 10 ? "0" + i : i) + typeOfPhoto));
                i++;
                product.notify();
            }

            product.setDone();
        }
    }
}
