package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

public class Connection extends Thread {
    private List<BufferedWriter> bfWriterList;
    private List<BufferedReader> bfReaderList;

    private List<ServerSocket> serverSockets;

    public boolean addTo(ServerSocket serverSocket, BufferedWriter bfW, BufferedReader bfR) {
        if (bfReaderList.size() < 2) {
            bfReaderList.add(bfR);
            bfWriterList.add(bfW);
            serverSockets.add(serverSocket);

            return true;
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            if (bfReaderList.size() < 2) {
                continue;
            }

            //turn of first
            String firstMessage;
            try {
                firstMessage = bfReaderList.get(0).readLine();

                if (firstMessage.contains("exit")) {
                    break;
                }

                bfWriterList.get(1).write(firstMessage + '\n');
                bfWriterList.get(1).flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //turn of second
            try {
                firstMessage = bfReaderList.get(1).readLine();

                if (firstMessage.contains("exit")) {
                    break;
                }

                bfWriterList.get(0).write(firstMessage + '\n');
                bfWriterList.get(0).flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        System.out.println("Клиент был закрыт...");
        try {
            serverSockets.get(0).close();
            serverSockets.get(1).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            bfWriterList.get(0).close();
            bfReaderList.get(0).close();

            bfWriterList.get(1).close();
            bfReaderList.get(1).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
