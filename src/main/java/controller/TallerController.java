package controller;

import model.OrdenServicio;
import model.Taller;

import java.util.Date;
import java.util.LinkedList;

public class TallerController {

    private Taller taller;

    public TallerController(Taller taller) {
        this.taller = taller;
    }

    // Buscar historial de servicios de una bicicleta por su serial
    public LinkedList<OrdenServicio> buscarHistorialPorSerial(String serial) {
        return taller.getHistorialServicioSerial(serial);
    }

    // Buscar órdenes de servicio realizadas en una fecha
    public LinkedList<OrdenServicio> buscarOrdenesPorFecha(Date fecha) {
        return taller.getHistorialServicioFecha(fecha);
    }

    // Obtener mensaje de alerta de stock
    public String obtenerAlertaStock() {
        return taller.crearMensajeAlertaStockBajo();
    }
}