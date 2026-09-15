package app;

import controller.TallerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Bicicleta;
import model.Taller;
import viewController.TallerViewController;
import viewController.VentanaPrincipalViewController;

import java.io.IOException;

public class App extends Application {

    //Crear el taller de la aplicacion
    public static Taller taller = new Taller("Taller Bicicletas UQ", "12345", "El bunker", 300);

    //Crear el controller
    private final TallerController tallerController = new TallerController(taller);

    Stage stage = new Stage();
    //Iniciar la aplicacion
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/consultas.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        TallerViewController tallerViewController = fxmlLoader.getController();
        tallerViewController.setTallerController(tallerController);
        tallerViewController.setApp(this);
        this.stage = stage;
        stage.setScene(scene);
        stage.setTitle("Consultas del taller");
        this.stage.show();
    }
    public void abrirVentanaPrincipal() throws IOException {

<<<<<<< Updated upstream
=======
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource(
                        "/assets/ventanaPrincipal.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        VentanaPrincipalViewController viewController =
                fxmlLoader.getController();

        viewController.setApp(this);

        this.stage.setScene(scene);
        this.stage.setTitle("Taller de Bicicletas");
        this.stage.show();
    }
    public void abrirVentanaOrdenServicio() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/crudOrdenServicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        OrdenServicioViewController viewController = fxmlLoader.getController();
        viewController.setOrdenServicioController(ordenServicioController);
        viewController.setApp(this);
        Stage ventana = new Stage();
        ventana.setScene(scene);
        ventana.setTitle("Gestión de Orden de Servicio");
        ventana.show();
    }

>>>>>>> Stashed changes
    public static void main(String[] args) {launch(args);}

}
