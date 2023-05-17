package org.example.firstTask;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Factory {
    private static String copiedFile;
    public Factory() {}
    public File downloadByLink(String link, String address) {
        StringBuilder a = new StringBuilder();

        File file = new File(address);
        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            URL url = new URL(link);
            DataInputStream in = new DataInputStream(url.openStream());

            int i = (char) in.readByte();

            while(i != -1) {
                i = in.read();

                a.append((char) i);
            }

            in.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            dos.writeBytes(a.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public String getCopiedFile() {
        return copiedFile;
    }

    public void setCopiedFile(String copiedFile) {

    }
}
