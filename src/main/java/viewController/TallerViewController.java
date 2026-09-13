package viewController;

import app.App;
import controller.TallerController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.OrdenServicio;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;

public class TallerViewController {

    private App app;

    private TallerController tallerController;


    // =========================
    // ELEMENTOS DEL FXML
    // =========================

    @FXML
    private TextField txtSerial;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private Button btnBuscarSerial;

    @FXML
    private Button btnBuscarFecha;

    @FXML
    private Button btnStock;

    @FXML
    private Label lblStock;


    // Tabla historial

    @FXML
    private TableView<OrdenServicio> tablaHistorial;

    @FXML
    private TableColumn<OrdenServicio, String> colIdHistorial;

    @FXML
    private TableColumn<OrdenServicio, String> colFechaHistorial;

    @FXML
    private TableColumn<OrdenServicio, String> colMotivoHistorial;

    @FXML
    private TableColumn<OrdenServicio, String> colDiagnosticoHistorial;

    @FXML
    private TableColumn<OrdenServicio, String> colTrabajoHistorial;

    @FXML
    private TableColumn<OrdenServicio, String> colCostoHistorial;


    // Tabla fecha

    @FXML
    private TableView<OrdenServicio> tablaFecha;

    @FXML
    private TableColumn<OrdenServicio, String> colIdFecha;

    @FXML
    private TableColumn<OrdenServicio, String> colFechaOrden;

    @FXML
    private TableColumn<OrdenServicio, String> colMotivoFecha;

    @FXML
    private TableColumn<OrdenServicio, String> colDiagnosticoFecha;

    @FXML
    private TableColumn<OrdenServicio, String> colTrabajoFecha;

    @FXML
    private TableColumn<OrdenServicio, String> colCostoFecha;


    // =========================
    // CONEXIONES
    // =========================

    public void setApp(App app) {
        this.app = app;
    }

    public void setTallerController(TallerController tallerController) {
        this.tallerController = tallerController;
    }

    //Setup
    @FXML
    public void initialize() {

        configurarTablaHistorial();
        configurarTablaFecha();
    }

    private void configurarTablaHistorial() {

        colIdHistorial.setCellValueFactory(
                new PropertyValueFactory<>("idServicio")
        );

        colFechaHistorial.setCellValueFactory(
                new PropertyValueFactory<>("fechaIngreso")
        );

        colMotivoHistorial.setCellValueFactory(
                new PropertyValueFactory<>("motivoServicio")
        );

        colDiagnosticoHistorial.setCellValueFactory(
                new PropertyValueFactory<>("diagnostico")
        );

        colTrabajoHistorial.setCellValueFactory(
                new PropertyValueFactory<>("trabajoRealizado")
        );

        colCostoHistorial.setCellValueFactory(
                new PropertyValueFactory<>("costoTotal")
        );
    }

    private void configurarTablaFecha() {

        colIdFecha.setCellValueFactory(
                new PropertyValueFactory<>("idServicio")
        );

        colFechaOrden.setCellValueFactory(
                new PropertyValueFactory<>("fechaIngreso")
        );

        colMotivoFecha.setCellValueFactory(
                new PropertyValueFactory<>("motivoServicio")
        );

        colDiagnosticoFecha.setCellValueFactory(
                new PropertyValueFactory<>("diagnostico")
        );

        colTrabajoFecha.setCellValueFactory(
                new PropertyValueFactory<>("trabajoRealizado")
        );

        colCostoFecha.setCellValueFactory(
                new PropertyValueFactory<>("costoTotal")
        );
    }


    // =========================
    // BUSCAR HISTORIAL
    // =========================

    @FXML
    private void handleBuscarSerial() {

        String serial = txtSerial.getText().trim();

        if (serial.isEmpty()) {
            mostrarMensaje(
                    "Error",
                    "Debe ingresar el serial de una bicicleta."
            );
            return;
        }

        LinkedList<OrdenServicio> historial =
                tallerController.buscarHistorialPorSerial(serial);

        if (historial == null) {
            mostrarMensaje(
                    "Bicicleta no encontrada",
                    "No existe una bicicleta registrada con ese serial. \n" +
                            "Serial ingresado: " + serial + "\n"
            );

            tablaHistorial.getItems().clear();
            return;
        }

        tablaHistorial.setItems(
                FXCollections.observableArrayList(historial)
        );
    }


    // =========================
    // BUSCAR POR FECHA
    // =========================

    @FXML
    private void handleBuscarFecha() {

        if (dpFecha.getValue() == null) {
            mostrarMensaje(
                    "Error",
                    "Debe seleccionar una fecha."
            );
            return;
        }

        Date fecha = Date.from(
                dpFecha.getValue()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );

        LinkedList<OrdenServicio> ordenes =
                tallerController.buscarOrdenesPorFecha(fecha);

        tablaFecha.setItems(
                FXCollections.observableArrayList(ordenes)
        );

        if (ordenes.isEmpty()) {
            mostrarMensaje(
                    "Sin resultados",
                    "No hay órdenes de servicio registradas para esa fecha."
            );
        }
    }


    // =========================
    // STOCK
    // =========================

    @FXML
    private void handleStock() {

        String mensaje =
                tallerController.obtenerAlertaStock();

        lblStock.setText(mensaje);
    }


    // =========================
    // MENSAJES
    // =========================

    private void mostrarMensaje(String titulo, String mensaje) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}