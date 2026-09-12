package model;

import java.sql.Time;
import java.util.Date;

public record HistorialServicios(OrdenServicio ordenServicio, Cliente cliente) {
    @Override
    public String toString() {
        return "Dueno de la Bicicleta: " + cliente.getNombre() + " " + cliente.getApellido() + ". Detalles del servicio { \n" + ordenServicio.toString() + "\n }";
    }
}
