package org.example;

public class Main {
    public static void main(String[] args) {
        FileWorker fw = new FileWorker();

        //fw.copyFile("src/main/java/image.png", "src/main/java/out.png");
        fw.downloadPage("https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html","src/main/java/out.txt" );
    }
}