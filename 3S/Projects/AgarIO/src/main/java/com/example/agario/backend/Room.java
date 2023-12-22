package com.example.agario.backend;

import com.example.agario.frontend.game.entities.Entity;
import com.example.agario.frontend.game.helpers.Vector2D;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private EventWorker eventWorker;

    private List<Connection> connections;
    private List<Entity> entities;

    private int maxCapacity;


    public Room(int maxCapacity) {
        connections = new ArrayList<>();
        entities = new ArrayList<>();
        eventWorker = new EventWorker();
        this.maxCapacity = maxCapacity;
    }

    public synchronized void tryToAddEntity(Entity entity) {

        if(entity.getId() != entities.size()) {
            throw new RuntimeException("Wrong entity ID");
        }
        entities.add(entity);
    }

    public synchronized boolean tryToAddConnection(Connection newConnection) {
        if(connections.size() < maxCapacity) {
            connections.add(newConnection);
            return true;
        } else {
            return false;
        }
    }

    public synchronized void createFoodOnMap(int count) {
        Random random = new Random();
        int created = 0;
        while(created < count) {
            Vector2D location = new Vector2D(100 + random.nextDouble(800), 100 + random.nextDouble(800));

            entities.add(new Entity(location, 7.5, created));
            created ++;
        }
    }

    public synchronized String getAllData() {
        List<Pair<Entity, Entity>> pairs = eventWorker.checkCollisions(this);

        for(int i = 0; i < pairs.size(); i++) {
            Entity first = entities.get(pairs.get(i).getKey().getId());
            Entity second = entities.get(pairs.get(i).getValue().getId());

            first.addRadius(second.getRadius());
            second.setRadius(0);
            second.setDead(true);
        }

        StringBuilder sb = new StringBuilder();

        for(var i : entities) {
            sb.append(String.format("%d %.2f %.2f %.2f %d ",
                    i.getId(),
                    i.getLocation().getX(),
                    i.getLocation().getY(),
                    i.getRadius(),
                    i.isDead() ? 1 : 0
                    ));
        }

        return sb.toString();
    }

    public synchronized List<Entity> getEntities() {
        return entities;
    }

    public synchronized void setEntity(int userId, Vector2D vector2D) {
        entities.get(userId).setLocation(vector2D);
    }
}
