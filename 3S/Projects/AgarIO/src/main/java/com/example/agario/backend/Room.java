package com.example.agario.backend;

import com.example.agario.frontend.game.entities.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private EventWorker eventWorker;

    private List<Connection> connections;
    private List<Entity> entities;

    private int maxCapacity;


    public Room(int maxCapacity) {
        connections = new ArrayList<>();
        entities = new ArrayList<>();
        eventWorker = new EventWorker(entities, this);
        this.maxCapacity = maxCapacity;
    }

    public void tryToAddEntity(Entity entity) {
        if(entity.getId() != entities.size()) {
            throw new RuntimeException("Wrong entity ID");
        }
        entities.add(entity);
        eventWorker.addToEntities(entity);
    }

    public boolean tryToAddConnection(Connection newConnection) {
        if(connections.size() < maxCapacity) {
            connections.add(newConnection);
            return true;
        } else {
            return false;
        }
    }

    public String getAllData() {
        StringBuilder sb = new StringBuilder();

        for(var i : entities) {
            if(!i.isDead())
            sb.append(String.format("%d %.2f %.2f %.2f",
                    i.getId(),
                    i.getLocation().getX(),
                    i.getLocation().getY(),
                    i.getRadius()));
        }

        sb.append("\n");

        return sb.toString();
    }

    public void sendCollisions(List<Pair<Entity, Entity>> pairs) {
        for(int i = 0; i < pairs.size(); i++) {
            Entity first = pairs.get(i).getKey();
            Entity second = pairs.get(i).getValue();

            first.addRadius(second.getRadius());
            second.setDead(true);
        }
    }
}
