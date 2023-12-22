package com.example.agario.frontend;

import com.example.agario.frontend.game.entities.Entity;
import com.example.agario.frontend.game.entities.Player;
import com.example.agario.frontend.serverCommunication.ClientAPI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private final Scene scene;

    private ClientAPI clientAPI;

    private final Pane gameBox;

    private Set<String> input;
    private Set<Integer> rendered;

    private List<Entity> entities;

    private Player player;
    private int count = 0;
    public Game() {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("GameWindow.fxml"));

        entities = new ArrayList<>();
        try {
            gameBox = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rendered = new HashSet<>();

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
        Entity selfP = entities.get(player.getId());
        if(!selfP.isDead()) {
            selfP.setLocation(player.getLocation());

            player.fixedUpdate(input);
            clientAPI.setPosition(player.getLocation());
        } else {
            selfP.setRadius(0);
        }
    }

    public void render() {
        if(clientAPI == null) return;
        List<Entity> clientAPIEntities = clientAPI.getEntities();

        for(int i = 0; i < clientAPIEntities.size(); i++) {
            if(i < entities.size()) {
                Entity entity = entities.get(i);
                Entity entity1 = clientAPIEntities.get(i);

                entity.setRadius(entity1.getRadius());
                entity.setLocation(entity1.getLocation());
            } else {
                entities.add(clientAPIEntities.get(i));
            }
        }

        for(Entity i : entities) {
            if(!rendered.contains(i.getId())) {
                gameBox.getChildren().add(i.getBody());
                rendered.add(i.getId());
            }

            if(!i.isDead()) {
                i.render();
            }
        }
    }
    public Scene getScene() {
        return scene;
    }
}
