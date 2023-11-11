package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
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
                    boolean isDone = true;
                    while(isDone) {
                        String word = in.readLine();

                        if(word.equals("exit")) {
                            isDone = false;
                            break;
                        }

                        int number = -1;

                        boolean isNumber = Pattern.matches("[0-9]+", word);
                        if(isNumber) {
                            Random rand = new Random();

                            number = rand.nextInt(Integer.parseInt(word));
                            out.write("checked!"+ "\n");
                        } else {
                            out.write("Not a number" + "\n");

                            continue;
                        }

                        out.flush();
                        System.out.println("In game!");
                        while (isDone) {
                            word = in.readLine();
                            if(word.equals("exit")) {
                                isDone = false;
                                break;
                            }
                            System.out.println("Next turn!");

                            isNumber = Pattern.matches("[0-9]+", word);
                            if(isNumber) {
                                System.out.println("We are on checking!");
                                int user_number = Integer.parseInt(word);
                                if(user_number < number){
                                    out.write('<' + "\n");
                                } else if (user_number > number) {
                                    out.write('>' + "\n");
                                } else {
                                    out.write("You are right!" + "\n");
                                    System.out.println("end of this party!");

                                    out.flush();
                                    break;
                                }
                            } else {
                                out.write("Not a number" + "\n");
                            }
                            System.out.println("End turn!");

                            out.flush();
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