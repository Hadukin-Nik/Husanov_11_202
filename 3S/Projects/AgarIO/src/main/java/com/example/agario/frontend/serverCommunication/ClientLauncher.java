package com.example.agario.frontend.serverCommunication;
import com.example.agario.frontend.Game;

import java.io.*;
import java.net.Socket;

public class ClientLauncher extends Thread{

    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;
    private ClientAPI clientAPI;
    private Game game;

    private String host;

    public ClientLauncher(String host, Game game) {
        this.game = game;

        this.host = host;
    }

    @Override
    public void run(){
        try {
            try {
                clientSocket = new Socket(host, 4004);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                clientAPI = new ClientAPI(out, in);

                clientAPI.start();

                game.start(clientAPI);

                System.out.println("Initializing process ended!");

                clientAPI.join();

                System.out.println("Game Launcher Closing");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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

    public ClientAPI getClientAPI() {
        return clientAPI;
    }
}
