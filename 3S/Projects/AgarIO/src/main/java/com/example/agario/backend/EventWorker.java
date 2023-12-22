package com.example.agario.backend;

import com.example.agario.frontend.game.entities.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class EventWorker{

    public List<Pair<Entity, Entity>> checkCollisions(Room room) {
        List<Pair<Entity, Entity>> collisions = new ArrayList<>();
        List<Entity> entities = room.getEntities();

        for(int i = 0; i < entities.size(); i++) {
            for(int j = 0; j < entities.size(); j++) {
                if(entities.get(i).isDead() || entities.get(j).isDead() || i == j) continue;
                if(entities.get(i).overloop(entities.get(j))) {
                    collisions.add(new Pair<>(entities.get(i), entities.get(j)));
                }
            }
        }

        return collisions;
    }

}
