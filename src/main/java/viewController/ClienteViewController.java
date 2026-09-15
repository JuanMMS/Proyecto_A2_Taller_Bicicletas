package viewController;

import app.App;
import controller.ClienteController;
import model.Cliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ClienteViewController {

    private App app;

    // Controller de la lógica del sistema
    private ClienteController clienteController;

    // Lista observable de clientes
    private ObservableList<Cliente> listClientes =
            FXCollections.observableArrayList();

    // Cliente seleccionado en la tabla
    private Cliente selectedCliente;

    // Campos del formulario
    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCorreo;

    // Botones
    @FXML
    private Button btnCrear;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    // Tabla
    @FXML
    private TableView<Cliente> tblListCliente;

    @FXML
    private TableColumn<Cliente, String> colCedula;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colTelefono;

    @FXML
    private TableColumn<Cliente, String> colCorreo;


    // Constructor vacío
    public ClienteViewController() {
    }


    // Método para conectar el Controller con el ViewController
    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;

        cargarClientes();
    }


    // Se ejecuta cuando se carga el FXML
    @FXML
    public void initialize() {

        configurarTabla();

        configurarSeleccionTabla();

    }


    // Configurar las columnas de la tabla
    private void configurarTabla() {

        colCedula.setCellValueFactory(
                cellData ->
                        new javafx.beans.property.SimpleStringProperty(
                                cellData.getValue().getNumIdentificacion()
                        )
        );

        colNombre.setCellValueFactory(
                cellData ->
                        new javafx.beans.property.SimpleStringProperty(
                                cellData.getValue().getNombre()
                        )
        );

        colTelefono.setCellValueFactory(
                cellData ->
                        new javafx.beans.property.SimpleStringProperty(
                                cellData.getValue().getTelefono()
                        )
        );

        colCorreo.setCellValueFactory(
                cellData ->
                        new javafx.beans.property.SimpleStringProperty(
                                cellData.getValue().getDireccion()
                        )
        );

    }


    // Configurar la selección de clientes en la tabla
    private void configurarSeleccionTabla() {

        tblListCliente.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {

                            if (newValue != null) {

                                selectedCliente = newValue;

                                mostrarClienteSeleccionado();

                            }

                        }
                );

    }


    // Cargar clientes desde el Controller
    private void cargarClientes() {

        if (clienteController == null) {
            return;
        }

        listClientes.clear();

        listClientes.addAll(
                clienteController.obtenerListaClientes()
        );

        tblListCliente.setItems(listClientes);

    }


    // Botón Crear
    @FXML
    private void onAgregarCliente() {

        agregarCliente();

    }


    // Lógica para crear un cliente
    private void agregarCliente() {

        try {

            Cliente cliente = buildCliente();

            if (clienteController.crearCliente(cliente)) {

                listClientes.add(cliente);

                limpiarCamposCliente();

                mostrarMensaje(
                        "Cliente creado",
                        "El cliente se creó correctamente.",
                        Alert.AlertType.INFORMATION
                );

            } else {

                mostrarMensaje(
                        "Error",
                        "No se pudo crear el cliente.",
                        Alert.AlertType.ERROR
                );

            }

        } catch (Exception e) {

            mostrarMensaje(
                    "Error",
                    e.getMessage(),
                    Alert.AlertType.ERROR
            );

        }

    }


    // Construir un Cliente con los datos del formulario
    private Cliente buildCliente() {

        String cedula = txtCedula.getText();

        String nombre = txtNombre.getText();

        String telefono = txtTelefono.getText();

        String correo = txtCorreo.getText();

        return new Cliente(
                nombre,
                cedula,
                telefono,
                correo
        );

    }


    // Botón Modificar
    @FXML
    private void onActualizarCliente() {

        actualizarCliente();

    }


    // Lógica para actualizar un cliente
    private void actualizarCliente() {

        if (selectedCliente == null) {

            mostrarMensaje(
                    "Aviso",
                    "Seleccione un cliente para modificar.",
                    Alert.AlertType.WARNING
            );

            return;

        }

        try {

            Cliente clienteActualizado = buildCliente();

            String cedulaAnterior =
                    selectedCliente.getNumIdentificacion();

            if (
                    clienteController.actualizarCliente(
                            cedulaAnterior,
                            clienteActualizado
                    )
            ) {

                int index =
                        listClientes.indexOf(selectedCliente);

                listClientes.set(
                        index,
                        clienteActualizado
                );

                limpiarCamposCliente();

                mostrarMensaje(
                        "Cliente actualizado",
                        "El cliente se modificó correctamente.",
                        Alert.AlertType.INFORMATION
                );

            } else {

                mostrarMensaje(
                        "Error",
                        "No se pudo modificar el cliente.",
                        Alert.AlertType.ERROR
                );

            }

        } catch (Exception e) {

            mostrarMensaje(
                    "Error",
                    e.getMessage(),
                    Alert.AlertType.ERROR
            );

        }

    }


    // Botón Eliminar
    @FXML
    private void onEliminarCliente() {

        eliminarCliente();

    }


    // Lógica para eliminar un cliente
    private void eliminarCliente() {

        if (selectedCliente == null) {

            mostrarMensaje(
                    "Aviso",
                    "Seleccione un cliente para eliminar.",
                    Alert.AlertType.WARNING
            );

            return;

        }

        try {

            String cedula =
                    selectedCliente.getNumIdentificacion();

            if (
                    clienteController.eliminarCliente(cedula)
            ) {

                listClientes.remove(selectedCliente);

                limpiarCamposCliente();

                mostrarMensaje(
                        "Cliente eliminado",
                        "El cliente se eliminó correctamente.",
                        Alert.AlertType.INFORMATION
                );

            } else {

                mostrarMensaje(
                        "Error",
                        "No se pudo eliminar el cliente.",
                        Alert.AlertType.ERROR
                );

            }

        } catch (Exception e) {

            mostrarMensaje(
                    "Error",
                    e.getMessage(),
                    Alert.AlertType.ERROR
            );

        }

    }


    // Mostrar los datos del cliente seleccionado
    private void mostrarClienteSeleccionado() {

        txtCedula.setText(
                selectedCliente.getNumIdentificacion()
        );

        txtNombre.setText(
                selectedCliente.getNombre()
        );

        txtTelefono.setText(
                selectedCliente.getTelefono()
        );

        txtCorreo.setText(
                selectedCliente.getDireccion()
        );

    }


    // Botón Limpiar
    @FXML
    private void onLimpiarCampos() {

        limpiarCamposCliente();

    }


    // Limpiar formulario
    private void limpiarCamposCliente() {

        txtCedula.clear();

        txtNombre.clear();

        txtTelefono.clear();

        txtCorreo.clear();

        selectedCliente = null;

        tblListCliente.getSelectionModel()
                .clearSelection();

    }


    // Mostrar mensajes
    private void mostrarMensaje(
            String titulo,
            String contenido,
            Alert.AlertType tipo
    ) {

        Alert alert = new Alert(tipo);

        alert.setTitle(titulo);

        alert.setHeaderText(null);

        alert.setContentText(contenido);

        alert.showAndWait();

    }

    public void setApp(App app) {
        this.app = app;
    }

    // =========================
    // VOLVER A LA VENTANA PRINCIPAL
    // =========================
    @FXML
    private void handleVolverVentanaPrincipal() throws IOException {
        app.abrirVentanaPrincipal();
    }
}