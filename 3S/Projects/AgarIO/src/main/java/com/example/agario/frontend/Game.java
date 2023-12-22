package com.example.agario.frontend;

import com.example.agario.frontend.game.entities.Entity;
import com.example.agario.frontend.game.entities.Player;
import com.example.agario.frontend.serverCommunication.ClientAPI;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private final Scene scene;

    private ClientAPI clientAPI;

    private final Pane gameBox;

    private Set<String> input;

    private List<Entity> entities;

    private Player player;
    private int count = 0;
    public Game() {
        entities = new ArrayList<>();
        gameBox = new Pane();

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

    public void start(ClientAPI clientAPI) {
        this.clientAPI = clientAPI;

        player = new Player(this.clientAPI.getPlayerId());
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public void fixedUpdate(long deltaTime) {
        if(entities.isEmpty()) return;
        if(!entities.get(player.getId()).isDead()) {
            player.fixedUpdate(input);
            clientAPI.setPosition(player.getLocation());
        } else {
            //Close application?
        }
    }

    public void render() {
        setEntities(clientAPI.getEntities());

        gameBox.getChildren().removeAll();
        for(Entity i : entities) {
            if(!i.isDead()) {
                gameBox.getChildren().add(i.getBody());
                i.render();
            }
        }
    }
    public Scene getScene() {
        return scene;
    }
}
