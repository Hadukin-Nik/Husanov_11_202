package com.example.agario.frontend;

import com.example.agario.frontend.serverCommunication.ClientLauncher;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @FXML
    private TextField messageField;

    private long lastUpdate;
    private static Game game;
    @Override
    public void start(Stage stage) throws Exception {
        lastUpdate = 0;
        long updateRate = 60;

        game = new Game();

        new AnimationTimer() {
            public void handle(long now) {
                if(lastUpdate == 0) {
                    lastUpdate = now;
                }
                long deltaTime = (now - lastUpdate)/1000000;

                if(deltaTime >= 1000 / updateRate) {
                    game.fixedUpdate(now);

                    game.render();
                    lastUpdate = now;
                }
            }
        }.start();

        stage.setTitle("Game!");
        stage.setScene(game.getScene());
        stage.show();
    }

    @FXML
    public void onAction() {
        System.out.println(messageField.getText());

        ClientLauncher clientLauncher = new ClientLauncher(messageField.getText(), game);
        clientLauncher.start();
    }

    public static void main(String[] args) {
        launch();
    }
}