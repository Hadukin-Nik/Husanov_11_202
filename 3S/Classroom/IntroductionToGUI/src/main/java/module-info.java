module secondTask {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens secondTask to javafx.fxml;
    exports secondTask;
}

