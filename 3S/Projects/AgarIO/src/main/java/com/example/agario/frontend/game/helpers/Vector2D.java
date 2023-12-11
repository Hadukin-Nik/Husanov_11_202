package com.example.agario.frontend.game.helpers;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculateDistSqr(Vector2D another) {
        return ((another.x - x)*(another.x - x) + (another.y - y)*(another.y - y));
    }

    public double calculateDist(Vector2D another) {
        return EasyCalculator.getRoot(calculateDistSqr(another));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void add(Vector2D another) {
        x += another.x;
        y += another.y;
    }
}
