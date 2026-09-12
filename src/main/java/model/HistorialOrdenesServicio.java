package model;

public record HistorialOrdenesServicio(OrdenServicio ordenServicio, Cliente theClienteDueno) {
    @Override
    public String toString() {
        return "Fecha de ingreso: " + ordenServicio.getFechaIngreso().toString() + "\n"
                + "Hora de ingreso: " + ordenServicio.getHoraIngreso().toString() + "\n"
                + "Motivo Servicio: " + ordenServicio.getMotivoServicio() + "\n"
                + "Diagnostico: " + (ordenServicio.getDiagnostico() != null ? ordenServicio.getDiagnostico() : "Sin diagnostico") + "\n"
                + "Trabajo realizado: " + (ordenServicio.getTrabajoRealizado() != null ?  ordenServicio.getTrabajoRealizado() : "Sin trabajo realizado") + "\n"
                + "Costo total: " + (ordenServicio.getCostoTotal() != 0.0 ? ordenServicio.getCostoTotal() : "Sin valuar") + "\n"
                + "Mecanico: " + (ordenServicio.getTheMecanicoBicicleta() != null ? ordenServicio.getTheMecanicoBicicleta().getNombre() + ordenServicio.getTheMecanicoBicicleta().getApellido() : "Sin asignar");
    }
}
