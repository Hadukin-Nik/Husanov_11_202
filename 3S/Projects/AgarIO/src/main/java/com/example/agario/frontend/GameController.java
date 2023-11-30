package com.example.agario.frontend;

import com.example.agario.frontend.serverCommunication.ReadingThread;
import com.example.agario.frontend.serverCommunication.WritingThread;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GameController {
    private static ReadingThread readingThread;
    private static WritingThread writingThread;

    boolean isBind;
    @FXML
    public void initialize() {
        isBind = false;
    }
    public static void init() {
    }
    public static void WritingThread(WritingThread writingAddThread) {
        writingThread = writingAddThread;
    }


    public static void ReadingThread(ReadingThread readingAddThread) {
        readingThread = readingAddThread;
    }

    @FXML
    public void onAction() {
        if(!isBind) {
            isBind = true;
        }
    }
}
