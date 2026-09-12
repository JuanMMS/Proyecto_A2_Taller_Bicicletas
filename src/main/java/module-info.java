module org.example.proyecto_a2_taller_bicicletas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens app to javafx.fxml;
    exports app;

    opens viewController to javafx.fxml;
    exports viewController;

    opens model to javafx.fxml;
    exports model;

    opens controller to javafx.fxml;
    exports controller;
}