package com.example.agario.frontend;

import com.example.agario.frontend.serverCommunication.ClientBuffer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Client extends Application {
    private long lastUpdate;
    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(150, 150, 10);

        Group group = new Group(circle);

        lastUpdate = -1;
        long updateRate = 120;

        Game game = new Game();

        new AnimationTimer() {
            public void handle(long now) {
                long deltaTime = (now - lastUpdate);

                if(deltaTime >= 1000 / updateRate) {
                    game.update(deltaTime);
                    lastUpdate = now;
                }
            }
        };

        Scene scene = new Scene(group, 480, 360);
        stage.setTitle("Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /*
        ClientBuffer clientBuffer = new ClientBuffer();
        clientBuffer.start();*/

        launch();
    }
}