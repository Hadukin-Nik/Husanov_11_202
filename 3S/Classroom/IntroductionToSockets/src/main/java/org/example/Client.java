package org.example;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004); // этой строкой мы запрашиваем

                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                while(true) {
                    System.out.println("Please write a number!");
                    String word = reader.readLine();

                    if(word.equals("exit")) {
                        out.write(word + "\n");
                        break;
                    }

                    out.write(word + "\n");
                    out.flush();
                    String serverWord = in.readLine();
                    System.out.println(serverWord);

                    if(serverWord.equals("You are right!")) {
                        System.out.println("Please write a new bound!");
                    }
                    out.flush();
                }
                out.flush();

            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}