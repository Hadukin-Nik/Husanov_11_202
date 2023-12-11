package com.example.agario.frontend.game;

import com.example.agario.frontend.game.helpers.Vector2D;
import javafx.scene.shape.Circle;

import java.util.Set;

public class Entity {
    protected Circle circle;
    protected Vector2D location;
    protected double radius;

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
    public void setLocation(Vector2D location) {
        this.location = location;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public void fixedUpdate(Set<String> input) {}
    public void render() {
        draw();
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
