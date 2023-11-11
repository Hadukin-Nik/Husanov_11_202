package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен!");

                clientSocket = server.accept();

                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    while(true) {
                        String word = in.readLine();

                        if(word.equals("exit")) break;


                        boolean isNumber = Pattern.matches("[0-9]+", word);
                        if(isNumber) {
                             int number = Integer.parseInt(word);

                            out.write(number * number + "\n");

                        } else {
                            out.write("Not a number" + "\n");

                        }
                        out.flush();
                    }
                    out.flush();

                } finally {
                    clientSocket.close();

                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}