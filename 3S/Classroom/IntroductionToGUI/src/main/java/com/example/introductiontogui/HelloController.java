package com.example.introductiontogui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis())));
    }
}