package com.example.agario.backend;

import com.example.agario.frontend.game.entities.Entity;
import com.example.agario.frontend.game.helpers.Vector2D;
import com.example.agario.protocol.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;

public class Connection extends Thread {
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    private ServerSocket serverSocket;

    private int userId;

    private Room room;

    private Entity entity;
    private int frame;

    public Connection(BufferedReader br, BufferedWriter bw, ServerSocket sv, int userId) {
        bufferedWriter = bw;
        bufferedReader = br;

        frame = 0;

        serverSocket = sv;

        this.userId = userId;
    }


    @Override
    public void run() {
        while (true) {
            String message;

            try {
                message = bufferedReader.readLine();

                System.out.println("got message: " + message);

                if(message.equals(Constants.regNew)) {
                    entity = new Entity(new Vector2D(100, 100), 10, userId);
                    bufferedWriter.write(String.format("%d",
                            entity.getId()) + "\n");

                    room.tryToAddEntity(entity);
                } else if (message.equals(Constants.getState)) {
                    bufferedWriter.write(room.getAllData() + "\n");
                } else if (message.startsWith(Constants.setPosPrefix)) {
                    String[] buf = message.split(" ");

                    room.setEntity(userId, new Vector2D(Double.parseDouble(buf[1]), Double.parseDouble(buf[2])));

                }

                bufferedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
