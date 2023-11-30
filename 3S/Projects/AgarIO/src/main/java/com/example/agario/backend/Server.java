package com.example.agario.backend;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        DataBase dataBase = new DataBase();
        ServerSocket server = new ServerSocket(4004);

        int connectionsCount = 0;
        // getting client request
        while (true)
        // running infinite loop
        {
            Socket socket = null;

            try
            {
                socket = server.accept();

                System.out.println("A new connection identified : " + socket);

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                System.out.println("Thread assigned");

                
                (new Connection(in, out, server, dataBase, connectionsCount)).start();

                connectionsCount++;
            }
            catch (Exception e){
                socket.close();
                e.printStackTrace();
            }
        }
    }
}
