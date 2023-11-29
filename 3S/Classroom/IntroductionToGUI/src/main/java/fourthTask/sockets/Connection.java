package fourthTask.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;

public class Connection extends Thread {
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    private ServerSocket serverSocket;

    private final MessagesDB mDB;
    private int userId;

    public Connection(BufferedReader br, BufferedWriter bw, ServerSocket sv, MessagesDB mDB, int userId) {
        bufferedWriter = bw;
        bufferedReader = br;

        serverSocket = sv;
        this.mDB = mDB;

        this.userId = userId;
    }

    @Override
    public void run() {
        while (true) {
            String message;

            try {
                message = bufferedReader.readLine();
                if(message.equals("msg exit")) {
                    break;
                }

                if(message.startsWith("msg ")) {
                    String messageBuf = message.substring(4);

                    synchronized (mDB) {
                        mDB.addNewMessage(">>" + userId + ": " + messageBuf);
                    }
                }

                if(message.equals("list")){
                    String sendingPack = mDB.getLastMessages(userId);
                    synchronized (mDB) {
                        if(sendingPack.length() >= 1)
                        bufferedWriter.write(sendingPack + "\n");
                    }

                    bufferedWriter.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
