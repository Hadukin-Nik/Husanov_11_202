module com.example.agario.frontend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.agario.frontend to javafx.fxml;
    exports com.example.agario.frontend;
    exports com.example.agario.frontend.serverCommunication;
}