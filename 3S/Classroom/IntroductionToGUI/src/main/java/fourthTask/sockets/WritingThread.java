package fourthTask.sockets;

import java.io.BufferedWriter;
import java.io.IOException;

public class WritingThread extends Thread{
    private final long maxTime = 1000;
    private final BufferedWriter bufferedWriter;
    private long lastTimeRecord = 0;

    public WritingThread(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void run() {
        while(true) {
            if(System.currentTimeMillis() - lastTimeRecord > maxTime) {
                lastTimeRecord = System.currentTimeMillis();

                try {
                    bufferedWriter.write("list" + "\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            bufferedWriter.write("msg " + message + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
