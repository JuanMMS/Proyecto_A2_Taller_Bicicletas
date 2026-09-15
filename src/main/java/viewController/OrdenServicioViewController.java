package viewController;

import app.App;
import controller.OrdenServicioController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Bicicleta;
import model.Mecanico;
import model.OrdenServicio;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class OrdenServicioViewController implements Initializable {

    private App app;

    private OrdenServicioController ordenServicioController;

    @FXML
    private DatePicker dpFechaIngreso;

    @FXML
    private TextField txtHoraIngreso;

    @FXML
    private ComboBox<Bicicleta> cbBicicleta;

    @FXML
    private ComboBox<Mecanico> cbMecanico;

    @FXML
    private TextArea txtMotivoServicio;

    @FXML
    private TextArea txtDiagnostico;

    @FXML
    private TextArea txtTrabajoRealizado;

    @FXML
    private TextField txtCostoTotal;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnCancelar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dpFechaIngreso.setValue(LocalDate.now());
        txtHoraIngreso.setText(
                LocalTime.now().withNano(0).toString()
        );
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setOrdenServicioController(
            OrdenServicioController ordenServicioController
    ) {
        this.ordenServicioController = ordenServicioController;
        cargarDatosCombos();
    }

    private void cargarDatosCombos() {

        if (ordenServicioController == null) {
            return;
        }

        ObservableList<Bicicleta> listaBicicletas =
                FXCollections.observableArrayList(
                        ordenServicioController.obtenerListaBicicletas()
                );

        ObservableList<Mecanico> listaMecanicos =
                FXCollections.observableArrayList(
                        ordenServicioController.obtenerListaMecanicos()
                );

        cbBicicleta.setItems(listaBicicletas);
        cbMecanico.setItems(listaMecanicos);
    }

    /**
     * Maneja el evento de guardar la orden de servicio.
     */
    @FXML
    private void handleGuardarOrden(ActionEvent event) {
        if (validarCampos()) {
            try {
                LocalDate fechaIngresoLocal = dpFechaIngreso.getValue();
                LocalTime horaIngresoLocal = LocalTime.parse(txtHoraIngreso.getText().trim());

                Date fechaIngreso = Date.valueOf(fechaIngresoLocal);
                Time horaIngreso = Time.valueOf(horaIngresoLocal);

                Bicicleta bicicleta = cbBicicleta.getValue();
                Mecanico mecanico = cbMecanico.getValue();

                String motivoServicio =
                        txtMotivoServicio.getText().trim();

                String diagnostico =
                        txtDiagnostico.getText().trim();

                String trabajoRealizado =
                        txtTrabajoRealizado.getText().trim();

                double costoTotal =
                        Double.parseDouble(txtCostoTotal.getText().trim());

                // Generar ID único mediante el controller
                String idServicio =
                        ordenServicioController.generarIdOrdenServicio();

                // Crear la nueva orden
                OrdenServicio nuevaOrden = new OrdenServicio(
                        fechaIngreso,
                        horaIngreso,
                        motivoServicio,
                        diagnostico,
                        trabajoRealizado,
                        costoTotal,
                        idServicio,
                        mecanico,
                        bicicleta
                );

                // Registrar la orden mediante el controller
                boolean creada =
                        ordenServicioController.crearOrdenServicio(nuevaOrden);

                if (creada) {

                    mostrarAlerta(
                            Alert.AlertType.INFORMATION,
                            "Éxito",
                            "Orden registrada",
                            "La orden " + idServicio
                                    + " fue registrada correctamente."
                    );

                    limpiarFormulario();

                } else {

                    mostrarAlerta(
                            Alert.AlertType.WARNING,
                            "Orden no registrada",
                            "No se pudo registrar la orden",
                            "Ya existe una orden con ese identificador."
                    );
                }

            } catch (DateTimeParseException e) {

                mostrarAlerta(
                        Alert.AlertType.ERROR,
                        "Error de Formato",
                        "Formato de Hora Inválido",
                        "Ingrese la hora en formato HH:mm o HH:mm:ss."
                );

            } catch (NumberFormatException e) {

                mostrarAlerta(
                        Alert.AlertType.ERROR,
                        "Error de Formato",
                        "Costo Inválido",
                        "Ingrese un valor numérico válido."
                );

            } catch (Exception e) {

                mostrarAlerta(
                        Alert.AlertType.ERROR,
                        "Error",
                        "No se pudo guardar la orden",
                        e.getMessage()
                );
            }
        }
    }

    /**
     * Maneja el evento de limpiar el formulario.
     */
    @FXML
    private void handleLimpiar(ActionEvent event) {
        limpiarFormulario();
    }

    /**
     * Maneja el evento de cancelar y cerrar la ventana actual.
     */
    @FXML
    private void handleCancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    /**
     * Valida que los campos requeridos estén correctamente diligenciados.
     */
    private boolean validarCampos() {
        StringBuilder mensajeError = new StringBuilder();

        if (dpFechaIngreso.getValue() == null) {
            mensajeError.append("- Seleccione una fecha de ingreso.\n");
        }
        if (txtHoraIngreso.getText() == null || txtHoraIngreso.getText().trim().isEmpty()) {
            mensajeError.append("- Ingrese la hora de ingreso.\n");
        }
        if (cbBicicleta.getValue() == null) {
            mensajeError.append("- Seleccione una bicicleta.\n");
        }
        if (cbMecanico.getValue() == null) {
            mensajeError.append("- Seleccione un mecánico responsable.\n");
        }
        if (txtMotivoServicio.getText() == null || txtMotivoServicio.getText().trim().isEmpty()) {
            mensajeError.append("- Ingrese el motivo del servicio.\n");
        }
        if (txtCostoTotal.getText() == null || txtCostoTotal.getText().trim().isEmpty()) {
            mensajeError.append("- Ingrese el costo total.\n");
        }

        if (mensajeError.length() > 0) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos Incompletos", "Diligencie los campos requeridos",
                    mensajeError.toString());
            return false;
        }
        return true;
    }

    /**
     * Restablece todos los controles del formulario a su estado inicial.
     */
    private void limpiarFormulario() {
        dpFechaIngreso.setValue(LocalDate.now());
        txtHoraIngreso.setText(LocalTime.now().withNano(0).toString());
        cbBicicleta.getSelectionModel().clearSelection();
        cbMecanico.getSelectionModel().clearSelection();
        txtMotivoServicio.clear();
        txtDiagnostico.clear();
        txtTrabajoRealizado.clear();
        txtCostoTotal.clear();
    }

    /**
     * Muestra una ventana emergente de alerta al usuario.
     */
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String cabecera, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}

