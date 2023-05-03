package org.example.linkWorkers.medium;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImageThread extends Thread{
    private ImageProduct product;

    public DownloadImageThread (ImageProduct product) {
        this.product = product;
    }

    @Override
    public void run() {
        synchronized (product) {
            while(!product.isDone()) {
                while(!product.isReady()) {
                    try {
                        wait(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                ImageData imageData = product.getProduct();

                try {
                    URL url = null;
                    url = new URL(imageData.getUrl());

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
                    FileOutputStream fs = new FileOutputStream(imageData.getImageReadyPlace());

                    fs.write(b);
                    fs.close();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                product.notify();
            }
        }
    }
}
