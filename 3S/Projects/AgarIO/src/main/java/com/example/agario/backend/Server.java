package com.example.agario.backend;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4004);

        int maxCapacity = 10;
        Room room = new Room(maxCapacity);

        int index = 0;

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

                Connection connection = new Connection(in, out, server, index);

                if(!room.tryToAddConnection(connection)) {
                    room = new Room(maxCapacity);
                    room.tryToAddConnection(connection);
                }

                connection.setRoom(room);
                connection.start();

                index++;
            }
            catch (Exception e){
                socket.close();
                e.printStackTrace();
            }
        }
    }
}
