package com.example.agario.frontend.game.entities;

import com.example.agario.frontend.game.helpers.Vector2D;
import javafx.scene.paint.Color;

import java.util.Set;

public class Player extends Entity{

    public Player(Vector2D location, double radius, int id) {
        super(location, radius, id);
    }

    public Player(int id) {
        super(id);

        circle.setFill(Color.BLUE);
    }

    @Override
    public boolean doLogic(Set<String> input) {
        return move(input);
    }

    private boolean move(Set<String> input) {
        double v = 1.4 * 5;
        boolean isMoved = false;
        if(input.contains("W")) {
            location.setY(location.getY() - v);
            isMoved = true;
        }

        if(input.contains("S")) {
            location.setY(location.getY() + v);
            isMoved = true;
        }

        if(input.contains("D")) {
            location.setX(location.getX() + v);
            isMoved = true;
        }

        if(input.contains("A")) {
            location.setX(location.getX() - v);
            isMoved = true;
        }
        return isMoved;
    }
}
