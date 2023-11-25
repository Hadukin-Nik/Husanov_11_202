module com.example.introductiontogui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.introductiontogui to javafx.fxml;
    exports com.example.introductiontogui;
}