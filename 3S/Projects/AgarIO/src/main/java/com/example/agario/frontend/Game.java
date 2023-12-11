package com.example.agario.frontend;

import com.example.agario.frontend.game.Entity;
import com.example.agario.frontend.game.helpers.Vector2D;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private Scene scene;
    private Entity circle;

    private Set<String> input;

    public Game() {
        Pane gameBox = new Pane();

        circle = new Entity(new Vector2D(100, 100), 10);

        gameBox.getChildren().add(circle.getBody());

        scene = new Scene(gameBox, 1000, 1000);

        input = new HashSet<>();

        scene.setOnKeyPressed(event -> {
            String keyInput = event.getCode().toString();
            input.add(keyInput);
        });

        scene.setOnKeyReleased(event -> {
            String keyInput = event.getCode().toString();
            input.remove(keyInput);
        });
    }

    public void fixedUpdate(long deltaTime) {
        circle.fixedUpdate(input);
    }

    public void render() {
        circle.render();
    }
    public Scene getScene() {
        return scene;
    }
}
