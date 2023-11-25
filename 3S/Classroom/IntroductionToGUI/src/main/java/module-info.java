module thirdTask {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens thirdTask to javafx.fxml;
    exports thirdTask;
}

