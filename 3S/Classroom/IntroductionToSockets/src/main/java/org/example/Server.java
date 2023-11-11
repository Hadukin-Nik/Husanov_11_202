package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
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

                    Scanner sc = new Scanner(System.in);

                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    boolean isDone = true;
                    while(isDone) {
                        String word = in.readLine();
                        System.out.println("He is saying + \n" + word);
                        if(word.equals("exit")) {
                            isDone = false;
                            break;
                        }
                        System.out.println("I am saying \n");
                        String message = sc.nextLine();
                        out.write(message + "\n");
                        out.flush();

                        if(message.equals("exit")) {
                            break;
                        }

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