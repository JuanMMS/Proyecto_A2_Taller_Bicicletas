package viewController;

import app.App;
import controller.BicicletaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;
import model.Bicicleta;

import java.io.IOException;

public class BicicletaViewController {
    private App app;

    @FXML
    private TextField txtNumSerial;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtColor;

    @FXML
    private TextField txtAnio;

    @FXML
    private TableView<Bicicleta> tblListBicicleta;

    @FXML
    private TableColumn<Bicicleta, String> colNumSerial;

    @FXML
    private TableColumn<Bicicleta, String> colMarca;

    @FXML
    private TableColumn<Bicicleta, String> colColor;

    @FXML
    private TableColumn<Bicicleta, String> colAnio;

    private ObservableList<Bicicleta> listBicicletas;

    private Bicicleta selectedBicicleta;

    private BicicletaController bicicletaController;


    @FXML
    public void initialize() {

        colNumSerial.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getNumSerial()
                )
        );

        colMarca.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getMarca()
                )
        );

        colColor.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getColor()
                )
        );

        colAnio.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        cellData.getValue().getAnio()
                )
        );

        tblListBicicleta.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue) ->
                                seleccionarBicicleta(newValue)
                );
    }


    public void setBicicletaController(
            BicicletaController bicicletaController) {

        this.bicicletaController = bicicletaController;

        cargarBicicletas();
    }


    private void cargarBicicletas() {

        if (bicicletaController == null) {
            return;
        }

        listBicicletas = FXCollections.observableArrayList(
                bicicletaController.obtenerListaBicicletas()
        );

        tblListBicicleta.setItems(listBicicletas);
    }


    @FXML
    private void onAgregarBicicleta() {
        try {

            Bicicleta bicicleta = buildBicicleta();

            boolean agregado =
                    bicicletaController.crearBicicleta(bicicleta);

            if (agregado) {
                //int index = listBicicletas.indexOf(selectedBicicleta);

                //listBicicletas.set(index, bicicleta);

                mostrarMensaje(
                        Alert.AlertType.INFORMATION,
                        "Bicicleta creada",
                        "La bicicleta fue creada correctamente."
                );

                cargarBicicletas();
                limpiarCampos();

            } else {

                mostrarMensaje(
                        Alert.AlertType.ERROR,
                        "Error",
                        "No fue posible crear la bicicleta."
                );
            }

        } catch (Exception e) {

            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Datos inválidos",
                    "Verifique la información ingresada."
            );
        }
    }


    @FXML
    private void onActualizarBicicleta() {

        if (selectedBicicleta == null) {

            mostrarMensaje(
                    Alert.AlertType.WARNING,
                    "Selección requerida",
                    "Seleccione una bicicleta de la tabla."
            );

            return;
        }

        try {

            Bicicleta bicicletaActualizada = buildBicicleta();

            String serialAnterior = selectedBicicleta.getNumSerial();

            boolean actualizado = bicicletaController.actualizarBicicleta(serialAnterior, bicicletaActualizada);

            if (actualizado) {

                int index = listBicicletas.indexOf(selectedBicicleta);
                listBicicletas.set(index, bicicletaActualizada);

                mostrarMensaje(
                        Alert.AlertType.INFORMATION,
                        "Bicicleta actualizada",
                        "La bicicleta fue actualizada correctamente."
                );

                cargarBicicletas();
                limpiarCampos();

            } else {

                mostrarMensaje(
                        Alert.AlertType.ERROR,
                        "Error",
                        "No fue posible actualizar la bicicleta."
                );
            }

        } catch (Exception e) {

            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Datos inválidos",
                    "Verifique la información ingresada."
            );
        }
    }


    @FXML
    private void onEliminarBicicleta() {

        if (selectedBicicleta == null) {

            mostrarMensaje(
                    Alert.AlertType.WARNING,
                    "Selección requerida",
                    "Seleccione una bicicleta de la tabla."
            );

            return;
        }

        boolean eliminado =
                bicicletaController.eliminarBicicleta(
                        selectedBicicleta.getNumSerial()
                );

        if (eliminado) {

            mostrarMensaje(
                    Alert.AlertType.INFORMATION,
                    "Bicicleta eliminada",
                    "La bicicleta fue eliminada correctamente."
            );

            cargarBicicletas();
            limpiarCampos();

        } else {

            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No fue posible eliminar la bicicleta."
            );
        }
    }


    @FXML
    private void onLimpiarCampos() {

        limpiarCampos();
    }


    private Bicicleta buildBicicleta() {

        String numSerial = txtNumSerial.getText();
        String marca = txtMarca.getText();
        String color = txtColor.getText();
        String anio = txtAnio.getText();

        return new Bicicleta(
                marca,
                color,
                numSerial,
                anio
        );
    }


    private void seleccionarBicicleta(Bicicleta bicicleta) {

        selectedBicicleta = bicicleta;

        if (bicicleta != null) {

            txtNumSerial.setText(bicicleta.getNumSerial());
            txtMarca.setText(bicicleta.getMarca());
            txtColor.setText(bicicleta.getColor());
            txtAnio.setText(bicicleta.getAnio());
        }
    }


    private void limpiarCampos() {

        txtNumSerial.clear();
        txtMarca.clear();
        txtColor.clear();
        txtAnio.clear();

        selectedBicicleta = null;

        tblListBicicleta.getSelectionModel().clearSelection();
    }


    private void mostrarMensaje(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {

        Alert alert = new Alert(tipo);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private void handleVolverVentanaPrincipal() throws IOException {
        app.abrirVentanaPrincipal();
    }
}
