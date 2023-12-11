package com.example.agario.frontend.game;

import com.example.agario.frontend.game.helpers.Vector2D;
import javafx.scene.shape.Circle;

import java.util.Set;

public class Entity {
    private Circle circle;
    private Vector2D location;
    private double radius;

    public Entity() {
        circle = new Circle();
        location = new Vector2D();
        radius = 10;
    }

    public Entity(Vector2D location) {
        circle = new Circle();
        this.location = location;
        radius = 10;
    }

    public Entity(Vector2D location, double radius) {
        this(location);
        this.radius = radius;
    }

    public void fixedUpdate(Set<String> input) {
        move(input);
    }
    public void render() {
        draw();
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


    private void draw() {
        circle.setCenterX(location.getX());
        circle.setCenterY(location.getY());

        circle.setRadius(radius);
    }

    public Circle getBody() {
        return circle;
    }
}
