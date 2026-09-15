package viewController;

import app.App;
import controller.MecanicoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Mecanico;

import java.io.IOException;

public class MecanicoViewController {
    private App app;


    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableView<Mecanico> tblListMecanico;

    @FXML
    private TableColumn<Mecanico, String> colId;

    @FXML
    private TableColumn<Mecanico, String> colNombre;

    @FXML
    private TableColumn<Mecanico, String> colApellido;

    private ObservableList<Mecanico> listMecanicos;

    private Mecanico selectedMecanico;

    private MecanicoController mecanicoController;


    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getId()
                )
        );

        colNombre.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getNombre()
                )
        );

        colApellido.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getApellido()
                )
        );

        tblListMecanico.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue) -> seleccionarMecanico(newValue)
                );
    }


    public void setMecanicoController(MecanicoController mecanicoController) {

        this.mecanicoController = mecanicoController;

        cargarMecanicos();
    }


    private void cargarMecanicos() {

        if (mecanicoController == null) {
            return;
        }

        listMecanicos = FXCollections.observableArrayList(
                mecanicoController.obtenerListaMecanicos()
        );

        tblListMecanico.setItems(listMecanicos);
    }


    @FXML
    private void onAgregarMecanico() {

        try {

            Mecanico mecanico = buildMecanico();

            boolean agregado = mecanicoController.crearMecanico(mecanico);

            if (agregado) {

                mostrarMensaje(
                        Alert.AlertType.INFORMATION,
                        "Mecánico creado",
                        "El mecánico fue creado correctamente."
                );

                cargarMecanicos();
                limpiarCampos();

            } else {

                mostrarMensaje(
                        Alert.AlertType.ERROR,
                        "Error",
                        "No fue posible crear el mecánico."
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
    private void onActualizarMecanico() {

        if (selectedMecanico == null) {

            mostrarMensaje(
                    Alert.AlertType.WARNING,
                    "Selección requerida",
                    "Seleccione un mecánico de la tabla."
            );

            return;
        }

        try {

            Mecanico mecanico = buildMecanico();

            boolean actualizado = mecanicoController.actualizarMecanico(
                    selectedMecanico.getId(),
                    mecanico
            );

            if (actualizado) {

                mostrarMensaje(
                        Alert.AlertType.INFORMATION,
                        "Mecánico actualizado",
                        "El mecánico fue actualizado correctamente."
                );

                cargarMecanicos();
                limpiarCampos();

            } else {

                mostrarMensaje(
                        Alert.AlertType.ERROR,
                        "Error",
                        "No fue posible actualizar el mecánico."
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
    private void onEliminarMecanico() {

        if (selectedMecanico == null) {

            mostrarMensaje(
                    Alert.AlertType.WARNING,
                    "Selección requerida",
                    "Seleccione un mecánico de la tabla."
            );

            return;
        }

        boolean eliminado = mecanicoController.eliminarMecanico(
                selectedMecanico.getId()
        );

        if (eliminado) {

            mostrarMensaje(
                    Alert.AlertType.INFORMATION,
                    "Mecánico eliminado",
                    "El mecánico fue eliminado correctamente."
            );

            cargarMecanicos();
            limpiarCampos();

        } else {

            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No fue posible eliminar el mecánico."
            );
        }
    }


    @FXML
    private void onLimpiarCampos() {

        limpiarCampos();
    }


    private Mecanico buildMecanico() {

        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();

        return new Mecanico(
                nombre,
                apellido,
                id
        );
    }


    private void seleccionarMecanico(Mecanico mecanico) {

        selectedMecanico = mecanico;

        if (mecanico != null) {

            txtId.setText(mecanico.getId());
            txtNombre.setText(mecanico.getNombre());
            txtApellido.setText(mecanico.getApellido());
        }
    }


    private void limpiarCampos() {

        txtId.clear();
        txtNombre.clear();
        txtApellido.clear();

        selectedMecanico = null;

        tblListMecanico.getSelectionModel().clearSelection();
    }


    private void mostrarMensaje(
            Alert.AlertType tipo,
            String titulo,
            String mensaje
    ) {

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