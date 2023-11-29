package fourthTask.sockets;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadingThread extends Thread{

    private final BufferedReader bufferedReader;

    private StringProperty messages;

    public ReadingThread(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;

        messages = new SimpleStringProperty();
        messages.set("");
    }


    @Override
    public void run() {
        while (true) {
            String newMessage;
            try {
                newMessage = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String[] messagesBuf = newMessage.split("%");

            StringBuilder sb = new StringBuilder(messages.get());

            for(var i : messagesBuf) {
                sb.append(i + "\r\n");
            }

            messages.set(sb.toString());

        }
    }

    public StringProperty getMessages() {
        return messages;
    }
}
