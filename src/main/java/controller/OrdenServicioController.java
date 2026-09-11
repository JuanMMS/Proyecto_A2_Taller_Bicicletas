package controller;

import model.OrdenServicio;
import model.Taller;

import java.util.Collection;

public class OrdenServicioController {
    Taller taller;
    public OrdenServicioController(Taller taller) { this.taller = taller;}

    public boolean crearOrdenServicio(OrdenServicio ordenServicio) {return taller.agregarOrdenServicio(ordenServicio);};

    public Collection<OrdenServicio>  obtenerListaOrdenServicio() {return taller.getOrdenesServicio();}

    public boolean eliminarOrdenServicio(String idOrdenServicio) {return taller.eliminarOrdenServicio(idOrdenServicio);};

    public boolean actualizarOrdenServicio(String idOrdenServicio, OrdenServicio ordenServicio) {
        return taller.actualizarOrdenServicio(idOrdenServicio, ordenServicio);
    }
}
