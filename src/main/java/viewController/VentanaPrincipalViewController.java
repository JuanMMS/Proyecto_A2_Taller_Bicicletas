package viewController;

import app.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class VentanaPrincipalViewController {

    private App app;


    public void setApp(App app) {
        this.app = app;
    }


    @FXML
    private void onAbrirClientes() throws IOException {

        app.abrirVentanaCliente();
    }


    @FXML
    private void onAbrirMecanicos() throws IOException {

        app.abrirVentanaMecanico();
    }


    @FXML
    private void onAbrirBicicletas() throws IOException {

        app.abrirVentanaBicicleta();
    }


    @FXML
    private void onAbrirOrdenesServicio() throws IOException {

        app.abrirVentanaOrdenServicio();
    }


    @FXML
    private void onAbrirConsultas() throws IOException {

        app.abrirVentanaConsultas();
    }
}