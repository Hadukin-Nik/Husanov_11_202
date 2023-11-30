package com.example.agario.frontend.serverCommunication;

import com.example.agario.frontend.GameController;

import java.io.*;
import java.net.Socket;

public class ClientBuffer extends Thread{

    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    @Override
    public void run(){
        try {
            try {
                clientSocket = new Socket("localhost", 4004);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                WritingThread writingThread = new WritingThread(out);
                ReadingThread readingThread = new ReadingThread(in);

                GameController.ReadingThread(readingThread);
                GameController.WritingThread(writingThread);

                writingThread.start();
                readingThread.start();

                GameController.init();
                System.out.println("Initializing process ended!");
                while(true){}

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
