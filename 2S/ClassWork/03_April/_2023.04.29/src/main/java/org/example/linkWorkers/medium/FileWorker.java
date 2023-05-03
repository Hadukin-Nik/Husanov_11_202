package org.example.linkWorkers.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FileWorker {
    public FileWorker() {}

    public void downloadAllPhotos(String pageURL, String path) {
        try {
            URL url = new URL(pageURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            //DataOutputStream out = new DataOutputStream(new FileOutputStream(to));
            StringBuilder dataBuf = new StringBuilder();

            String line;
            while ((line = in.readLine()) != null) {
                dataBuf.append(line);
            }
            in.close();


            String data = dataBuf.toString();

            String regexp = "https?:\\/\\/([^\\s & ^\\@ & ^\\*])*";

            String regexpPNG =  regexp + ".png";
            String regexpJPEG = regexp + ".jpeg";
            String regexpJPG = regexp + ".jpg";

            FinderURLsThread f1 = new FinderURLsThread(data, regexpJPEG, path, ".jpeg");
            FinderURLsThread f2 = new FinderURLsThread(data, regexpPNG, path, ".png");
            FinderURLsThread f3 = new FinderURLsThread(data, regexpJPG, path, ".jpg");

            f1.start();
            f2.start();
            f3.start();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
