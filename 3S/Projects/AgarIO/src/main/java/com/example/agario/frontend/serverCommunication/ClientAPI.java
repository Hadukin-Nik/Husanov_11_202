package com.example.agario.frontend.serverCommunication;

import com.example.agario.frontend.game.entities.Entity;
import com.example.agario.frontend.game.helpers.Vector2D;
import com.example.agario.protocol.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientAPI extends Thread{
    private final long maxTime = 10;
    private final BufferedWriter bufferedWriter;
    private final BufferedReader bufferedReader;

    private List<Entity> entities;

    private Vector2D location;
    private long lastTimeRecord = 0;

    private int id;

    public ClientAPI(BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        entities = new ArrayList<>();
        this.bufferedWriter = bufferedWriter;
        this.bufferedReader = bufferedReader;
    }

    public int regNew() {
        String ans;
        try {
            bufferedWriter.write(Constants.regNew + "\n");
            bufferedWriter.flush();

            System.out.println("regNew");
            ans = bufferedReader.readLine();
            System.out.println(ans);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Integer.parseInt(ans);
    }

    @Override
    public void run() {
        id = regNew();

        while(true) {

            if(System.currentTimeMillis() - lastTimeRecord > maxTime) {
                List<Entity> bufEntities = new ArrayList<>();
                lastTimeRecord = System.currentTimeMillis();
                try {
                    bufferedWriter.write(Constants.getState + "\n");
                    bufferedWriter.flush();

                    String bufAns = bufferedReader.readLine();

                    bufAns = bufAns.replaceAll(",", ".");

                    String[] ans = bufAns.split(" ");

                    int lastId = -1;
                    for(int i = 0; i < ans.length; i += 4) {
                        int idE = Integer.parseInt(ans[i]);

                        Vector2D locE = new Vector2D(Double.parseDouble(ans[i + 1]), Double.parseDouble(ans[i + 2]));
                        double radE = Double.parseDouble(ans[i + 3]);

                        if(idE - lastId > 1) {
                            for(int j = lastId + 1; j < idE; j++) {
                                Entity entityBuf = new Entity();
                                entityBuf.setDead(true);
                                bufEntities.add(entityBuf);
                            }
                        }

                        Entity entity = new Entity();

                        entity.setLocation(locE);
                        entity.setRadius(radE);

                        bufEntities.add(entity);

                        lastId = idE;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                entities = bufEntities;
            }
        }
    }

    public synchronized List<Entity> getEntities() {
        return entities;
    }

    public synchronized void setPosition(Vector2D location) {
        this.location = location;
    }

    public synchronized int getPlayerId() {
        return id;
    }
}
