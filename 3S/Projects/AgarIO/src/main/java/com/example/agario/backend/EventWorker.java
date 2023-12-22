package com.example.agario.backend;

import com.example.agario.frontend.game.entities.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class EventWorker{

    public void checkCollisions(Room room) {
        List<Pair<Entity, Entity>> collisions = new ArrayList<>();
        List<Entity> entities = room.getEntities();

        for(int i = 0; i < entities.size() - 1; i++) {
            for(int j = 0; j < entities.size(); j++) {
                if(entities.get(i).overloop(entities.get(j))) {
                    collisions.add(new Pair<>(entities.get(i), entities.get(j)));
                }
            }
        }

        if(collisions.size() > 0) {
            room.processCollisions(collisions);
        }
    }

}
