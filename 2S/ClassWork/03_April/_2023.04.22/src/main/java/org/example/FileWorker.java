package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileWorker {
    public FileWorker() {}

    public void copyFile(String from, String to) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(from));
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(to));

            Byte b = dataInputStream.readByte();
            while(b != null) {
                dataOutputStream.writeByte(b);
                b = dataInputStream.readByte();
            }

            dataOutputStream.close();
        } catch (IOException e) {}
    }

    private int countOfBits(int s_num) {
        int two = 2;
        for(int i = 0; i < 10; i++) {
            if (two - 1 >= s_num) return i + 1;

            two *= 2;
        }
        return 10;
    }

    public void compressText(String from, String to) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(from));
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(to));

            Map<Character, Byte> map = new HashMap<>();
            Character b = dataInputStream.readChar();
            String buffer = "";
            int code = 0;
            while(b != null) {
                map.put(b, (byte) code);
                buffer += b;
                b = dataInputStream.readChar();
                code ++;
            }
            int bitsCount = countOfBits(code - 1);

            ByteWorker bw = new ByteWorker();

            for(int i = 0; i < buffer.length(); i++) {
                bw.add(map.get(buffer.charAt(i)), bitsCount);
            }

            List<Byte> bytes = bw.getList();

            for(int i = 0; i < bytes.size(); i++) {
                dataOutputStream.writeByte(bytes.get(i));
            }

            dataOutputStream.close();
        } catch (IOException e) {}
    }

    public void downloadFile(String imageUrl, String to) {
        try {
            URL url = new URL(imageUrl);
            DataInputStream in = new DataInputStream(url.openStream());
            DataOutputStream out = new DataOutputStream(new FileOutputStream(to));


            int i = in.readByte();
            while(i != -1) {
                out.writeByte(i);
                i = in.read();
            }
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void downloadPage(String pageURL, String to) {
        try {
            URL url = new URL(pageURL);
            DataInputStream in = new DataInputStream(url.openStream());
            DataOutputStream out = new DataOutputStream(new FileOutputStream(to));


            int i = in.readByte();
            while(i != -1) {
                out.writeByte(i);
                i = in.read();
            }
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void downloadAllPhotos(String pageURL, String pathAndFileName) {
        ...
    }
}
