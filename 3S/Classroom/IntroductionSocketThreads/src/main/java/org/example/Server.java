package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Server {
    private static BufferedReader in;
    private static BufferedWriter out;

    private static List<Connection> connectionList;


    public static void main(String[] args) throws IOException {
        connectionList = new ArrayList<>();
        connectionList.add(new Connection());

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

                out.write(UUID.randomUUID().toString() + '\n');
                out.flush();

                if(!connectionList.get(i).addTo(myserverSocket, out, in)) {
                    connectionList.get(i).start();

                    i ++;

                    connectionList.add(new Connection());
                    connectionList.get(i).addTo(myserverSocket, out, in);
                }

            }
            catch (Exception e){
                mynewSocket.close();
                e.printStackTrace();
            }
        }
    }
}
