package org.example.linkWorkers.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderURLsThread extends Thread{
    private String data, pattern, downloadTo, typeOfPhoto;
    public FinderURLsThread(String data, String pattern, String downloadTo, String typeOfPhoto) {
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
            DownloadImageThread dw = new DownloadImageThread(data.substring(matcherPhoto.start(), matcherPhoto.end()), downloadTo + "photo" + (i < 10 ? "0" + i : i) + typeOfPhoto);
            dw.start();
            try {
                dw.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
