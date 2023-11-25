package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            try {
                clientSocket = new Socket("localhost", 4004);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                ReadingThread readingThread = new ReadingThread();
                WritingThread writingThread = new WritingThread();

                readingThread.start();
                writingThread.start();

                while (true) {
                    System.out.println("Your message:");

                    String word = writingThread.getMessage();

                    out.write(word);
                    out.flush();

                    word = readingThread.getMessage();

                    out.write(word);
                    out.flush();

                    String ans;
                    ans = in.readLine();

                    System.out.println("He is saying:\n" + ans);
                }

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