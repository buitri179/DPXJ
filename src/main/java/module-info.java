module org.example.demofx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens org.example.demofx2 to javafx.graphics, javafx.fxml;
    // permission error
    opens org.example.demofx2.controller to javafx.graphics, javafx.fxml;
    exports org.example.demofx2;
    exports org.example.demofx2.entity;
}