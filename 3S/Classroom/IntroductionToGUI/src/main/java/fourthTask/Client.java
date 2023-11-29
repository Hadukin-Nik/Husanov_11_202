package fourthTask;

import fourthTask.sockets.ReadingThread;
import fourthTask.sockets.WritingThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import secondTask.SymbolCounter;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("chat-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Chat!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ClientBuffer clientBuffer = new ClientBuffer();
        clientBuffer.start();

        launch();
    }
}