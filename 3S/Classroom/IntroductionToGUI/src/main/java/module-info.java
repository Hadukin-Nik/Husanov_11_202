module fourthTask {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens fourthTask to javafx.fxml;
    exports fourthTask;
}

