package com.example.agario.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;

public class Connection extends Thread {
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    private ServerSocket serverSocket;

    private final DataBase mDB;
    private int userId;

    public Connection(BufferedReader br, BufferedWriter bw, ServerSocket sv, DataBase mDB, int userId) {
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

                //we must add switch-case
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
