package controller;

import model.Bicicleta;
import model.Mecanico;
import model.OrdenServicio;
import model.Taller;

import java.util.Date;
import java.util.LinkedList;

public class TallerController {

    private Taller taller;

    public TallerController(Taller taller) {
        this.taller = taller;
    }

    // =========================
    // BICICLETAS
    // =========================

    public LinkedList<Bicicleta> obtenerListaBicicletas() {
        return taller.getListBicicletas();
    }

    // =========================
    // MECÁNICOS
    // =========================

    public LinkedList<Mecanico> obtenerListaMecanicos() {
        return taller.getListMecanicos();
    }

    // =========================
    // ÓRDENES DE SERVICIO
    // =========================

    public boolean crearOrdenServicio(OrdenServicio ordenServicio) {
        return taller.agregarOrdenServicio(ordenServicio);
    }

    public LinkedList<OrdenServicio> obtenerListaOrdenServicio() {
        return taller.getOrdenesServicio();
    }

    public boolean eliminarOrdenServicio(String idOrdenServicio) {
        return taller.eliminarOrdenServicio(idOrdenServicio);
    }

    public boolean actualizarOrdenServicio(
            String idOrdenServicio,
            OrdenServicio ordenServicio
    ) {
        return taller.actualizarOrdenServicio(
                idOrdenServicio,
                ordenServicio
        );
    }

    public String generarIdOrdenServicio() {

        int siguienteNumero = 1;

        for (OrdenServicio orden : taller.getOrdenesServicio()) {

            String id = orden.getIdServicio();

            if (id != null && id.startsWith("OS-")) {
                try {
                    int numero = Integer.parseInt(id.substring(3));

                    if (numero >= siguienteNumero) {
                        siguienteNumero = numero + 1;
                    }

                } catch (NumberFormatException e) {
                    // Si el ID no tiene el formato esperado, lo ignoramos
                }
            }
        }

        return String.format("OS-%03d", siguienteNumero);
    }

    // =========================
    // CONSULTAS
    // =========================

    public LinkedList<OrdenServicio> buscarHistorialPorSerial(String serial) {
        return taller.getHistorialServicioSerial(serial);
    }

    public LinkedList<OrdenServicio> buscarOrdenesPorFecha(Date fecha) {
        return taller.getHistorialServicioFecha(fecha);
    }

    // =========================
    // STOCK
    // =========================

    public String obtenerAlertaStock() {
        return taller.crearMensajeAlertaStockBajo();
    }
}