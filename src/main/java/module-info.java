module org.example.proyecto_a2_taller_bicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyecto_a2_taller_bicicletas to javafx.fxml;
    exports org.example.proyecto_a2_taller_bicicletas;
}