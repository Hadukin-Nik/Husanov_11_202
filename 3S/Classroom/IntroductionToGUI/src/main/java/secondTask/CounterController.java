package secondTask;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CounterController {
    @FXML private Slider slider;
    @FXML private TextField textField;
    @FXML
    private Label counterText;

    @FXML
    protected void onKeyUp(KeyEvent e) {
        int length = ((TextArea) e.getSource()).getText().length();
        counterText.setText(String.valueOf(length));
    }
}
