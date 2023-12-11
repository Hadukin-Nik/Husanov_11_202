package com.example.agario.game;

import com.example.agario.game.helpers.Vector2D;

public class Entity {
    private Vector2D location;
    private double radius;

    public Entity() {
        location = new Vector2D();
        radius = 1;
    }

    public Entity(Vector2D location) {
        this.location = location;
        radius = 1;
    }

    public Entity(Vector2D location, double radius) {
        this(location);
        this.radius = radius;
    }
    

    public Vector2D getLocation() {
        return location;
    }

    public void setLocation(Vector2D location) {
        this.location = location;
    }

    public void move(Vector2D addable) {
        this.location.add(addable);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void addRadius(double addable) {
        this.radius += radius;
    }

    public void subtractRadius(double subtrahend) {
        this.radius -= subtrahend;
    }

}
