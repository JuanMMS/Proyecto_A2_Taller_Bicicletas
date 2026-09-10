module org.example.proyecto_a2_taller_bicicletas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.proyecto_a2_taller_bicicletas to javafx.fxml;
    exports org.example.proyecto_a2_taller_bicicletas;
}