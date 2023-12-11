package com.example.agario.frontend;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private long lastUpdate;
    @Override
    public void start(Stage stage) throws Exception {
        lastUpdate = 0;
        long updateRate = 120;

        Game game = new Game();

        new AnimationTimer() {
            public void handle(long now) {
                if(lastUpdate == 0) {
                    lastUpdate = now;
                }
                long deltaTime = (now - lastUpdate);

                game.update(deltaTime);
                lastUpdate = now;
            }
        }.start();

        stage.setTitle("Game!");
        stage.setScene(game.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        /*
        ClientBuffer clientBuffer = new ClientBuffer();
        clientBuffer.start();*/

        launch();
    }
}