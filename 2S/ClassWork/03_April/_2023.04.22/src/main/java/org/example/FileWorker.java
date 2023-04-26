package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            FileOutputStream fs = new FileOutputStream(to);

            fs.write(b);

            fs.close();
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

            String regexpPNG =  "https?:\\/\\/([^\\s])*\\.png";
            String regexpJPEG = "https?:\\/\\/([^\\s])*\\.jpeg";
            String regexpJPG = "https?:\\/\\/([^\\s])*\\.jpg";

            downloadDataTypeOf(data, regexpJPG, path, ".jpg");
            downloadDataTypeOf(data, regexpPNG, path, ".png");
            downloadDataTypeOf(data, regexpJPEG, path, ".jpeg");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void downloadDataTypeOf(String data, String pattern, String downloadTo, String typeOfPhoto) {
        List<String> photoURLs = new ArrayList<>();

        Pattern patternPhoto = Pattern.compile(pattern);
        Matcher matcherPhoto = patternPhoto.matcher(data);

        while (matcherPhoto.find()) {
            photoURLs.add(data.substring(matcherPhoto.start(), matcherPhoto.end()));
        }

        int i = 0;
        for(String imgURL : photoURLs) {
            downloadFile(imgURL, downloadTo + "photo" + (i < 10 ? "0" + i : i) + typeOfPhoto);
            i++;
        }
    }
}
