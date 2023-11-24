package org.example;

import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class ReadingThread extends Thread {
    private String message;

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            message = "msg " + scanner.nextLine() + "\n";
        }
    }

    public String getMessage() {
        String m = message;

        message = null;

        return  m;
    }
}
