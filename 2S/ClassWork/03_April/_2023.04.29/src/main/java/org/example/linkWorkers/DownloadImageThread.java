package org.example.linkWorkers;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImageThread extends Thread{
    private String downloadTo, imageUrl;
    public DownloadImageThread (String url, String dowloadTo) {
        this.imageUrl = url;
        this.downloadTo = dowloadTo;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(imageUrl);

            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] b = out.toByteArray();
            FileOutputStream fs = new FileOutputStream(downloadTo);

            fs.write(b);
            fs.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
