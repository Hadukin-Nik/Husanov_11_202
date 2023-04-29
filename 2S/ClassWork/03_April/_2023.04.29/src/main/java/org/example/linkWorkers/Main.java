package org.example.linkWorkers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        FileWorker fw = new FileWorker();

        //fw.downloadFile("https://kpfu.ru/portal/docs/F_1567078037/Montazhnaya_oblast_1_100.jpg", "src/main/java/out.jpg");
        //fw.copyFile("src/main/java/image.png", "src/main/java/out.png");
        //fw.downloadPage("https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html","src/main/java/out.txt" );
        fw.downloadAllPhotos("https://waitbutwhy.com", "src/main/java/");
    }
}