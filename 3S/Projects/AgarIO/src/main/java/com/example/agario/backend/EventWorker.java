package com.example.agario.backend;

import com.example.agario.frontend.game.entities.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class EventWorker extends Thread{
    private List<Entity> entities;
    private List<Pair<Entity, Entity>> collisions;

    private Room room;

    public EventWorker(List<Entity> entities, Room room) {
        this.entities = entities;
        this.room = room;
    }

    @Override
    public void run() {
        collisions = new ArrayList<>();

        while(true) {
            for(int i = 0; i < entities.size() - 1; i++) {
                for(int j = 0; j < entities.size(); j++) {
                    if(entities.get(i).overloop(entities.get(j))) {
                        collisions.add(new Pair<>(entities.get(i), entities.get(j)));
                    }
                }
            }

            if(collisions.size() > 0) {
                room.sendCollisions(getCollisions());
            }
        }
    }

    public void addToEntities(Entity entity) {
        entities.add(entity);
    }

    public List<Pair<Entity, Entity>> getCollisions() {
        List<Pair<Entity, Entity>> result = collisions;

        collisions = new ArrayList<>();

        return result;
    }
}
