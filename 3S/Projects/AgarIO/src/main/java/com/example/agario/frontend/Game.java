package com.example.agario.frontend;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Game {
    private Scene scene;
    private Circle e;

    public Game() {
        Pane gameBox = new Pane();

        e = new Circle(100, 100, 10);
        gameBox.getChildren().add(e);

        scene = new Scene(gameBox, 1000, 1000);
    }
    public void update(long dTime){
        double v = dTime * 1.0 / 100000000;
        e.setCenterX(e.getCenterX() + v);
        e.setCenterY(e.getCenterY() + v);
    }

    public Scene getScene() {
        return scene;
    }
}
