package controller;


import model.Cliente;
import model.Taller;

import java.util.Collection;

public class ClienteController {

    private Taller taller;

    public ClienteController(Taller taller) {
        this.taller = taller;
    }

    public boolean crearCliente(Cliente cliente) {
        return taller.agregarCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return taller.getListClientes();
    }

    public boolean eliminarCliente(String cedula) {
        return taller.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(
            String cedula,
            Cliente cliente
    ) {

        return taller.actualizarCliente(
                cedula,
                cliente
        );

    }

}