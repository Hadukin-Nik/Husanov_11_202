package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        MessagesDB mDB = new MessagesDB();
        ServerSocket myserverSocket = new ServerSocket(4004);

        int i = 0;
        // getting client request
        while (true)
        // running infinite loop
        {
            Socket mynewSocket = null;

            try
            {
                mynewSocket = myserverSocket.accept();

                System.out.println("A new connection identified : " + mynewSocket);

                in = new BufferedReader(new InputStreamReader(mynewSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(mynewSocket.getOutputStream()));

                System.out.println("Thread assigned");

                (new Connection(in, out, myserverSocket, mDB, i)).start();

                mDB.addANewUser();

                i++;
            }
            catch (Exception e){
                mynewSocket.close();
                e.printStackTrace();
            }
        }
    }
}
