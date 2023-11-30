package com.example.agario.frontend.serverCommunication;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadingThread extends Thread{

    private final BufferedReader bufferedReader;


    public ReadingThread(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }


    @Override
    public void run() {
        while (true) {
            String newMessage;
            try {
                newMessage = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
