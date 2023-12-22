package com.example.agario.frontend.game.entities;

import com.example.agario.frontend.game.helpers.Vector2D;

import java.util.Set;

public class Player extends Entity{
    public Player(Vector2D location, double radius, int id) {
        super(location, radius, id);
    }
    @Override
    public void doLogic(Set<String> input) {
        move(input);
    }

    private void move(Set<String> input) {
        double v = 1.4;

        if(input.contains("W")) {
            location.setY(location.getY() - v);
        }

        if(input.contains("S")) {
            location.setY(location.getY() + v);
        }

        if(input.contains("D")) {
            location.setX(location.getX() + v);
        }

        if(input.contains("A")) {
            location.setX(location.getX() - v);
        }
    }
}
