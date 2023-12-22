package com.example.agario.frontend.game.entities;

import com.example.agario.frontend.game.helpers.EasyCalculator;
import com.example.agario.frontend.game.helpers.Vector2D;
import javafx.scene.shape.Circle;

import java.util.Set;

public class Entity {
    protected Circle circle;
    protected Vector2D location;
    protected double radius;

    protected int id;

    protected boolean isDead;

    public Entity() {
        circle = new Circle();
        location = new Vector2D();
        radius = 10;
        id = 0;
        isDead = false;
    }

    public Entity(Vector2D location, int id) {
        circle = new Circle();
        this.location = location;
        radius = 10;
        this.id = id;
        isDead = false;
    }

    public Entity(Vector2D location, double radius, int id) {
        this(location, id);
        this.radius = radius;
    }

    public Vector2D getLocation() {
        return location;
    }

    public void setLocation(Vector2D location) {
        this.location = location;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void addRadius(double radius) {
        this.radius = EasyCalculator.getRoot(radius  * radius + this.radius * this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public int getId() {
        return id;
    }


    public void fixedUpdate(Set<String> input) {
        doLogic(input);
    }

    public void doLogic(Set<String> input){}

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

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean overloop(Entity entity) {
        if(this.location.calculateDistSqr(entity.getLocation()) < (this.radius + entity.radius) * (this.radius + entity.radius)) {
            if(this.radius > entity.radius) {
                return true;
            }
        }
        return false;
    }
}
