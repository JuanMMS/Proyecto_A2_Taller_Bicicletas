package app;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Mecanico;
import model.Taller;
import viewController.*;
import model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    //Crear el taller de la aplicacion
    public static Taller taller = new Taller("Taller Bicicletas UQ", "12345", "El bunker", 300);
    Mecanico mecanico1 = new Mecanico("Juan", "Mosq", "123");
    List<Mecanico> mecanicos = taller.getListMecanicos();
    //Crear los controller
    private final TallerController tallerController = new TallerController(taller);

    private final OrdenServicioController ordenServicioController = new OrdenServicioController(tallerController);

    private final ClienteController clienteController = new ClienteController(taller);

    private final MecanicoController mecanicoController = new MecanicoController(taller);

    private final BicicletaController bicicletaController = new BicicletaController(taller);


    Stage stage = new Stage();

    //Iniciar la aplicacion
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/ventanaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        VentanaPrincipalViewController ventanaPrincipalViewController = fxmlLoader.getController();
        ventanaPrincipalViewController.setApp(this);
        this.stage = stage;
        this.stage.setScene(scene);
        this.stage.setTitle("Bienvenido");
        this.stage.show();
    }

    public void abrirVentanaConsultas() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/consultas.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ConsultasViewController consultasViewController = fxmlLoader.getController();
        consultasViewController.setTallerController(tallerController);
        consultasViewController.setApp(this);
        stage.setScene(scene);
        stage.setTitle("Consultas del taller");
        stage.show();
    }

    public void abrirVentanaOrdenServicio() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/crudOrdenServicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        OrdenServicioViewController viewController = fxmlLoader.getController();
        viewController.setOrdenServicioController(ordenServicioController);
        viewController.setApp(this);
        stage.setScene(scene);
        stage.setTitle("Gestión de Orden de Servicio");
        stage.show();
    }

    public void abrirVentanaCliente() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/CrudCliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ClienteViewController clienteViewController = fxmlLoader.getController();
        clienteViewController.setClienteController(clienteController);
        clienteViewController.setApp(this);
        stage.setScene(scene);
        stage.setTitle("Gestión de clientes");
        stage.show();
    }

    public void abrirVentanaMecanico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/crudMecanico.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MecanicoViewController mecanicoViewController = fxmlLoader.getController();
        mecanicoViewController.setMecanicoController(mecanicoController);
        mecanicoViewController.setApp(this);
        stage.setScene(scene);
        stage.setTitle("Gestión de mecanicos");
        stage.show();
    }

    public void abrirVentanaBicicleta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assets/crudBicicletas.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        BicicletaViewController bicicletaViewController = fxmlLoader.getController();
        bicicletaViewController.setBicicletaController(bicicletaController);
        bicicletaViewController.setApp(this);
        stage.setScene(scene);
        stage.setTitle("Gestión de bicicletas");
        stage.show();
    }

    //Cambiar a la ventana principal
    public void abrirVentanaPrincipal() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/ventanaPrincipal.fxml"));
        Scene scene = new Scene(loader.load());
        VentanaPrincipalViewController ventanaPrincipalViewController = loader.getController();
        ventanaPrincipalViewController.setApp(this);
        stage.setScene(scene);
        stage.setTitle("Bienvenido");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    Cliente cl1 = new Cliente("Sebas", "1", "12", "Por ahi");
    Boolean si = taller.agregarCliente(cl1);
    Mecanico mc1 = new Mecanico("cami", "nova","1");
    boolean si2 = taller.agregarMecanico(mc1);
    Bicicleta bc1 = new Bicicleta("Audi","rojo","123","2000");
    boolean si3 = taller.agregarBicicleta(bc1);
}