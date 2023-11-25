package thirdTask;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SimpleGameController {

    //onAction, id: onAction
    private int enemy = 100;

    @FXML private Label enemyHP;
    @FXML private TextField textField;
    @FXML private Slider slider;

    private IntegerProperty damageBind;

    @FXML
    public void initialize() {
        damageBind = new SimpleIntegerProperty();

        textField.textProperty().bind(damageBind.asString());
        slider.valueProperty().bindBidirectional(damageBind);
    }
    @FXML
    protected void onAction() {
        enemy -= slider.getValue();
        enemyHP.setText(String.valueOf(enemy));
    }
}
