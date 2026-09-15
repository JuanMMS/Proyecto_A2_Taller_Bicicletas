package controller;

import model.OrdenServicio;

import java.util.LinkedList;

public class OrdenServicioController {

    private TallerController tallerController;

    public OrdenServicioController(TallerController tallerController) {
        this.tallerController = tallerController;
    }

    public boolean crearOrdenServicio(OrdenServicio ordenServicio) {
        return tallerController.crearOrdenServicio(ordenServicio);
    }

    public LinkedList<OrdenServicio> obtenerListaOrdenServicio() {
        return tallerController.obtenerListaOrdenServicio();
    }

    public boolean eliminarOrdenServicio(String idOrdenServicio) {
        return tallerController.eliminarOrdenServicio(idOrdenServicio);
    }

    public boolean actualizarOrdenServicio(
            String idOrdenServicio,
            OrdenServicio ordenServicio
    ) {
        return tallerController.actualizarOrdenServicio(
                idOrdenServicio,
                ordenServicio
        );
    }

    public String generarIdOrdenServicio() {
        return tallerController.generarIdOrdenServicio();
    }

    public LinkedList<model.Bicicleta> obtenerListaBicicletas() {
        return tallerController.obtenerListaBicicletas();
    }

    public LinkedList<model.Mecanico> obtenerListaMecanicos() {
        return tallerController.obtenerListaMecanicos();
    }
}