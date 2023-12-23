package com.example.agario.frontend.serverCommunication;

import com.example.agario.frontend.Game;
import com.example.agario.frontend.game.entities.Entity;
import com.example.agario.frontend.game.entities.Player;
import com.example.agario.frontend.game.helpers.Vector2D;
import com.example.agario.protocol.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClientAPI extends Thread{
    private final long maxTimeGetState = 5;
    private final BufferedWriter bufferedWriter;
    private final BufferedReader bufferedReader;
    private Game game;
    private final List<Entity> entities;

    private final Vector2D location;
    private long lastTimeRecord = 0;

    private int userId;

    private boolean sentUserId;

    private int counter;

    private boolean sentLocation;

    private LinkedList<Vector2D> lastPositions;

    private int duplicationCounter;

    public ClientAPI(BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        lastPositions = new LinkedList<>();
        location = new Vector2D();
        entities = new ArrayList<>();

        duplicationCounter = 0;

        this.bufferedWriter = bufferedWriter;
        this.bufferedReader = bufferedReader;

        sentUserId = false;
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
        userId = Integer.parseInt(ans);
        return Integer.parseInt(ans);
    }

    @Override
    public void run() {
        userId = regNew();
        int frame = 0;

        while(true) {
            if(game!=null && !sentUserId) {
                sentUserId = true;
                game.setPlayerId(userId);
            }
            if(System.currentTimeMillis() - lastTimeRecord > maxTimeGetState) {
                innerLoop();
            }
        }
    }

    private synchronized void innerLoop() {
        List<Entity> bufEntities = new ArrayList<>();
        lastTimeRecord = System.currentTimeMillis();
        try {
            bufferedWriter.write(Constants.getState + "\n");
            bufferedWriter.flush();

            String bufAns = bufferedReader.readLine();

            bufAns = bufAns.replaceAll(",", ".");

            String[] ans = bufAns.split(" ");

            for(int i = 0; i < ans.length; i += 5) {
                int idE = Integer.parseInt(ans[i]);

                Vector2D locE = new Vector2D(Double.parseDouble(ans[i + 1]), Double.parseDouble(ans[i + 2]));
                double radE = Double.parseDouble(ans[i + 3]);
                boolean isDead = Integer.parseInt(ans[i + 4]) == 1;

                Entity entity;

                if(userId != idE) {
                    entity = new Entity(idE);
                } else {
                    entity = new Player(idE);
                }

                entity.setLocation(locE);
                entity.setRadius(radE);
                entity.setDead(isDead);
                bufEntities.add(entity);
            }
            synchronized (entities) {
                entities.clear();
                entities.addAll(bufEntities);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            //System.out.println("Sending pos...");
            String s = Constants.setPosPrefix + String.format(" %.2f %.2f",
                    location.getX(),
                    location.getY()
            ).replaceAll(",", ".");

            //System.out.println(counter + " " + s);
            counter ++;


            bufferedWriter.write(s + "\n");
            bufferedWriter.flush();

            String pc = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized List<Entity> getEntities() {
        return entities;
    }

    public void setPosition(Vector2D location) {
        if(lastPositions.size() < 3) {
            lastPositions.add(location);
        } else if(!lastPositions.contains(location)) {
            this.location.setX(location.getX());
            this.location.setY(location.getY());

            //lastPositions.removeFirst();
            //lastPositions.add(location);
        } else {
            duplicationCounter++;
            //System.out.println("Duplication counter: " + duplicationCounter);
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
